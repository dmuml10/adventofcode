package ge.dm.utils

object Reader {

  def readFileString(filename: String): Seq[String] = {
    val bufferedSource = io.Source.fromFile(filename)
    val lines = (for (line <- bufferedSource.getLines()) yield line).toList
    bufferedSource.close
    lines
  }

  def readLine(filename: String): String = {
    val bufferedSource = io.Source.fromFile(filename)
    val line = (for (line <- bufferedSource.getLines()) yield line).toList.head
    bufferedSource.close
    line
  }


  def readFileLong(filename: String): Seq[Long] = {
    val bufferedSource = io.Source.fromFile(filename)
    val lines = (for (line <- bufferedSource.getLines()) yield line.toLong).toList
    bufferedSource.close
    lines
  }

  def readFileInt(filename: String): Seq[Int] = {
    val bufferedSource = io.Source.fromFile(filename)
    val lines = (for (line <- bufferedSource.getLines()) yield line.toInt).toList
    bufferedSource.close
    lines
  }

}
