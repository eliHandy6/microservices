# microservices
docker-compose -f common.yml -f kafka_cluster.yml up.

docker ps

winpty docker run -it --network=host confluentinc/cp-kafkacat kafkacat -L -b localhost:19092


  Kafka model will create and hold the Avro model that will hold the data that will be inserted into Kafka.
  Kafka admin will create Kafka topics programmatically and also check if topics are created.
  Kafka producer will include the Spring Kafka dependency and related implementation that will help you to write the logic to insert the data into Kafka topics.