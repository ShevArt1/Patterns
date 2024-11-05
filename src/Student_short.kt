class Student_short :SuperStudent {
    companion object {
        private val surnameWithInitialsRegex = Regex("""^[A-Za-zА-Яа-я-]+ [A-ZА-Я]\.([A-ZА-Я]\.)?$""")
        fun isValidSurnameWithInitials(value: String) = surnameWithInitialsRegex.matches(value)
        fun isValidContact(value: String?) = value == null || phoneRegex.matches(value) || telegramRegex.matches(value) || emailRegex.matches(value)
    }
    override val id: Int
    var surnameWithInitials: String
    override var git: String?
    var contact: String?

    constructor(id: Int, info: String) {
        this.id = id
        val (initials, git, contact) = info.split(", ")
        this.surnameWithInitials = initials.drop(8)
        if (!isValidSurnameWithInitials(this.surnameWithInitials))
            throw IllegalArgumentException("Unacceptable name")
        this.git = if (":" in git) git.drop(5) else null
        if (!isValidGit(this.git))
            throw IllegalArgumentException("Unacceptable Git")
        this.contact = if (":" in contact) contact.substringAfterLast(": ") else null
        if (!isValidContact(this.contact))
            throw IllegalArgumentException("Unacceptable contact")
    }
    constructor(student: Student) : this(student.id, student.getInfo())
    override fun toString(): String {
        var str = "[ID $id] $surnameWithInitials"
        if (git != null) str += "\nGit: $git"
        if (contact != null) str += "\nКонтакт: $contact"
        return "$str\n"
    }

}
