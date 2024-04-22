import Dependencies._

ThisBuild / scalaVersion     := "2.13.12"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val commonClasses = (project in file("platform/common-classes"))
  .settings(
    name := "Common Classes",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.9" % Test,
      "org.apache.spark" %% "spark-core" % "3.5.1" % Provided,
      "org.apache.spark" %% "spark-sql" % "3.5.1" % Provided
    )
  )
  .dependsOn(utils)

lazy val utils = (project in file("subdomains/utils"))
  .settings(
    name := "Utils",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.9" % Test
    )
  )

lazy val domainA = (project in file("subdomains/domainA"))
  .settings(
    name := "Domain A",
    Compile / scalaSource := baseDirectory.value / "src" / "main" / "scala",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.9" % Test,
      "org.apache.spark" %% "spark-core" % "3.5.1" % Provided,
      "org.apache.spark" %% "spark-sql" % "3.5.1" % Provided
    )
  )
  .dependsOn(commonClasses, utils)

lazy val domainB = (project in file("subdomains/domain-B"))
  .settings(
    name := "Domain B",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.9" % Test,
      "org.apache.spark" %% "spark-core" % "3.5.1" % Provided,
      "org.apache.spark" %% "spark-sql" % "3.5.1" % Provided
    )
  )
  .dependsOn(commonClasses, utils)

lazy val domainC = (project in file("subdomains/domain-C"))
  .settings(
    name := "Domain C",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.9" % Test,
      "org.apache.spark" %% "spark-core" % "3.5.1" % Provided,
      "org.apache.spark" %% "spark-sql" % "3.5.1" % Provided
    )
  )
  .dependsOn(commonClasses, utils)

lazy val domainD = (project in file("subdomains/domain-D"))
  .settings(
    name := "Domain D",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.9" % Test,
      "org.apache.spark" %% "spark-core" % "3.5.1" % Provided,
      "org.apache.spark" %% "spark-sql" % "3.5.1" % Provided
    )
  )
  .dependsOn(commonClasses, utils)

lazy val domainE = (project in file("subdomains/domain-E"))
  .settings(
    name := "Domain E",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.9" % Test,
      "org.apache.spark" %% "spark-core" % "3.5.1" % Provided,
      "org.apache.spark" %% "spark-sql" % "3.5.1" % Provided
    )
  )
  .dependsOn(commonClasses, utils)

lazy val root = (project in file("."))
  .aggregate(commonClasses, domainA, domainB, domainC, domainD, domainE, utils)
  .dependsOn(commonClasses, utils)
  .settings(
    name := "Testing Devin Code Migrations Scala",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.9" % Test,
      "org.apache.spark" %% "spark-core" % "3.5.1" % Provided,
      "org.apache.spark" %% "spark-sql" % "3.5.1" % Provided,
      "org.scalameta" %% "munit" % "0.7.29" % Test
    )
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
