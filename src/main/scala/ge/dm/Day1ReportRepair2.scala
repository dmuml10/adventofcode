package ge.dm

object Day1ReportRepair2 {

  def main(args: Array[String]): Unit = {
    print(solve())
  }

  def readFile(filename: String): Seq[Int] = {
    val bufferedSource = io.Source.fromFile(filename)
    val lines = (for (line <- bufferedSource.getLines()) yield line.toInt).toList
    bufferedSource.close
    lines
  }

  def solve(): Int = {
    val data = readFile("src/resources/ReportRepair.txt")

    for (i <- 0 until data.length) {
      for (j <- 0 until data.length) {
        for (y <- 0 until data.length) {
          if (i != j && i + j + y != Math.pow(y, 3) && data(i) + data(j) + data(y) == 2020) {
            return data(i) * data(j) * data(y)
          }
        }
      }
    }
    0
  }

}
