fun main() {
//    val student1 = Student(
//        id = 1,
//        surname = "Иванов",
//        name = "Иван",
//        lastname = "Иванович",
//        phone = "+79123456789",
//        telegram = "@ivanov",
//        email = "ivanov@example.com",
//        git = "https://github.com/ivanov"
//    )
//
//    val student2 = Student(
//        id = 2,
//        surname = "Петров",
//        name = "Петр",
//        lastname = "Петрович",
//        git = "https://github.com/petrov"
//    )
    val students = mutableListOf<Student>(
        Student(1, "Иванов","Иван", "Иванович", "+79123456789", "@ivanov", "ivanov@example.com", "https://github.com/ivanov"),
        Student(2, "Петров","Петр", "Петрович", git= "https://github.com/petrov"),
        Student(3, "Линдеманн","Тилль", "Вернерович", "+88005553535", email="duhast@gmail.com"),
        Student(4, "Шевякин","Артём", "Анатольевич"),
        )

    students.forEach { it.show() }



}