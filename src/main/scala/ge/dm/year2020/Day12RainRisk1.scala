package ge.dm.year2020

object Day12RainRisk1 {
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
    val lines = readFile("src/resources/RainRisk.txt")

    var location = Location(0, 0, 'E')
    for (line <- lines) {
      val code = line.charAt(0)
      val value = line.substring(1).toInt

      location = readValue(code, value, location)
    }
    Math.abs(location.x) + Math.abs(location.y)
  }

  def readValue(code: Char, value: Int, old: Location): Location = {
    val tempLocation: Location = code match {
      case 'N' => {
        Location(old.x + value, old.y, old.direction)
      }
      case 'S' => {
        Location(old.x - value, old.y, old.direction)
      }
      case 'W' => {
        Location(old.x, old.y - value, old.direction)
      }
      case 'E' => {
        Location(old.x, old.y + value, old.direction)
      }
      case 'F' => {
        readValue(old.direction, value, old)
      }
      case 'R' => {
        Location(old.x, old.y, getDirection(old.direction, 'R', value))
      }
      case 'L' => {
        Location(old.x, old.y, getDirection(old.direction, 'L', value))
      }
      case _ => {
        Location(0, 0, '?')
      }
    }
    tempLocation
  }

  def getDirection(code: Char, turn: Char, value: Int): Char = {
    val directions = Array('N', 'E', 'S', 'W')
    val step = value / 90 //1
    val dir = if (turn == 'R') 1 else -1 // -1   = -1
    var index = (directions.indexOf(code) + (dir * step)) % directions.length
    if (index < 0) {
      index += 4
    }
    directions(index)
  }
}

case class Location(x: Int, y: Int, direction: Char)
