package ge.dm.year2022

import ge.dm.utils.Reader

object CalorieCounting {

  def main(args: Array[String]): Unit = {
    print(solve())
  }

  def solve(): Int = {
    val data = Reader.readFileString("src/resources/year2022/Day1CalorieCounting.txt")

    var max = 0;
    var sum = 0;
    for (i <- data.indices) {
      if (data(i).isBlank) {
        if (sum > max) {
          max = sum
        }
        sum = 0;
      } else {
        sum += data(i).toInt
      }
    }
    max
  }
}