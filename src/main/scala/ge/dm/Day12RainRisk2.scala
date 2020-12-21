package ge.dm

object Day12RainRisk2 {
  def main(args: Array[String]): Unit = {
    print(solve())
  }

  def readFile(filename: String): Seq[String] = {
    val bufferedSource = io.Source.fromFile(filename)
    val lines = (for (line <- bufferedSource.getLines()) yield line).toList
    bufferedSource.close
    lines
  }

  val WX = 10
  val WY = 1

  def solve(): Int = {
    val lines = readFile("src/resources/RainRisk.txt")

    var location = Waypoint(0, 0, 10, 4, 'E')
    for (line <- lines) {
      val code = line.charAt(0)
      val value = line.substring(1).toInt

      location = readValue(code, value, location)
    }
    Math.abs(location.x) + Math.abs(location.y)
  }

  def readValue(code: Char, value: Int, old: Waypoint): Waypoint = {
    val tempLocation: Waypoint = code match {
      case 'N' => {
        Waypoint(old.x, old.y, old.wx, old.wy + value, old.direction)
      }
      case 'S' => {
        Waypoint(old.x, old.y, old.wx, old.wy - value, old.direction)
      }
      case 'W' => {
        Waypoint(old.x, old.y, old.wx - value, old.wy, old.direction)
      }
      case 'E' => {
        Waypoint(old.x, old.y, old.wx + value, old.wy, old.direction)
      }
      case 'F' => {
        val x = old.x + (old.wx * value)
        val y = old.y + (old.wy * value)
        Waypoint(x, y, x + WX, y + WY, old.direction)
      }
      case 'R' => {
        Waypoint(old.x, old.y, old.wx, old.wy, getDirection(old.direction, 'R', value))
      }
      case 'L' => {
        Waypoint(old.x, old.y, old.wx, old.wy, getDirection(old.direction, 'L', value))
      }
      case _ => {
        Waypoint(0, 0, 0, 0, '?')
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

case class Waypoint(x: Int, y: Int, wx: Int, wy: Int, direction: Char)
