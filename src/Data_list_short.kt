class Data_list_short(studentShortArray: List<Student_short>) : Data_list(studentShortArray) {
    override fun getNames() = listOf("№", "ФИО", "Git", "Контакт для связи")
    override fun getData() = Data_table(buildList {
        var count = 1
        for (index in getSelected()) {
            val student = array[index] as StudentShort
            add(listOf(count++, student.surnameWithInitials, student.git, student.contact))
        }
    })
}
