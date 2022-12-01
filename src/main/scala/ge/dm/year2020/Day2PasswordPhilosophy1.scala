package ge.dm.year2020

object Day2PasswordPhilosophy1 {

  def main(args: Array[String]): Unit = {
    print(solve())
  }

  def readFile(filename: String): Seq[PassData] = {
    val bufferedSource = io.Source.fromFile(filename)
    val lines = (for (line <- bufferedSource.getLines()) yield parseLine(line)).toList
    bufferedSource.close
    lines
  }

  def parseLine(line: String): PassData = {
    val min: Int = line.substring(0, line.indexOf("-")).toInt
    val max: Int = line.substring(line.indexOf("-") + 1, line.indexOf(" ")).toInt
    val char: String = line.substring(line.indexOf(" ") + 1, line.indexOf(":"))
    val password: String = line.substring(line.indexOf(":") + 2)
    PassData(min, max, char, password)
  }

  def solve(): Int = {
    var counter = 0;
    val data = readFile("src/resources/PasswordPhilosophy.txt");
    for (passData: PassData <- data) {
      val num = calculateCharOccurrence(passData.password, passData.char)
      if (num >= passData.min && num <= passData.max) {
        counter += 1
      }
    }
    counter
  }

  def calculateCharOccurrence(password: String, char: String): Int = {
    var counter = 0;
    for (c <- password) {
      if (c == char.charAt(0)) {
        counter += 1
      }
    }
    counter
  }


}

case class PassData(min: Int, max: Int, char: String, password: String) {
}
