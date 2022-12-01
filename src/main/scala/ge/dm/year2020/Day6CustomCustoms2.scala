package ge.dm.year2020

object Day6CustomCustoms2 {

  def main(args: Array[String]): Unit = {
    print(solve())
  }

  def readFile(filename: String): Seq[String] = {
    val bufferedSource = io.Source.fromFile(filename)
    val lines = (for (line <- bufferedSource.getLines()) yield line).toList
    bufferedSource.close
    lines
  }

  def solve(): Int = {
    val list = readFile("src/resources/CustomCustoms.txt")
    var count = 0;
    var numGroup = 0;
    val map = scala.collection.mutable.Map[Char, Int]()
    for (line <- list) {
      if (line.equals("")) {
        for (keyVal <- map) {
          if (numGroup == keyVal._2) {
            count += 1
          }
        }
        map.clear();
        numGroup = 0
      } else {
        numGroup += 1
        for (char <- line) {
          if (map.contains(char)) {
            map.put(char, map(char) + 1)
          } else {
            map.put(char, 1)
          }
        }
      }

    }
    count
  }

}

