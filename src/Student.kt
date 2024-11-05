import java.io.File
import java.io.FileNotFoundException
class Student(
    override val id: Int,
    surname: String,
    name: String,
    lastname: String,
    phone: String? = null,
    telegram: String? = null,
    email: String? = null,
    git: String? = null
) :SuperStudent() {
    companion object {
        fun readFromTxt(filePath: String): List<Student> {
            val file = File(filePath)
            if (!file.exists()) throw FileNotFoundException("File '$filePath' is not found")
            return buildList {
                for (line in file.readLines()) {
                    add(Student(line))
                }
            }
        }
        fun writeToTxt(filePath: String, students: Iterable<Student>) {
            val file = File(filePath)
            file.printWriter().use {
                for (student in students) {
                    it.println(student.toStringRow())
                }
            }
        }
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
    override var git = git
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
    constructor(row: String) : this(row.split(';').also {
        if (it.size != 8 || it.any { "\n" in it })
            throw IllegalArgumentException("String has the wrong format")
    })

    private constructor(row: List<String>) : this(
        row[0].toIntOrNull().let { it ?: throw IllegalArgumentException("ID must be an integer") },
        row[1],
        row[2],
        row[3],
        row[4].ifEmpty { null },
        row[5].ifEmpty { null },
        row[6].ifEmpty { null },
        row[7].ifEmpty { null }
    )
    override fun toString(): String {
        var str = "[ID $id] $surname $name $lastname"
        if (phone != null) str += "\nНомер телефона: $phone"
        if (telegram != null) str += "\nTelegram: $telegram"
        if (email != null) str += "\nEmail: $email"
        if (git != null) str += "\nGit: $git"
        return "$str\n"
    }

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

    fun set_contacts(hashMap: Map<String, String?>) {
        if (hashMap.containsKey("phone")) phone = hashMap["phone"]
        if (hashMap.containsKey("telegram")) telegram = hashMap["telegram"]
        if (hashMap.containsKey("email")) email = hashMap["email"]
    }

    fun getInfo() : String {
        val git = "git${if (this.git != null) ": ${this.git}" else " not added"}"
        val contact = getContact().let {
            if (it != null) "contact using ${it.first}: ${it.second}" else "no contact information"
        }
        return "Student ${getInitials()}, $git, $contact"
    }
    private fun getInitials() = "$surname ${name[0]}.${if (lastname.isNotEmpty()) "${lastname[0]}." else ""}"
    private fun getContact() =
        if(telegram != null) Pair("telegram", telegram)
        else if (phone != null) Pair("phone", phone)
        else if (email != null) Pair("email", email)
        else null


    private fun toStringRow() = listOf(
        id.toString(), surname, name, lastname, phone ?: "", telegram ?: "", email ?: "", git ?: ""
    ).joinToString(";")
}
