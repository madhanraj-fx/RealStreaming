
# KAFKA 

### To start Zoo Keeper
```sh bin/zookeeper-server-start.sh config/zookeeper.properties```


### To start Kafka Server
```sh bin/kafka-server-start.sh config/server.properties```


### To create a topic in Kafka

```bin/kafka-topics.sh --create --zookeeper <ZOOKEEPER_URL:PORT> --replication-factor <NO_OF_REPLICATIONS> --partitions <NO_OF_PARTITIONS> --topic <TOPIC_NAME>```

```bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic sampleTopic```


### To describe a Topic 
```bin/kafka-topics.sh --describe --zookeeper localhost:2181 --topic sampleTopic```


### To create Consumer Group
```bin/kafka-console-consumer.sh --bootstrap-server localhost:2181 --topic sampleTopic --consumer-property group.id=sampleGroup```


### To describe Consumer Group
```bin/kafka-consumer-groups.sh --bootstrap-server local-host:2181 --describe --group sampleGroup```


### To create a Kafka Console Producer
```bin/kafka-console-producer.sh --broker-list localhost:9091 --topic sampleTopic```


### To create a Kafka Console Consumer
```bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic sampleTopic --from-beginning```


