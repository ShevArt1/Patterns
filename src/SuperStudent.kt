abstract class SuperStudent {
    companion object {
        @JvmStatic
        protected val nameRegex = Regex("""^[\p{L}-]+$""")
        @JvmStatic
        protected val phoneRegex = Regex("""^\+?[0-9]{11}$""")
        @JvmStatic
        protected val telegramRegex = Regex("""^@\w{5,32}$""")
        @JvmStatic
        protected val emailRegex = Regex("""^[A-Za-z0-9_+-]+(\.[A-Za-z0-9_+-]+)*@[A-Za-z0-9-]+(\.[A-Za-z0-9-]+)+$""")
        @JvmStatic
        protected val gitRegex = Regex("""^(https?://)?([A-Za-z0-9]+\.)?[A-Za-z0-9]+\.[A-Za-z0-9]+/[A-Za-z0-9_-]+/?$""")
        @JvmStatic
        protected fun isValidName(value: String) = nameRegex.matches(value)
        @JvmStatic
        protected fun isValidLastName(value: String) = value.isEmpty() || isValidName(value)
        @JvmStatic
        protected fun isValidPhone(value: String?) = value == null || phoneRegex.matches(value)
        @JvmStatic
        protected fun isValidTelegram(value: String?) = value == null || telegramRegex.matches(value)
        @JvmStatic
        protected fun isValidEmail(value: String?) = value == null || emailRegex.matches(value)
        @JvmStatic
        protected fun isValidGit(value: String?) = value == null || gitRegex.matches(value)
    }
    abstract val id: Int
    abstract var git: String?
    abstract override fun toString(): String
    fun show() = println(this.toString())
}
