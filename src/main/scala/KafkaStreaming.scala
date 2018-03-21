import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming._
//import org.apache.spark.streaming.kafka.KafkaUtils
//import org.apache.spark.streaming.kafka._
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.streaming.kafka010._
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe

object KafkaStreaming {

  def main(args: Array[String]) {

    val conf = new SparkConf()
    conf.setMaster("local")
    conf.setAppName("Word Count")

    val ssc = new StreamingContext(conf, Seconds(5))
    //    val input = ssc.textFileStream("file:///Users/mselv7/test/")
    //    val lines = input.flatMap(_.split(" "))
    //    val words = lines.map(word => (word, 1))
    //    val counts = words.reduceByKey(_ + _)
    //    print(" printing ")
    //    input.print()
    val preferredHosts = LocationStrategies.PreferConsistent
    val topics = List("sampleTopic")
    val kafkaParams = Map(
      "bootstrap.servers" -> "localhost:9092",
      "key.deserializer" -> classOf[StringDeserializer],
      "value.deserializer" -> classOf[StringDeserializer],
      "group.id" -> "spark-streaming-notes",
      "auto.offset.reset" -> "earliest"
    )

    val dstream = KafkaUtils.createDirectStream[String, String](
      ssc,
      preferredHosts,
      ConsumerStrategies.Subscribe[String, String](topics, kafkaParams))

    dstream.map(x => x.value()).print()

    ssc.start()

    // the above code is printing out topic details every 5 seconds
    // until you stop it.
    ssc.awaitTermination()

    ssc.stop(stopSparkContext = false)
  }

}