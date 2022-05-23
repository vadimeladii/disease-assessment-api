package md.utm.ati.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.http2client.Http2Client;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import md.utm.ati.client.PredictorClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class PredictorClientConfiguration {

    @Value( "${predictor.client.url}" )
    private String predictorClientUrl;

    @Bean
    public PredictorClient predictorClient(ObjectMapper objectMapper, Request.Options requestOptions) {
        return Feign.builder()
                .client(new Http2Client())
                .options(requestOptions)
                .encoder(new JacksonEncoder(objectMapper))
                .decoder(new JacksonDecoder(objectMapper))
                .logLevel(Logger.Level.FULL)
                .logger(new Slf4jLogger(PredictorClient.class))
                .target(PredictorClient.class, predictorClientUrl);
    }

    @Bean
    public Request.Options requestOptions() {
        return new Request.Options(
                5000, TimeUnit.MILLISECONDS,
                5000, TimeUnit.MILLISECONDS, true
        );
    }
}
