package com.zackLabs.reactive.elastic.web.client.service;


import com.zackLabs.elastic.query.web.client.common.model.ElasticQueryWebClientRequestModel;
import com.zackLabs.elastic.query.web.client.common.model.ElasticQueryWebClientResponseModel;
import reactor.core.publisher.Flux;

public interface ElasticQueryWebClient {

    Flux<ElasticQueryWebClientResponseModel> getDataByText(ElasticQueryWebClientRequestModel request);
}
