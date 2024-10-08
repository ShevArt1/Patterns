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
    var surname = surname
        get() = field
        set(value) { field = value }
    var name = name
        get() = field
        set(value) { field = value }
    var lastname = lastname
        get() = field
        set(value) { field = value }
    var phone = phone
        get() = field
        set(value) { field = value }
    var telegram = telegram
        get() = field
        set(value) { field = value }
    var email = email
        get() = field
        set(value) { field = value }
    var git = git
        get() = field
        set(value) { field = value }
}