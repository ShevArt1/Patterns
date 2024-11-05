fun main() {
//////lab1
    val students = mutableListOf<Student>(
        Student(1, "Иванов","Иван", "Иванович", "+79123456789", "@ivanov", "ivanov@example.com", "https://github.com/ivanov"),
        Student(2, "Петров","Петр", "Петрович", git= "https://github.com/petrov"),
        Student(3, "Линдеманн","Тилль", "Вернерович", "+88005553535", email="duhast@gmail.com"),
        Student(4, "Шевякин","Артём", "Анатольевич"),
        )

    students.forEach { it.show() }

//    val student1 = Student(5, "Иванов", "Иван", "Иванович", "+79123456789")
//    val student2 = Student(6, "Иванов", "Иван", "Иванович", "ivanov@example.com", "https://github.com/ivanov")
//
//    student1.show()
//    student2.show()

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

    students.forEach { it.checkGit() }
    students.forEach { it.checkContact() }
    students[0].set_contacts(mapOf("telegram" to null, "email" to "test123@example.com"))
    students[0].show()


/////////lab2
    val student5 = Student("5;Иванов;Иван;Иванович;+79123456789;@ivanov;ivanov@example.com;https://github.com/ivanov")
    student5.show()
    Student("5;I;Am;Megatron;;;decepticon_leader@evil.com;")
    //Test parsing exceptions
    //Student(";;;;;;;")
    //Student("6;;;;;;;")
    //Student("6;Ф;И;О;+79123456789;;;")
    //Student("123")
    //Student("")
    //Student("6;Ф;И;О")
    //Student("6;Ф;И;О;abc;;;;")
    //Student("6;Ф;И;О;;@test\n123;;")

    students.forEach { println(it.getInfo()) }

    val shortStudents = mutableListOf(
        Student_short(students[0]),
        Student_short(students[1]),
        Student_short(students[2]),
        Student_short(students[3]),
        Student_short(5, "Student Линдеманн Т.В., git not added, contact using phone: +88005553535")
        )
    shortStudents.forEach { it.show() }

    println("reading test")
    val studList = Student.readFromTxt("lab2_input.txt")
    studList.forEach { println(it.getInfo()) }

    Student.writeToTxt("lab2_output.txt", studList)
    val studList2 = Student.readFromTxt("lab2_output.txt")
    println("writing test")
    studList2.forEach { println(it.getInfo()) }
    require(studList2.toString() == studList.toString())
}
