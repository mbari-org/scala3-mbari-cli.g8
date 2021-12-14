package $package$.etc.circe

import io.circe._
import io.circe.generic.semiauto._
import scala.util.Try
import java.net.URL
import $package$.util.HexUtil

object CirceCodecs:

  given byteArrayEncoder: Encoder[Array[Byte]] = new Encoder[Array[Byte]]:
    final def apply(xs: Array[Byte]): Json =
      Json.fromString(HexUtil.toHex(xs))
  given byteArrayDecoder: Decoder[Array[Byte]] = Decoder
    .decodeString
    .emapTry(str => Try(HexUtil.fromHex(str)))

  given urlDecoder: Decoder[URL] = Decoder
    .decodeString
    .emapTry(str => Try(new URL(str)))
  given urlEncoder: Encoder[URL] = Encoder
    .encodeString
    .contramap(_.toString)

  private val printer = Printer.noSpaces.copy(dropNullValues = true)

  /**
   * Convert a circe Json object to a JSON string
   * @param value
   *   Any value with an implicit circe coder in scope
   */
  extension (json: Json) def stringify: String = printer.print(json)

  /**
   * Convert an object to a JSON string
   * @param value
   *   Any value with an implicit circe coder in scope
   */
  extension [T: Encoder](value: T) def stringify: String = Encoder[T].apply(value).stringify

