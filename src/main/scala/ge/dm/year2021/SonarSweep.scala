package ge.dm.year2021

import ge.dm.utils.Reader
import ge.dm.year2022.CalorieCounting.solve

object SonarSweep {

  def main(args: Array[String]): Unit = {
    print(solve())
  }

  def solve(): Int = {
    val data = Reader.readFileInt("src/resources/year2021/Day1SonarSweep.txt")

    var count = 0;
    for (i <- 1 until data.length) {
      if (data(i) > data(i - 1)) count += 1
    }
    count
  }
}
