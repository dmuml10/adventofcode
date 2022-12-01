package ge.dm.year2020

object Day3TobogganTrajectory2 {

  val numRows = 323
  val numColumns = 31

  def main(args: Array[String]): Unit = {
    print(solve("src/resources/TobogganTrajectory.txt"))
  }

  def readFile(filename: String): Array[Array[Char]] = {
    val matrix = Array.ofDim[Char](numRows,numColumns)

    val bufferedSource = io.Source.fromFile(filename)

    var row = 0;
    var column = 0
    for (line <- bufferedSource.getLines()) {
      for (char <- line) {
        matrix(row)(column) = char
        column += 1
      }
      row += 1
      column = 0
    }

    bufferedSource.close
    matrix
  }


  def solve(filename: String): Long = {
    val matrix = readFile(filename)

    1l * calculate(1, 1, matrix) *
      calculate(1, 3, matrix) *
      calculate(1, 5, matrix) *
      calculate(1, 7, matrix) *
      calculate(2, 1, matrix)
  }

  private def calculate(r: Int, c: Int, array: Array[Array[Char]]): Int =  {
    var column: Int = 0
    var row: Int = 0
    var counter: Int = 0
    while ( row < numRows)  {
      column = column % numColumns
      if (array(row)(column) == '#')  {
        counter += 1
      }
      row += r
      column += c
    }
    counter
  }

}
