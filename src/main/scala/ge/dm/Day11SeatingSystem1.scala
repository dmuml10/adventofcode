package ge.dm

object Day11SeatingSystem1 {

  def main(args: Array[String]): Unit = {
    print(solve())
  }

  def readFile(filename: String): Seq[String] = {
    val bufferedSource = io.Source.fromFile(filename)
    val lines = (for (line <- bufferedSource.getLines()) yield line).toList
    bufferedSource.close
    lines
  }

  def solve(): Int = {
    val lines = readFile("src/resources/SeatingSystem.txt")

    val matrix = readIntoMatrix(lines);

    var old = matrix
    var loop = true
    while(loop) {
      val rule1 = applyFirstRule(old)
      val rule2 = applySecondRule(rule1)
      if (compare(old, rule2)) {
        loop = false
      }
      old = rule2
    }

    calculateOccupiedSits(old)
  }

  def readIntoMatrix(lines: Seq[String]): Array[Array[Char]] = {
    val matrix = Array.ofDim[Char](lines.length,lines(0).length)
    for (i <- lines.indices) {
      for (j <- lines(i).indices) {
        matrix(i)(j) = lines(i).charAt(j)
      }
    }
    matrix
  }

  def applyFirstRule(matrix: Array[Array[Char]]): Array[Array[Char]] = {
    val cm = copy(matrix)
    for (i <- cm.indices) {
      for (j <- cm(0).indices) {
        if (cm(i)(j) == 'L' && calculateAdjSitNum(matrix, i, j) == 0) {
          cm(i)(j) = '#'
        }
      }
    }
    cm
  }

  def applySecondRule(matrix: Array[Array[Char]]): Array[Array[Char]] = {
    val cm = copy(matrix)
    for (i <- cm.indices) {
      for (j <- cm(0).indices) {
        if (cm(i)(j) == '#' && calculateAdjSitNum(matrix, i, j) >= 4) {
          cm(i)(j) = 'L'
        }
      }
    }
    cm
  }

  def calculateAdjSitNum(matrix: Array[Array[Char]], row: Int, column: Int): Int = {
    val maxRow = matrix.length
    val maxColumn = matrix(0).length
    var count = 0
    for (i <- row - 1 to row + 1) {
      for (j <- column - 1 to column + 1) {
        if (i != row || j != column) {
          if (i >= 0 && i < maxRow && j >= 0 && j < maxColumn) {
            if (matrix(i)(j) == '#') {
              count += 1
            }
          }
        }
      }
    }
    count
  }

  def compare(a: Array[Array[Char]], b: Array[Array[Char]]): Boolean = {
    for (i <- a.indices) {
      if (!a(i).sameElements(b(i))) {
        return false
      }
    }
    true
  }

  def calculateOccupiedSits(matrix: Array[Array[Char]]): Int = {
    var count = 0
    for (i <- matrix.indices) {
      for (j <- matrix(0).indices) {
        if (matrix(i)(j) == '#') {
          count += 1
        }
      }
    }
    count
  }

  def copy(matrix: Array[Array[Char]]): Array[Array[Char]] = {
    val replica = Array.ofDim[Char](matrix.length,matrix(0).length)
    for (i <- matrix.indices) {
      for (j <- matrix(i).indices) {
        replica(i)(j) = matrix(i).charAt(j)
      }
    }
    replica
  }

}
