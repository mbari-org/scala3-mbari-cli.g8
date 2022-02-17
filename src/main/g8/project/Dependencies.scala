import sbt._

object Dependencies {

  private val circeVersion = "0.14.1"
  lazy val circeCore       = "io.circe" %% "circe-core"    % circeVersion
  lazy val circeGeneric    = "io.circe" %% "circe-generic" % circeVersion
  lazy val circeParser     = "io.circe" %% "circe-parser"  % circeVersion

  lazy val jansi    = "org.fusesource.jansi"         % "jansi"           % "2.4.0"
  lazy val logback  = "ch.qos.logback"               % "logback-classic" % "1.3.0-alpha10"
  lazy val methanol = "com.github.mizosoft.methanol" % "methanol"        % "1.6.0"
  lazy val munit    = "org.scalameta"               %% "munit"           % "1.0.0-M1"
  lazy val picocli  = "info.picocli"                 % "picocli"         % "4.6.1"

  lazy val slf4jVersion = "2.0.0-alpha6"
  lazy val slf4jApi     = "org.slf4j"      % "slf4j-api"                    % slf4jVersion
  lazy val slf4jJul     = "org.slf4j"      % "jul-to-slf4j"                 % slf4jVersion
  lazy val slf4jJdk     = "org.slf4j"      % "slf4j-jdk-platform-logging"   % slf4jVersion

  lazy val typesafeConfig = "com.typesafe"   % "config"          % "1.4.1"
  lazy val zio            = "dev.zio"       %% "zio"             % "1.0.12"
  
}
