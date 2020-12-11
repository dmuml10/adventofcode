package ge.dm

object Day7HandyHaversacks2 {

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
    val desiredColor = "shiny gold"
    val map = scala.collection.mutable.Map[String, scala.collection.mutable.Set[String]]()
    val list = readFile("src/resources/HandyHaversacks.txt")
    for (line <- list) {
      val set = scala.collection.mutable.Set[String]()
      val data = line.split(",")
      val mainBag = data(0).split(" contain ")
      val key = removeEnd(mainBag(0))
      val value = mainBag(1)
      if (line.contains("no other bags")) {
        map.put(key, set)
      } else {
        set.add(getBagData(value).color)
        map.put(key, set)
        for (i <- 1 until data.length) {
          map(key).add(getBagData(data(i)).color)
        }
      }
    }

    val colors = scala.collection.mutable.Set[String]()
    findBags(colors, map, desiredColor)

    colors.size
  }

  def findBags(set: scala.collection.mutable.Set[String],
               map: scala.collection.mutable.Map[String,
                 scala.collection.mutable.Set[String]],
               color: String): Unit = {
    for (keyVal <- map) {
      if (keyVal._2.contains(color)) {
        set.add(keyVal._1)

        findBags(set, map, keyVal._1)
      }
    }
  }

  def removeEnd(text: String): String = {
    text.substring(0, text.indexOf(" bag"))
  }

  def getBagData(text: String): BagData = {
    val t = removeEnd(text.trim)
    val num = t.charAt(0).asDigit
    val color = t.substring(2)
    BagData(color, num)
  }

}

case class BagData(color: String, num: Int)