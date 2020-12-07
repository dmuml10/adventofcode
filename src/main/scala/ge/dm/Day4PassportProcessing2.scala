package ge.dm

object Day4PassportProcessing2 {

  val rules = Map("byr" -> "^(192[0-9]|19[3-9]\\d|200[0-2])$",
    "iyr" -> "^(201[0-9]|2020)$",
    "eyr" -> "^(202[0-9]|2030)$",
    "hgt" -> "^((15[0-9]|1[6-8][0-9]|19[0-3])cm)|((59|6[0-9]|7[0-6])in)$",
    "hcl" -> "^#([0-9]|[a-f]){6}$",
    "ecl" -> "^(amb|blu|brn|gry|grn|hzl|oth)$",
    "pid" -> "^[0-9]{9}$"
  )

  def main(args: Array[String]): Unit = {
    print(solve())
  }

  def solve(): Int = {
    readFile("src/resources/PassportProcessing.txt")
  }

  def readFile(filename: String): Int = {
    val bufferedSource = io.Source.fromFile(filename)
    var counter = 0;
    val set = scala.collection.mutable.Map[String, String]()
    for (line <- bufferedSource.getLines()) {
      if (line.equals("")) {
        if (isValidPassport(set)) {
          counter += 1
        }
        set.clear()
      } else {
        for (w <- line.split(" ")) {
          val split = w.split(":")
          set.put(split(0), split(1))
        }
      }
    }

    bufferedSource.close
    counter
  }

  def isValidPassport(set: scala.collection.mutable.Map[String, String]): Boolean = {
    for (key <- rules) {
      if (!set.contains(key._1) || !set.getOrElse(key._1, "").matches(key._2)) {
        return false;
      }
    }
    true
  }

}
