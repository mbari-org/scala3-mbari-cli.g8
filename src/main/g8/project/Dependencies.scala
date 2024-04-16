import sbt._

object Dependencies {

  private val circeVersion = "0.14.6"
  lazy val circeCore       = "io.circe" %% "circe-core"    % circeVersion
  lazy val circeGeneric    = "io.circe" %% "circe-generic" % circeVersion
  lazy val circeParser     = "io.circe" %% "circe-parser"  % circeVersion

  lazy val jansi    = "org.fusesource.jansi"         % "jansi"           % "2.4.1"
  lazy val logback  = "ch.qos.logback"               % "logback-classic" % "1.5.5"
  lazy val mainargs = "com.lihaoyi"                 %% "mainargs"        % "0.6.3"
  lazy val methanol = "com.github.mizosoft.methanol" % "methanol"        % "1.7.0"
  lazy val munit    = "org.scalameta"               %% "munit"           % "1.0.0-M11"

  lazy val slf4jVersion = "2.0.13"
  lazy val slf4jApi     = "org.slf4j"      % "slf4j-api"                    % slf4jVersion
  lazy val slf4jJul     = "org.slf4j"      % "jul-to-slf4j"                 % slf4jVersion
  lazy val slf4jJdk     = "org.slf4j"      % "slf4j-jdk-platform-logging"   % slf4jVersion

  lazy val typesafeConfig = "com.typesafe"   % "config"          % "1.4.3"
  lazy val zio            = "dev.zio"       %% "zio"             % "2.0.22"
  
}
