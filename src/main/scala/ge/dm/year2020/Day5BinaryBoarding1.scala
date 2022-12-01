package ge.dm.year2020

import scala.collection.mutable.ArrayBuffer

object Day5BinaryBoarding1 {

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
    val data = readFile("src/resources/BinaryBoarding.txt")

    val list = ArrayBuffer[Int]()
    for (line <- data) {
      val row = parseRow(line.substring(0, 7))
      val column = parseColumn(line.substring(7))

      val id = row * 8 + column
      list += id
    }

    val sorted = scala.util.Sorting.stableSort(list)
    findMissing(sorted)
  }

  def findMissing(sorted: Array[Int]): Int = {
    var left = 0;
    var right = 0;
    for (i <- 1 until sorted.length - 1) {
      if (sorted(i) - 1 != sorted(i-1)) {
        left = sorted(i-1)
        right = sorted(i)
      }
    }

    (left + right)/2
  }

  def parseRow(code: String): Int = {
    var min = 0;
    var max = 127;
    for (char <- code) {
      if (char == 'F') {
        max = max - (max - min) / 2 - 1
      } else {
        min = min + (max - min)/2 + 1
      }
    }

    min
  }

  def parseColumn(code : String): Int = {
    var min = 0;
    var max = 7;
    for (char <- code) {
      if (char == 'L') {
        max = max - (max - min) / 2 - 1
      } else {
        min = min + (max - min)/2 + 1
      }
    }

    min
  }

}
