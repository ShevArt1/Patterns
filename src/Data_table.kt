class Data_table(private val array: List<List<Any>>) {
  fun get(row: Int, col: Int) = array[row][col]

  fun getRowCount() = array.size
  fun getColCount() = if (array.isNotEmpty()) array[0].size else 0
}
