package com.zackLabs.index.client.service;

import com.zackLabs.elasticmodel.index.IndexModel;

import java.util.List;

public interface ElasticIndexClient<T extends IndexModel> {
    List<String> save(List<T> documents);
}

