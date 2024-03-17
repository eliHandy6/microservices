package com.zackLabs.business.impl;


import com.zackLabs.elasticmodel.index.impl.TwitterIndexModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;
import org.zackLabs.elastic.query.service.common.model.ElasticQueryServiceResponseModel;
import org.zackLabs.elastic.query.service.common.transformer.ElasticToResponseModelTransformer;
import com.zackLabs.business.ElasticQueryService;
import com.zackLabs.business.ReactiveElasticQueryClient;
import reactor.core.publisher.Flux;

@Service
@Import(ElasticToResponseModelTransformer.class)
public class TwitterElasticQueryService implements ElasticQueryService {

    private static final Logger LOG = LoggerFactory.getLogger(TwitterElasticQueryService.class);

    private final ReactiveElasticQueryClient<TwitterIndexModel> reactiveElasticQueryClient;

    private final ElasticToResponseModelTransformer elasticToResponseModelTransformer;

    public TwitterElasticQueryService(ReactiveElasticQueryClient<TwitterIndexModel> elasticQueryClient,
                                      ElasticToResponseModelTransformer transformer) {
        this.reactiveElasticQueryClient = elasticQueryClient;
        this.elasticToResponseModelTransformer = transformer;
    }


    @Override
    public Flux<ElasticQueryServiceResponseModel> getDocumentByText(String text) {
        LOG.info("Querying reactive elasticsearch for text {}", text);
        return reactiveElasticQueryClient
                .getIndexModelByText(text)
                .map(elasticToResponseModelTransformer::getResponseModel);
    }
}
