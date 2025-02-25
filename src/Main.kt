import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
fun printDataTable(dataTable: Data_table) {
    for (i in 0..<dataTable.getRowCount()) {
        for (j in 0..<dataTable.getColCount()) {
            print("${dataTable[i, j]} ")
        }
        println()
    }
}
fun main() {
//////lab1
//    val students = mutableListOf<Student>(
//        Student(
//            1,
//            "Иванов",
//            "Иван",
//            "Иванович",
//            "+79123456789",
//            "@ivanov",
//            "ivanov@example.com",
//            "https://github.com/ivanov"
//        ),
//        Student(2, "Петров", "Петр", "Петрович", git = "https://github.com/petrov"),
//        Student(3, "Линдеманн", "Тилль", "Вернерович", "+88005553535", email = "duhast@gmail.com"),
//        Student(4, "Шевякин", "Артём", "Анатольевич"),
//    )

    //students.forEach { it.show() }

//    val student1 = Student(5, "Иванов", "Иван", "Иванович", "+79123456789")
//    val student2 = Student(6, "Иванов", "Иван", "Иванович", "ivanov@example.com", "https://github.com/ivanov")
//
//    student1.show()
//    student2.show()
//
//    val student3 = Student(mapOf(
//        "id" to 7,
//        "surname" to "Шевякин",
//        "name" to "Артём",
//        "lastname" to "Анатольевич"
//    ))
//    val student4 = Student(mapOf(
//        "id" to 8,
//        "surname" to "Хэшев",
//        "name" to "Хэш",
//        "lastname" to "Хэшевич",
//        "phone" to "+79876543210",
//        "telegram" to "@hash123",
//        "email" to "hash@example.com",
//        "git" to "https://github.com/hash123"
//    ))
//    student3.show()
//    student4.show()
//Not fitting the regular expressions
    //val student5 = Student(9, "Иванов", "Иван", "Иванович", "+91915553")
    //val student6 = Student(10, "Иванов", "Иван", "Иванович", "ivanovexample.com", "https://github.comivanov")

//    students.forEach { it.checkGit() }
//    students.forEach { it.checkContact() }
//    students[0].set_contacts(mapOf("telegram" to null, "email" to "test123@example.com"))
//    students[0].show()


/////////lab2
    //val student5 = Student("5;Иванов;Иван;Иванович;+79123456789;@ivanov;ivanov@example.com;https://github.com/ivanov")
    //student5.show()
    //Student("5;I;Am;Megatron;;;decepticon_leader@evil.com;")
    //Test parsing exceptions
    //Student(";;;;;;;")
    //Student("6;;;;;;;")
    //Student("6;Ф;И;О;+79123456789;;;")
    //Student("123")
    //Student("")
    //Student("6;Ф;И;О")
    //Student("6;Ф;И;О;abc;;;;")
    //Student("6;Ф;И;О;;@test\n123;;")

    //students.forEach { println(it.getInfo()) }

//    val shortStudents = mutableListOf(
//        Student_short(students[0]),
//        Student_short(students[1]),
//        Student_short(students[2]),
//        Student_short(students[3]),
//        Student_short(5, "Student Линдеманн Т.В., git not added, contact using phone: +88005553535")
//    )
//    shortStudents.forEach { it.show() }
//
//    println("reading test")
//    val studList = Student.readFromTxt("lab2_input.txt")
//    studList.forEach { println(it.getInfo()) }
//
//    Student.writeToTxt("lab2_output.txt", studList)
//    val studList2 = Student.readFromTxt("lab2_output.txt")
//    println("writing test")
//    studList2.forEach { println(it.getInfo()) }
//    require(studList2.toString() == studList.toString())


    /////////lab 2.2
//    shortStudents.forEach { it.show() }
//    val dataList = Data_list_short(shortStudents)
//    val names = dataList.getNames()
//    dataList.select(0)
//    dataList.select(2)
//    println(dataList.getSelected())
//    println(names)
//    val dataTable = dataList.getData()
//    for (i in 0..<dataTable.getRowCount()) {
//        for (j in 0..<dataTable.getColCount()) {
//            print("${dataTable[i, j]} ")
//        }
//        println()
//    }
//
/////lab 3
//    fun printDataTable(dataTable: Data_table) {
//        for (i in 0..<dataTable.getRowCount()) {
//            for (j in 0..<dataTable.getColCount()) {
//                print("${dataTable[i, j]} ")
//            }
//            println()
//        }
//    }
//
//    println("txt")
//    val studentsformat = Studlist(TXTFormatStrategy())
//    studentsformat.load("lab2_input.txt")
//    println(studentsformat.getStudentShortCount())
//    for (id in -1..6) {
//        try {
//            println(studentsformat.getStudentById(id).toStringRow())
//        } catch (e: IllegalArgumentException) {
//            println(e.message)
//        }
//    }
//    println()
//
//    printDataTable(studentsformat.getStudentShortList(1, 3).getData())
//    println("=========================")
//    printDataTable(studentsformat.getStudentShortList(1, 0).getData())
//    println("=========================")
////    printDataTable(students.getStudentShortList(0, 3).getData())
////    println("=========================")
////    printDataTable(students.getStudentShortList(1, -1).getData())
////    println("=========================")
//    printDataTable(studentsformat.getStudentShortList(1, 100).getData())
//    println("=========================")
//    printDataTable(studentsformat.getStudentShortList(2, 100).getData())
//    println("=========================")
//    printDataTable(studentsformat.getStudentShortList(3, 1).getData())
//    println("=========================")
//    printDataTable(studentsformat.getStudentShortList(2, 3).getData())
//    println("=========================")
//    printDataTable(studentsformat.getStudentShortList(1, 5).getData())
//    println("=========================")
//    printDataTable(studentsformat.getStudentShortList(1, 6).getData())
//    println()
//
//    studentsformat.sortByStudentName()
//    printDataTable(studentsformat.getStudentShortList(1, 5).getData())
//    println()
//
//    students.add(Student(0, "Новый", "Студент", "Хе-хе"))
//    printDataTable(studentsformat.getStudentShortList(1, 100).getData())
//    println(studentsformat.getStudentById(6).toStringRow())
//    studentsformat.replace(6, Student(0, "Изменённый", "Студент", "Хе-хе"))
//    println(studentsformat.getStudentById(6).toStringRow())
//    println()
//    studentsformat.remove(6)
//    for (id in 1..7) {
//        try {
//            println(studentsformat.getStudentById(id).toStringRow())
//        } catch (e: IllegalArgumentException) {
//            println(e.message)
//        }
//    }
//    println()
//    studentsformat.add(Student(0, "Вернувшийся", "Студент", "Хе-хе"))
//    studentsformat.add(Student(0, "Студент", "Номер", "Восемь"))
//    for (id in 1..9) {
//        try {
//            println(studentsformat.getStudentById(id).toStringRow())
//        } catch (e: IllegalArgumentException) {
//            println(e.message)
//        }
//    }
//    println(studentsformat.getStudentShortCount())
//    studentsformat.save("lab3_output.txt")
//
//    //json
//    println("json")
//    studentsformat.formatStrategy = JSONFormatStrategy()
//    val students2 = Studlist(JSONFormatStrategy())
//    students2.load("lab3_output.json")
//    println(studentsformat.getStudentShortCount())
//    for (id in -1..7) {
//        try {
//            println(studentsformat.getStudentById(id).toStringRow())
//        } catch (e: IllegalArgumentException) {
//            println(e.message)
//        }
//    }
//
//    //yaml
//    println("yaml")
//
//
//    studentsformat.formatStrategy = YAMLFormatStrategy()
//    students2.formatStrategy = YAMLFormatStrategy()
//    students2.load("lab3_output.yaml")
//    println(studentsformat.getStudentShortCount())
//    for (id in -1..7) {
//        try {
//            println(studentsformat.getStudentById(id).toStringRow())
//        } catch (e: IllegalArgumentException) {
//            println(e.message)
//        }
//    }

    //////lab4

//
//    val students = StudentListDB()
//    Database.connect()
//    println(students.getStudentById(1)?.toStringRow())
//    println(students.getStudentById(0))
//    println()
//    printDataTable(students.getStudentShortList(3, 2).getData())
//    println()
//    printDataTable(students.getStudentShortList(2, 4).getData())
//    println()
//    println(students.getStudentShortCount())
//    students.add(Student(0, "Новый", "Студент", "Хе-хе"))
//    println(students.getStudentShortCount())
//    println(students.getStudentById(8)?.toStringRow())
//    println(students.getStudentById(9)?.toStringRow())
//    students.remove(7)
//    println(students.remove(5))
//    students.add(Student(0, "Ещё", "Студент", "", email = "123@456.789"))
//    students.replace(8, Student(0, "Изменённый", "Студент", "", telegram = "@skullemoji"))

///////lab5

    val studentsDB = StudentListDB()
    Database.connect()

    val studentsTXT = Studlist(TXTFormatStrategy())
    studentsTXT.load("lab2_input.txt")
    val studentsJSON = Studlist(JSONFormatStrategy())
    studentsJSON.load("lab3_output.json")

    val students1 = StudentList(studentsDB)
    val students2 = StudentList(StudentListFileAdapter(studentsTXT))
    val students3 = StudentList(StudentListFileAdapter(studentsJSON))

    for (students in listOf(students1, students2, students3)) {
        println("BEGIN")
        println()
        println(students.getStudentById(1)?.toStringRow())
        println(students.getStudentById(0))
        println()
        printDataTable(students.getStudentShortList(3, 2).getData())
        println()
        printDataTable(students.getStudentShortList(2, 4).getData())
        println()
        println(students.getStudentShortCount())
        students.add(Student(0, "Новый", "Студент", "Хе-хе"))
        println(students.getStudentShortCount())
        println(students.getStudentById(8)?.toStringRow())
        println(students.getStudentById(9)?.toStringRow())
        students.remove(7)
        println(students.remove(5))
        students.add(Student(0, "Ещё", "Студент", "", email = "123@456.789"))
        students.replace(8, Student(0, "Изменённый", "Студент", "", telegram = "@skullemoji"))
        println(students.remove(0))
        println(students.remove(100))
        println()
    }


}