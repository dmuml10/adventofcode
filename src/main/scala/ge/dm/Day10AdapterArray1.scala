package ge.dm

object Day10AdapterArray1 {

  def main(args: Array[String]): Unit = {
    print(solve())
  }

  def readFile(filename: String): Seq[Long] = {
    val bufferedSource = io.Source.fromFile(filename)
    val lines = (for (line <- bufferedSource.getLines()) yield line.toLong).toList
    bufferedSource.close
    lines
  }

  def solve(): Long = {
    val list = readFile("src/resources/AdapterArray.txt")
    val sorted = list.sortWith(_ < _)

    var diff1 = 1
    var diff3 = 1
    for (i <- 0 until sorted.length - 1) {
      val diff: Long = sorted(i+1) - sorted(i)
      if (diff == 1) {
        diff1 += 1
      }
      if (diff == 3) {
        diff3 += 1
      }
    }

    val result = diff1 * diff3
    result
  }

}
