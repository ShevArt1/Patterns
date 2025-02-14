import java.io.File
import java.io.FileNotFoundException
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
@Serializable
data class StudentSurrogate(val id: Int,
                            val surname: String,
                            val name: String,
                            val lastname: String,
                            val phone: String? = null,
                            val telegram: String? = null,
                            val email: String? = null,
                            val git: String? = null) {
    constructor(student: Student) : this(student.id,
        student.surname,
        student.name,
        student.lastname,
        student.phone,
        student.telegram,
        student.email,
        student.git)
}
class Studlist_json {
    private var students = mutableMapOf<Int, Student>()
    private var autoIncrementNextId = 1
    fun load(filepath: String) {
        val file = File(filepath)
        if (!file.exists()) throw FileNotFoundException("Файл '$filepath' не найден")
        students = Json.decodeFromString<Array<StudentSurrogate>>(file.readText()).map {
            Student(it.id, it.surname, it.name, it.lastname, it.phone, it.telegram, it.email, it.git)
        }.associateBy({ it.id }, { it }).toMutableMap()
        autoIncrementNextId = (students.keys.maxOrNull() ?: 0) + 1
    }
    fun save(filepath: String) {
        val file = File(filepath)
        val jsonString = Json.encodeToString(students.values.map { StudentSurrogate(it) })
        file.writeText(jsonString)
    }
    fun getStudentById(id: Int) = students[id] ?: throw IllegalArgumentException("Студент с ID $id не найден")
    fun getStudentShortList(k: Int, n: Int) : Data_list_short {
        if (k < 1) throw IllegalArgumentException("Значение k должно быть больше или равно 1")
        if (n < 0) throw IllegalArgumentException("Значение n не должно быть отрицательным")
        val studList = students.values.toList()
        val firstElem = (k - 1) * n
        if (firstElem >= studList.size || n == 0) return Data_list_short(listOf())
        val lastElem = (firstElem + n - 1).coerceAtMost(studList.size - 1)
        return Data_list_short(students.values.toList().slice(firstElem..lastElem).map {
            Student_short(it)
        })
    }
    fun sortByStudentName() {
        students = students.toList()
            .sortedBy { "${it.second.surname} ${it.second.name} ${it.second.lastname}" }
            .toMap().toMutableMap()
    }
    fun add(student: Student) {
        students[autoIncrementNextId] = student.copyWithChangedId(autoIncrementNextId)
        autoIncrementNextId++
    }
    fun replace(id: Int, newStudent: Student) {
        if (!students.containsKey(id)) throw IllegalArgumentException("Студент с ID $id не найден")
        students[id] = newStudent.copyWithChangedId(id)
    }
    fun remove(id: Int) {
        if (!students.containsKey(id)) throw IllegalArgumentException("Студент с ID $id не найден")
        students.remove(id)
    }
    fun getStudentShortCount() = students.size
}