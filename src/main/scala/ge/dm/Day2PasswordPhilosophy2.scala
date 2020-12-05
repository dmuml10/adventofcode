package ge.dm

object Day2PasswordPhilosophy2 {

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
      if (passData.password.charAt(passData.min-1) == passData.char.charAt(0) ^ passData.password.charAt(passData.max-1) == passData.char.charAt(0)) {
        counter += 1
      }
    }
    counter
  }


}