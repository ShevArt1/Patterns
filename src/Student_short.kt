class Student_short {
    companion object {
        private val surnameWithInitialsRegex = Regex("""^[A-Za-zА-Яа-я-]+ [A-ZА-Я]\.([A-ZА-Я]\.)?$""")
        private val phoneRegex = Regex("""^\+?[0-9]{11}$""")
        private val telegramRegex = Regex("""^@\w{5,32}$""")
        private val emailRegex = Regex("""^[A-Za-z0-9_+-]+(\.[A-Za-z0-9_+-]+)*@[A-Za-z0-9-]+(\.[A-Za-z0-9-]+)+$""")
        private val gitRegex = Regex("""^(https?://)?([A-Za-z0-9]+\.)?[A-Za-z0-9]+\.[A-Za-z0-9]+/[A-Za-z0-9_-]+/?$""")
        fun isValidSurnameWithInitials(value: String) = surnameWithInitialsRegex.matches(value)
        fun isValidGit(value: String?) = value == null || gitRegex.matches(value)
        fun isValidContact(value: String?) = value == null || phoneRegex.matches(value) || telegramRegex.matches(value) || emailRegex.matches(value)
    }
    val id: Int
    val surnameWithInitials: String
    val git: String?
    val contact: String?
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
    fun show() = println(this.toString())
}
