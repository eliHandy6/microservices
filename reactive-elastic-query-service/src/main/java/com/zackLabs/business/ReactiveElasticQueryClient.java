package com.zackLabs.business;


import com.zackLabs.elasticmodel.index.IndexModel;
import com.zackLabs.elasticmodel.index.impl.TwitterIndexModel;
import reactor.core.publisher.Flux;

public interface ReactiveElasticQueryClient<T extends IndexModel> {

    Flux<TwitterIndexModel> getIndexModelByText(String text);
}
