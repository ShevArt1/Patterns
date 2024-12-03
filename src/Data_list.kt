abstract class Data_list(private val array: List<Any>) {
    private val selectedIndices: MutableList<Int> = mutableListOf()
    fun select(number: Int) = selectedIndices.add(number)
    fun getSelected() = selectedIndices.toList()
    abstract fun getNames()
    abstract fun getData()
}
