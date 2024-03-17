package com.zackLabs.config;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public interface ElasticQueryServiceResponseModelMixin {
    @JsonProperty("id")
    String getId();

    @JsonProperty("userId")
    Long getUserId();

    @JsonProperty("text")
    String getText();

    @JsonProperty("createdAt")
    LocalDateTime getCreatedAt();
}
