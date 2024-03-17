package com.zackLabs.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.zackLabs.elastic.query.service.common.model.ElasticQueryServiceResponseModel;

@Configuration
public class WebFluxConfig implements WebFluxConfigurer {



    @Override
    public void configureHttpMessageCodecs(org.springframework.http.codec.ServerCodecConfigurer configurer) {
        Jackson2JsonEncoder encoder = new Jackson2JsonEncoder(Jackson2ObjectMapperBuilder.json().build());
        configurer.defaultCodecs().jackson2JsonEncoder(encoder);
    }
}
