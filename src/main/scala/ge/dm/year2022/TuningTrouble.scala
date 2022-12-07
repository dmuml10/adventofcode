package ge.dm.year2022

import ge.dm.utils.Reader

object TuningTrouble {
  def main(args: Array[String]): Unit = {
    print(solve())
  }

  def solve(): Int = {
    val line = Reader.readLine("src/resources/year2022/Day6TuningTrouble.txt")
    for (i <- 3 to line.length) {
      val set = scala.collection.mutable.Set[Char]()
      set.add(line.charAt(i - 3))
      set.add(line.charAt(i - 2))
      set.add(line.charAt(i - 1))
      set.add(line.charAt(i))
      if (set.size == 4) return i + 1
    }
    -1
  }
}
