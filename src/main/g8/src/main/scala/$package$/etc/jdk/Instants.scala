package $package$.etc.jdk

import java.time.{Instant, ZoneId}
import java.time.format.DateTimeFormatter
import scala.util.Try

object Instants:

    private val utcZone                           = ZoneId.of("UTC")
    val TimeFormatter: DateTimeFormatter          = DateTimeFormatter.ISO_DATE_TIME.withZone(utcZone)
    val CompactTimeFormatter: DateTimeFormatter   =
        DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmssX").withZone(utcZone)
    val CompactTimeFormatterMs: DateTimeFormatter =
        DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss.SSSX").withZone(utcZone)
    val CompactTimeFormatterNs: DateTimeFormatter =
        DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss.SSSSSSX").withZone(utcZone)

    def parseIso8601(s: String): Either[Throwable, Instant] =
        val tried = Try(Instant.from(CompactTimeFormatter.parse(s))) orElse
            Try(Instant.from(TimeFormatter.parse(s))) orElse
            Try(Instant.from(CompactTimeFormatterMs.parse(s))) orElse
            Try(Instant.from(CompactTimeFormatterNs.parse(s)))
        tried.toEither

    def formatCompactIso8601(instant: Instant): String =
        CompactTimeFormatter.format(instant)
