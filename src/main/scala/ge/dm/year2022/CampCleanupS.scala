package ge.dm.year2022

import ge.dm.utils.Reader

object CampCleanupS {

  def main(args: Array[String]): Unit = {
    print(solve())
  }

  def solve(): Int = {
    val data = Reader.readFileString("src/resources/year2022/Day4CampCleanup.txt")

    data.indices.map(x => containsOther(data(x))).count(p => p)
  }

  def containsOther(line: String): Boolean = {
    val areas = line.split(",")
    val left = areas(0).split("-")
    val right = areas(1).split("-")
    (left(0).toInt <= right(0).toInt && left(1).toInt >= right(1).toInt) ||
      (left(0).toInt >= right(0).toInt && left(1).toInt <= right(1).toInt)
  }
}
