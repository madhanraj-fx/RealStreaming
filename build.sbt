name := "my_scala_test"

version := "0.1"

//scalaVersion := "2.12.4"
scalaVersion := "2.10.4"

libraryDependencies += "org.apache.spark" % "spark-core_2.10" % "2.2.1"
libraryDependencies += "org.apache.spark" % "spark-streaming_2.10" % "2.2.1"
libraryDependencies += "org.apache.spark" % "spark-streaming-kafka-0-10_2.10" % "2.2.0"