package ge.dm.year2020

import Day8HandheldHalting1.readFile
import Day8HandheldHalting1.solve

import scala.collection.mutable.ListBuffer

object Day9EncodingError2 {

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
    val list = readFile("src/resources/EncodingError.txt")

    val invalid = 1492208709

    for (i <- list.indices) {
      for (j <- i until list.length) {
        if (i != j) {
          val slice = list.slice(i, j)
          val sum = slice.sum
          if (sum == invalid) {
            val sorted = slice.sortWith(_ < _)
            val result = sorted(0) + sorted(sorted.length-1)
            print(result)
          }
        }
      }
    }

    0
  }

}
