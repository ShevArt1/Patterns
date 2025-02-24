interface StudentListInterface {
    fun getStudentById(id: Int) : Student?
    fun getStudentShortList(k: Int, n: Int) : Data_list_short
    fun add(student: Student) : Boolean
    fun replace(id: Int, newStudent: Student) : Boolean
    fun remove(id: Int) : Boolean
    fun getStudentShortCount() : Int
}