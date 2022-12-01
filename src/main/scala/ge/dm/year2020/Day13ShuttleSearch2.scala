package ge.dm.year2020

import scala.collection.mutable.ListBuffer

object Day13ShuttleSearch2 {

  def main(args: Array[String]): Unit = {
    print(solve())
  }

  def readFile(filename: String): Seq[String] = {
    val bufferedSource = io.Source.fromFile(filename)
    val lines = (for (line <- bufferedSource.getLines()) yield line).toList
    bufferedSource.close
    lines
  }

  def solve(): Long = {
    val list = readFile("src/resources/ShuttleSearch.txt")

    val bus = list(1).split(",")
    val data = new ListBuffer[BusIndex]
    var count = 0
    for (i <- bus) {
      if (!i.equals("x")) {
        data += BusIndex(i.toInt, count)
      }
      count += 1
    }

    var time: Long = 100000000000000l
    var on = true
    var time2 = 0L
    while(on) {
      time += 1
      time2 = time
      var isTrue = true;
      for (i <- data) {
        time2 = time + i.index
        if (time2 % i.number != 0) {
          isTrue = false
        }
      }
      if (isTrue) {
        on = false
      }
      if (time % 10000000== 0) {
        print(time +" \n")
      }
    }
    time
  }

}

case class BusIndex(number: Long, index: Long)