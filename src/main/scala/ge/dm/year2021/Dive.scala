package ge.dm.year2021

import ge.dm.utils.Reader

object Dive {


  def main(args: Array[String]): Unit = {
    val data = Reader.readFileString("src/resources/year2021/Day2Dive.txt")
    var h = 0
    var d = 0
    for (line <- data) {
      if (line.contains("forward")) h += getNum(line)
      else if (line.contains("up")) d -= getNum(line)
      else d += getNum(line)
    }
    System.out.println(h * d)
  }

  private def getNum(line: String) = line.substring(line.indexOf(" ") + 1).toInt

}
