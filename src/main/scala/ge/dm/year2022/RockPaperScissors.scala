package ge.dm.year2022

import ge.dm.utils.Reader

object RockPaperScissors {

  val symbols: Map[String, Int]
  = Map("A" -> 1, "B" -> 2, "C" -> 3, "X" -> 1, "Y" -> 2, "Z" -> 3)

  def main(args: Array[String]): Unit = {
    print(solve())
  }

  def solve(): Int = {
    val data = Reader.readFileString("src/resources/year2022/Day2RockPaperScissors.txt")

    data.indices.map( x => calculateScore(data(x))).sum
  }

  // 1-2 = -1 w   1-3= -2 l
  // 2-1 =  1 l  2-3= -1 w
  // 3-1 =  2 w  3-2=  1 l
  def calculateScore(play: String): Int = {
    var score = 0;
    val hands = play.split(" ")
    val rival = symbols(hands(0))
    val you = symbols(hands(1))
    if (rival - you == 0) {
      score += rival + 3
    } else if (rival - you == -1 || rival - you== 2) {
      score += you + 6
    } else {
      score += you
    }
    score
  }
}
