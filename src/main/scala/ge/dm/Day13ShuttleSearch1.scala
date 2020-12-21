package ge.dm

object Day13ShuttleSearch1 {

  def main(args: Array[String]): Unit = {
    try {

      print(solve())
    }
    catch{
      case _: Throwable => println("Got some other kind of exception")
    }
  }

  def readFile(filename: String): Seq[String] = {
    val bufferedSource = io.Source.fromFile(filename)
    val lines = (for (line <- bufferedSource.getLines()) yield line).toList
    bufferedSource.close
    lines
  }

  def solve(): Int = {
    val list = readFile("src/resources/ShuttleSearch.txt")

    var time = list.head.toInt
    val set = list(1)
      .split(",")
      .filter(i => !i.equals("x"))
      .map(i => i.toInt)
      .toSet

    var start = true
    var value = 0
    while(start) {
      for (i <- set) {
        if (time % i == 0) {
          start = false
          value = i
        }
      }
      time += 1
    }
    value * (time -1 - list.head.toInt)
  }

}
