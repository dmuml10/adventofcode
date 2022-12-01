package ge.dm.year2020

import Day11SeatingSystem1.applyFirstRule
import Day11SeatingSystem1.applySecondRule
import Day11SeatingSystem1.calculateAdjSitNum
import Day11SeatingSystem1.calculateOccupiedSits
import Day11SeatingSystem1.compare
import Day11SeatingSystem1.copy
import Day11SeatingSystem1.readIntoMatrix

object Day11SeatingSystem2 {

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
      val rule1 = applyThirdRule(old)
      val rule2 = applyFourthRule(rule1)
      if (compare(old, rule2)) {
        loop = false
      }
      old = rule2
    }

    calculateOccupiedSits(old)
  }

  def applyThirdRule(matrix: Array[Array[Char]]): Array[Array[Char]] = {
    val cm = copy(matrix)
    for (i <- cm.indices) {
      for (j <- cm(0).indices) {
        if (cm(i)(j) == 'L' && calculateAdvancedAdjSitNum(matrix, i, j) == 0) {
          cm(i)(j) = '#'
        }
      }
    }
    cm
  }

  def applyFourthRule(matrix: Array[Array[Char]]): Array[Array[Char]] = {
    val cm = copy(matrix)
    for (i <- cm.indices) {
      for (j <- cm(0).indices) {
        if (cm(i)(j) == '#' && calculateAdjSitNum(matrix, i, j) >= 5) {
          cm(i)(j) = 'L'
        }
      }
    }
    cm
  }

  def calculateAdvancedAdjSitNum(matrix: Array[Array[Char]], row: Int, column: Int): Int = {
    val maxRow = matrix.length
    val maxColumn = matrix(0).length
    var count = 0

    var i = row
    var j = column
    while(i > 0) {
      i = i - 1
      if (matrix(i)(j) == '#') {
        count += 1
        i = -1
      } else if (matrix(i)(j) == 'L') {
        i = -1
      }
    }
    i = row
    while(i < maxRow - 1) {
      i = i + 1
      if (matrix(i)(j) == '#') {
        count += 1
        i = maxColumn
      } else if (matrix(i)(j) == 'L') {
        i = maxColumn
      }
    }
    i = row
    while(j > 0) {
      j = j - 1
      if (matrix(i)(j) == '#') {
        count += 1
        j = -1
      } else if (matrix(i)(j) == 'L') {
        j = -1
      }
    }
    j = column
    while(j < maxColumn - 1) {
      j = j + 1
      if (matrix(i)(j) == '#') {
        count += 1
        j = maxColumn
      } else if (matrix(i)(j) == 'L') {
        j = maxColumn
      }
    }
    j = column
    i = row
    while(i >0 && j > 0) {
      i -= 1
      j -= 1
      if (matrix(i)(j) == '#') {
        count += 1
        j = -1
      } else if (matrix(i)(j) == 'L') {
        j = -1
      }
    }
    j = column
    i = row
    while(i < maxRow -1 && j < maxColumn - 1) {
      i += 1
      j += 1
      if (matrix(i)(j) == '#') {
        count += 1
        j = maxColumn
      } else if (matrix(i)(j) == 'L') {
        j = maxColumn
      }
    }
    j = column
    i = row
    while(i > 0 && j < maxColumn - 1) {
      i -= 1
      j += 1
      if (matrix(i)(j) == '#') {
        count += 1
        j = maxColumn
      } else if (matrix(i)(j) == 'L') {
        j = maxColumn
      }
    }
    j = column
    i = row
    while(i < maxRow -1 && j > 0) {
      i += 1
      j -= 1
      if (matrix(i)(j) == '#') {
        count += 1
        j = -1
      } else if (matrix(i)(j) == 'L') {
        j = -1
      }
    }

    count
  }

}
