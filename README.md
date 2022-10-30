# microservices
docker-compose -f common.yml -f kafka_cluster.yml up.

docker ps

winpty docker run -it --network=host confluentinc/cp-kafkacat kafkacat -L -b localhost:19092
