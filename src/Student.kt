class Student(
    val id: Int,
    surname: String,
    name: String,
    lastname: String,
    phone: String? = null,
    telegram: String? = null,
    email: String? = null,
    git: String? = null
) {
    companion object {
        private val nameRegex = Regex("""^[A-Za-zА-Яа-я-]+$""")
        private val phoneRegex = Regex("""^\+?[0-9]{11}$""")
        private val telegramRegex = Regex("""^@\w{5,32}$""")
        private val emailRegex = Regex("""^[A-Za-z0-9_+-]+(\.[A-Za-z0-9_+-]+)*@[A-Za-z0-9-]+(\.[A-Za-z0-9-]+)+$""")
        private val gitRegex = Regex("""^(https?://)?([A-Za-z0-9]+\.)?[A-Za-z0-9]+\.[A-Za-z0-9]+/[A-Za-z0-9_-]+/?$""")

        fun isValidName(value: String) = nameRegex.matches(value)
        fun isValidLastName(value: String) = value.isEmpty() || isValidName(value)
        fun isValidPhone(value: String?) = value == null || phoneRegex.matches(value)
        fun isValidTelegram(value: String?) = value == null || telegramRegex.matches(value)
        fun isValidEmail(value: String?) = value == null || emailRegex.matches(value)
        fun isValidGit(value: String?) = value == null || gitRegex.matches(value)
    }
    var surname = surname
        get() = field
        set(value) {
            if (isValidName(value)) field = value
            else throw IllegalArgumentException("Unacceptable surname")
        }
    var name = name
        get() = field
        set(value) {
            if (isValidName(value)) field = value
            else throw IllegalArgumentException("Unacceptable name")
        }
    var lastname = lastname
        get() = field
        set(value) {
            if (isValidLastName(value)) field = value
            else throw IllegalArgumentException("Unacceptable lastname")
        }
    var phone = phone
        get() = field
        set(value) {
            if (isValidPhone(value)) field = value
            else throw IllegalArgumentException("Unacceptable phone number")
        }
    var telegram = telegram
        get() = field
        set(value) {
            if (isValidTelegram(value)) field = value
            else throw IllegalArgumentException("Unacceptable telegram")
        }
    var email = email
        get() = field
        set(value) {
            if (isValidEmail(value)) field = value
            else throw IllegalArgumentException("Unacceptable email")
        }
    var git = git
        get() = field
        set(value) {
            if (isValidGit(value)) field = value
            else throw IllegalArgumentException("Unacceptable Git")
        }
    constructor(id: Int,
                surname: String,
                name: String,
                lastname: String,
                phone: String) : this(id, surname, name, lastname) {
        this.phone = phone
    }

    constructor(id: Int,
                surname: String,
                name: String,
                lastname: String,
                email: String,
                git: String) : this(id, surname, name, lastname) {
        this.email = email
        this.git = git
    }
    constructor(hashMap: Map<String, Any>) : this(
        hashMap["id"]       as  Int,
        hashMap["surname"]  as  String,
        hashMap["name"]     as  String,
        hashMap["lastname"] as  String,
        hashMap["phone"]    as? String,
        hashMap["telegram"] as? String,
        hashMap["email"]    as? String,
        hashMap["git"]      as? String,
    )
    override fun toString(): String {
        var str = "[ID $id] $surname $name $lastname"
        if (phone != null) str += "\nНомер телефона: $phone"
        if (telegram != null) str += "\nTelegram: $telegram"
        if (email != null) str += "\nEmail: $email"
        if (git != null) str += "\nGit: $git"
        return "$str\n"
    }

    fun show() = println(this.toString())
    
    fun checkGit(): Boolean {
        val result = git != null
        println("У студента $surname $name $lastname гит${if (result) " есть" else "а нет"}")
        return result
    }

    fun checkContact(): Boolean {
        val result = phone != null || telegram != null || email != null
        println("У студента $surname $name $lastname контакт${if (result) "ы есть" else "ов нет"}")
        return result
    }
}
