package $package$.etc.jdk

import java.net.URI
import java.nio.file.Paths
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

object Uris:

    def filename(uri: URI): String =
        Paths.get(uri.getPath).getFileName.toString

    def encode(uri: URI): String =
        URLEncoder.encode(uri.toString(), StandardCharsets.UTF_8.toString())

