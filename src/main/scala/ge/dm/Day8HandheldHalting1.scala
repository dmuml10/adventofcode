package ge.dm

object Day8HandheldHalting1 {

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
    val list = readFile("src/resources/HandheldHalting.txt")
    var accumulator = 0;
    val set = scala.collection.mutable.Set[Int]()
    var i = 0
    while (true) {
      val nextCommand = parseLine(list(i))
      val commandName = nextCommand.command
      if (set.contains(i)) {
        return accumulator
      }

      set.add(i)
      val sign = if (nextCommand.forward) 1 else -1
      if (commandName.equals("acc")) {
        accumulator += (sign * nextCommand.line)
        i += 1
      } else if (commandName.equals("jmp")) {
        i += (sign * nextCommand.line)
      } else if (commandName.equals("nop")) {
        i += 1
      } else {
        print("Invalid Command")
      }
    }

    accumulator
  }


  def parseLine(line: String): BootCommand = {
    val data = line.split(" ")
    var direction = true
    if (data(1).charAt(0) == '-') {
      direction = false
    }
    BootCommand(data(0), direction, data(1).substring(1).toInt)
  }

}


case class BootCommand(command: String, forward: Boolean, line: Int)