package ge.dm.year2020

object Day1ReportRepair1 {

  def main(args: Array[String]): Unit = {
    print(solve())
  }

  def solve(): Int = {
    val data = readFile("src/resources/ReportRepair.txt")

    for (i <- 0 until data.length) {
      for (j <- 0 until data.length) {
        if (i !=j && data(i) + data(j) == 2020) {
          return data(i) * data(j)
        }
      }
    }
    0
  }

  def readFile(filename: String): Seq[Int] = {
    val bufferedSource = io.Source.fromFile(filename)
    val lines = (for (line <- bufferedSource.getLines()) yield line.toInt).toList
    bufferedSource.close
    lines
  }

}
