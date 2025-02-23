import java.sql.DriverManager

class StudentListDB {

    fun getStudentById(id: Int) : Student? {
        val resultSet = Database.executeQuery("SELECT * FROM Student WHERE \"id\" = $id")
        return if (resultSet.next()) Student(mapOf(
            "id" to resultSet.getInt("id"),
            "surname" to resultSet.getString("surname"),
            "name" to resultSet.getString("name"),
            "lastname" to resultSet.getString("lastname"),
            "phone" to resultSet.getString("phone"),
            "telegram" to resultSet.getString("telegram"),
            "email" to resultSet.getString("email"),
            "git" to resultSet.getString("git")
        )) else null
    }

    fun getStudentShortList(k: Int, n: Int) : Data_list_short {
        if (k < 1) throw IllegalArgumentException("Значение k должно быть больше или равно 1")
        if (n < 0) throw IllegalArgumentException("Значение n не должно быть отрицательным")
        val firstElem = (k - 1) * n
        val resultSet = Database.executeQuery("SELECT * FROM Student LIMIT $firstElem, $n")
        val studentsSlice = buildList {
            while (resultSet.next()) {
                add(Student_short(Student(mapOf(
                    "id" to resultSet.getInt("id"),
                    "surname" to resultSet.getString("surname"),
                    "name" to resultSet.getString("name"),
                    "lastname" to resultSet.getString("lastname"),
                    "phone" to resultSet.getString("phone"),
                    "telegram" to resultSet.getString("telegram"),
                    "email" to resultSet.getString("email"),
                    "git" to resultSet.getString("git")
                ))))
            }
        }
        return Data_list_short(studentsSlice)
    }

    fun add(student: Student) {
        val sql = "INSERT INTO Student" +
                "(\"surname\", \"name\", \"lastname\", \"phone\", \"telegram\", \"email\", \"git\")" +
                "VALUES (?, ?, ?, ?, ?, ?, ?)"
        Database.executeUpdate(sql) {
            it.setString(1, student.surname)
            it.setString(2, student.name)
            it.setString(3, student.lastname)
            it.setString(4, student.phone)
            it.setString(5, student.telegram)
            it.setString(6, student.email)
            it.setString(7, student.git)
        }
    }

    fun replace(id: Int, newStudent: Student) {
        val sql = "UPDATE Student SET \"surname\" = ?, \"name\" = ?, \"lastname\" = ?," +
                "\"phone\" = ?, \"telegram\" = ?, \"email\" = ?, \"git\" = ?" +
                "WHERE id = ?"
        Database.executeUpdate(sql) {
            it.setString(1, newStudent.surname)
            it.setString(2, newStudent.name)
            it.setString(3, newStudent.lastname)
            it.setString(4, newStudent.phone)
            it.setString(5, newStudent.telegram)
            it.setString(6, newStudent.email)
            it.setString(7, newStudent.git)
            it.setInt(8, id)
        }
    }

    fun remove(id: Int) : Boolean {
        val sql = "DELETE FROM Student WHERE \"id\" = ?"
        return Database.executeUpdate(sql) { it.setInt(1, id) } > 0
    }

    fun getStudentShortCount() : Int {
        val resultSet = Database.executeQuery("SELECT count(*) AS cnt FROM Student")
        resultSet.next()
        return resultSet.getInt(1)
    }
}