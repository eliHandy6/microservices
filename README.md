http://localhost:8183/elastic-query-service/swagger-ui/index.html

http://localhost:8184/elastic-query-web-client/query-by-text
```sh
sudo chmod 666 /var/run/docker.sock
```


# microservices
```sh
docker-compose -f common.yml -f kafka_cluster.yml up.
```
```sh
docker ps
```
```sh
winpty docker run -it --network=host confluentinc/cp-kafkacat kafkacat -L -b localhost:19092
```

```sh
winpty docker run -it --network=host confluentinc/cp-kafkacat kafkacat -C -b localhost:19092 -t twitter-topic
```


  `Kafka model` will create and hold the Avro model that will hold the data that will be inserted into Kafka.<br/>
  `Kafka admin` will create Kafka topics programmatically and also check if topics are created.<br/>
  `Kafka producer` will include the Spring Kafka dependency and related implementation that will help you to write the logic to insert the data into Kafka topics.<br/>
  
  
  
  
```sh 
export JASYPT_ENCRYPTOR_PASSWORD='Demo_Pwd!2020'
```
```sh
echo $JASYPT_ENCRYPTOR_PASSWORD
```
```sh
winpty  docker exec -t 50e8f151251e /bin/bash
```
`sol :bug dos2unix [filename] --->exec /usr/local/bin/check-config-server-started.sh: no such file or directory`




I found a fix for max virtual memory areas `vm.max_map_count`
on Windows 10 and Docker Desktop:

open powershell
```sh
wsl -d docker-desktop
sysctl -w vm.max_map_count=262144
```

```sh
sysctl -w vm.max_map_count=262144
```
```yml
services:
  es:
    image: elasticsearch
    environment:
      - discovery.type=single-node
```

```sh 
sudo find . -type d -name 'target' -exec chmod -R a+rwx {} \;
``````
```sh 
sudo systemctl status postgresql.service

sudo systemctl enable postgresql.service
sudo -i -u postgres
select version();
\du
alter user postgres with password 'admin2030'
\l

CREATE USER keyclock WITH ENCRYPTED PASSWORD 'keyclock';
GRANT ALL PRIVILEGES ON DATABASE keyclock TO keyclock;
``````
```sh 
http://localhost:8184/elastic-query-web-client/login/oauth2/code/keyclock
http://localhost:8183/elastic-query-service/login/oauth2/code/keyclock
``````
```sh 
curl -X  POST -d 'grant_type=password&username=app_user&password=app_user&client_id=elastic-query-web-client&client_secret=0fed21ea-592b-4da7-bbf1-087d0c7bdbc4' http://localhost:8081/auth/realms/microservices-realm/protocol/openid-connect/token
``````



