package com.zackLabs.business;


import com.zackLabs.model.ElasticQueryServiceResponseModel;

import java.util.List;

public interface ElasticQueryService {

    ElasticQueryServiceResponseModel getDocumentById(String id);

    List<ElasticQueryServiceResponseModel> getDocumentByText(String text);

    List<ElasticQueryServiceResponseModel> getAllDocuments();
}
