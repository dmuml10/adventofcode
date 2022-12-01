package ge.dm.year2020

import Day8HandheldHalting1.readFile
import Day8HandheldHalting1.solve

import scala.collection.mutable.ListBuffer

object Day9EncodingError1 {

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

    val first25 = for (i <- 0 until 25) yield list(i)
    val preList = new ListBuffer[Long]()++first25

    for (i <- 25 until list.length) {
      val result = findError(preList, list(i))
      if (result != -1) {
        return result
      }
      preList.remove(0)
      preList += list(i)
    }
    0
  }

  def findError(set: ListBuffer[Long], num: Long): Long = {
    for (i <- set) {
      val sub = num - i
      if (sub != i && set.contains(sub)) {
        return -1;
      }
    }
    num
  }
}
