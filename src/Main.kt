fun main() {

    val students = mutableListOf<Student>(
        Student(1, "Иванов","Иван", "Иванович", "+79123456789", "@ivanov", "ivanov@example.com", "https://github.com/ivanov"),
        Student(2, "Петров","Петр", "Петрович", git= "https://github.com/petrov"),
        Student(3, "Линдеманн","Тилль", "Вернерович", "+88005553535", email="duhast@gmail.com"),
        Student(4, "Шевякин","Артём", "Анатольевич"),
        )

    students.forEach { it.show() }

    val student1 = Student(5, "Иванов", "Иван", "Иванович", "+79123456789")
    val student2 = Student(6, "Иванов", "Иван", "Иванович", "ivanov@example.com", "https://github.com/ivanov")

    student1.show()
    student2.show()

    val student3 = Student(mapOf(
        "id" to 7,
        "surname" to "Шевякин",
        "name" to "Артём",
        "lastname" to "Анатольевич"
    ))
    val student4 = Student(mapOf(
        "id" to 8,
        "surname" to "Хэшев",
        "name" to "Хэш",
        "lastname" to "Хэшевич",
        "phone" to "+79876543210",
        "telegram" to "@hash123",
        "email" to "hash@example.com",
        "git" to "https://github.com/hash123"
    ))
    student3.show()
    student4.show()
}