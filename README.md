# DemoSpringBootKafka

* [`DemoSpringBootKafkaProducer`](./DemoSpringBootKafkaProducer/): Spring Boot app that publishes messages to a topic of a Kafka cluster.
* [`DemoSpringBootKafkaConsumer`](./DemoSpringBootKafkaConsumer/): Spring Boot app that cosumes published messages from a Kafka cluster.


## How to start a kafka cluster (windows)

1. Starts the zookeeper
```
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```
<br>

2. Starts the kafka-server
```
.\bin\windows\kafka-server-start.bat .\config\server.properties
```
<br>

3. Create a new topic
```
.\bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test1
```
<br>

4. Create a new topic
```
.\bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test2
```
<br>

5. List all the topics under localhost:9092
```
.\bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092
```
<br>

6. Add a topic to producer broker-list (We'll get an input-caret(>) to enter our message(s))
```
.\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic test1
```
<br>

7. Add a topic to consumer (We'll get our message(s) that the producer published)
```
.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test1 --from-beginning
```
