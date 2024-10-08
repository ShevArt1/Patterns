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
}