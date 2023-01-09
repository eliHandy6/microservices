package com.zackLabs.kafka.to.elastic.service.consumer.imp;

import com.zackLabs.elasticmodel.index.impl.TwitterIndexModel;
import com.zackLabs.index.client.service.ElasticIndexClient;
import com.zackLabs.kafka.admin.client.KafkaAdminClient;
import com.zackLabs.kafka.consumer.config.KafkaConsumerConfig;
import com.zackLabs.kafka.to.elastic.service.consumer.KafkaConsumer;
import com.zackLabs.kafka.to.elastic.service.transformer.AvroToElasticModelTransformer;
import com.zackLabs.kafkaa.avro.model.TwitterAvroModel;
import com.zackilabs.appconfigdata.config.KafkaConfigData;
import com.zackilabs.appconfigdata.config.KafkaConsumerConfigData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.context.annotation.Import;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Import(KafkaConsumerConfig.class)
public class TwitterKafkaConsumer implements KafkaConsumer<TwitterAvroModel> {
    private static final Logger LOG = LoggerFactory.getLogger(TwitterKafkaConsumer.class);
    private final KafkaAdminClient kafkaAdminClient;
    private final KafkaConfigData kafkaConfigData;
    private final KafkaConsumerConfigData kafkaConsumerConfigData;
    private final KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;
    private final AvroToElasticModelTransformer avroToElasticModelTransformer;
    private final ElasticIndexClient<TwitterIndexModel> elasticIndexClient;

    public TwitterKafkaConsumer(KafkaListenerEndpointRegistry listenerEndpointRegistry,
                                KafkaAdminClient adminClient,
                                KafkaConfigData configData, KafkaConsumerConfigData kafkaConsumerConfigData, AvroToElasticModelTransformer avroToElasticModelTransformer, ElasticIndexClient<TwitterIndexModel> elasticIndexClient) {
        this.kafkaListenerEndpointRegistry = listenerEndpointRegistry;
        this.kafkaAdminClient = adminClient;
        this.kafkaConfigData = configData;
        this.kafkaConsumerConfigData = kafkaConsumerConfigData;
        this.avroToElasticModelTransformer = avroToElasticModelTransformer;
        this.elasticIndexClient = elasticIndexClient;
    }

    @EventListener
    public void onAppStarted(ApplicationStartedEvent event) {
        kafkaAdminClient.checkTopicsCreated();
        LOG.info("Topics with name {} is ready for operations!", kafkaConfigData.getTopicNamesToCreate().toArray());
//        Objects.requireNonNull(kafkaListenerEndpointRegistry
//                .getListenerContainer(kafkaConsumerConfigData.getConsumerGroupId())).start();

    }


    @Override
    @KafkaListener(id = "twitterTopicListener", topics = "${kafka-config.topic-name}")
    public void receive(@Payload List<TwitterAvroModel> messages,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) List<Long> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        LOG.info("{} number of message received with keys {}, partitions {} and offsets {}, " +
                        "sending it to elastic: Thread id {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString(),
                Thread.currentThread().getId());

        List<TwitterIndexModel> twitterIndexModels = avroToElasticModelTransformer.getElasticModels(messages);
        List<String> documentIds = elasticIndexClient.save(twitterIndexModels);
        LOG.info("Documents saved to elasticsearch with ids {}", documentIds.toArray());
    }
}
