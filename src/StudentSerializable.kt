import kotlinx.serialization.Serializable
@Serializable
data class StudentSerializable(val id: Int,
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