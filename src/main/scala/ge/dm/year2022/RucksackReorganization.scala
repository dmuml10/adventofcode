package ge.dm.year2022

import ge.dm.utils.Reader

object RucksackReorganization {

  def main(args: Array[String]): Unit = {
    print(solve())
  }

  def solve(): Int = {
    val data = Reader.readFileString("src/resources/year2022/Day3RucksackReorganization.txt")

    data.indices.map( x => checkRuckSack(data(x))).sum
  }

  def checkRuckSack(items: String): Int = {
    val s: Set[Char] = items.substring(0, items.length / 2).toSet
    items.substring(items.length / 2, items.length)
      .filter(i => s.contains(i))
      .take(1)
      .map(i => calculateScore(i)).toList.head
  }

  def calculateScore(ch: Char): Int = {
    if (ch.isLower) {
      ch - 96
    } else {
      ch - 38
    }
  }


}
