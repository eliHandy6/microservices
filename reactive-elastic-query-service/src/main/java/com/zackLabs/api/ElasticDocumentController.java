package com.zackLabs.api;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zackLabs.elastic.query.service.common.model.ElasticQueryServiceRequestModel;
import org.zackLabs.elastic.query.service.common.model.ElasticQueryServiceResponseModel;
import com.zackLabs.business.ElasticQueryService;
import reactor.core.publisher.Flux;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/documents")
public class ElasticDocumentController {

    private static final Logger LOG = LoggerFactory.getLogger(ElasticDocumentController.class);

    private final ElasticQueryService elasticQueryService;

    public ElasticDocumentController(ElasticQueryService queryService) {
        this.elasticQueryService = queryService;
    }

    @PostMapping(value = "/get-doc-by-text",
            produces = MediaType.TEXT_EVENT_STREAM_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Flux<ElasticQueryServiceResponseModel> getDocumentByText(
            @RequestBody @Valid ElasticQueryServiceRequestModel requestModel) {
        Flux<ElasticQueryServiceResponseModel> response =
                elasticQueryService.getDocumentByText(requestModel.getText());
        response = response.log();
        LOG.info("Returning from query reactive service for text {}!", requestModel.getText());
        return response;
    }
}
