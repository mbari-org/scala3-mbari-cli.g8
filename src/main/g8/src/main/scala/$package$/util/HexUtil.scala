package util

object HexUtil:

  def toHex(bytes: Array[Byte]): String =
    val sb = new StringBuilder
    for (b <- bytes)
      sb.append(String.format("%02x", Byte.box(b)))
    sb.toString

  def fromHex(hex: String): Array[Byte] =
    hex
      .grouped(2)
      .toArray
      .map(i => Integer.parseInt(i, 16).toByte)
