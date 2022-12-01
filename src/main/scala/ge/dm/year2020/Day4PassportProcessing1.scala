package ge.dm.year2020

object Day4PassportProcessing {

  val validCodes = List("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

  def main(args: Array[String]): Unit = {
    print(solve())
  }

  def solve(): Int = {
   readFile("src/resources/PassportProcessing.txt")
  }

  def readFile(filename: String): Int = {
    val bufferedSource = io.Source.fromFile(filename)
    var counter = 0;
    val set = scala.collection.mutable.Set[String]()
    for (line <- bufferedSource.getLines()) {
      if (line.equals("")) {
        if (isValidPassport(set)) {
          counter += 1
        }
        set.clear()
      } else {
        for (w <- line.split(" ")) {
          set.add(w.split(":")(0))
        }
      }
    }

    bufferedSource.close
    counter
  }

  def isValidPassport(set: scala.collection.mutable.Set[String]): Boolean = {
    for (key <- validCodes) {
      if (!set.contains(key)) {
        return false;
      }
    }
    true
  }

}