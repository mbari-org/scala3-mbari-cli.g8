import Dependencies._

Global / onChangedBuildSource := ReloadOnSourceChanges
Laika / sourceDirectories := Seq(baseDirectory.value / "docs")

ThisBuild / scalaVersion     := "3.1.0"
ThisBuild / version          := "0.5.6"
ThisBuild / organization     := "org.mbari"
ThisBuild / organizationName := "MBARI"
ThisBuild / startYear        := Some(2021)
ThisBuild / versionScheme    := Some("semver-spec")

lazy val root = project
  .in(file("."))
  .settings(
    name := "$name$",
    // sbt-header
    headerLicense := Some(
      HeaderLicense.Custom(
        """Copyright (c) Monterey Bay Aquarium Research Institute 2021
        |
        |tapemigration code is non-public software. Unauthorized copying of this file,
        |via any medium is strictly prohibited. Proprietary and confidential. 
        |Written by: Brian Schlining <brian@mbari.org>
        |""".stripMargin
      )
    ),
    javacOptions ++= Seq("-target", "11", "-source", "11"),
    laikaExtensions := Seq(
      laika.markdown.github.GitHubFlavor, 
      laika.parse.code.SyntaxHighlighting
    ),
    laikaIncludeAPI := true,
    resolvers ++= Seq(
      Resolver.githubPackages("mbari-org", "maven")
    ),
    libraryDependencies ++= Seq(
      circeCore,
      circeGeneric,
      circeParser,
      jansi          % Runtime,
      logback        % Runtime,
      methanol,
      munit          % Test,
      picocli,
      slf4jApi,
      typesafeConfig,
      zio
    ),
    scalacOptions ++= Seq(
      "-deprecation", // Emit warning and location for usages of deprecated APIs.
      "-encoding",
      "UTF-8",        // yes, this is 2 args. Specify character encoding used by source files.
      "-feature",     // Emit warning and location for usages of features that should be imported explicitly.
      "-language:existentials",
      "-language:higherKinds",
      "-language:implicitConversions",
      "-language:postfixOps",
      "-indent",
      "-rewrite",
      "-unchecked"
    )
  )

  // https://stackoverflow.com/questions/22772812/using-sbt-native-packager-how-can-i-simply-prepend-a-directory-to-my-bash-scrip
bashScriptExtraDefines ++= Seq(
  """addJava "-Dconfig.file=${app_home}/../conf/application.conf"""",
  """addJava "-Dlogback.configurationFile=${app_home}/../conf/logback.xml""""
)
batScriptExtraDefines ++= Seq(
  """call :add_java "-Dconfig.file=%APP_HOME%\conf\application.conf"""",
  """call :add_java "-Dlogback.configurationFile=%APP_HOME%\conf\logback.xml""""
)

