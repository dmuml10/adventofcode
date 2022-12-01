package ge.dm.year2020

object Day6CustomCustoms1 {

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
    val set = scala.collection.mutable.Set[Char]()
    for (line <- list) {
      if (line.equals("")) {
        count += set.size
        set.clear();
      } else {
        for (char <- line) {
          set.add(char)
        }
      }

    }
    count
  }

}
