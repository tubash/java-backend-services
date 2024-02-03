package com.example.backend.actuator;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Endpoint(id="custom")
@RequiredArgsConstructor
public class CustomActuator {

    private final Environment env;
    @Value("${spring.datasource.url}")
    private String dbUrl;

    @ReadOperation
    public Map<String, String> get() {
        return Map.of(
            "active_profiles", String.join(", ", env.getActiveProfiles()),
            "db_url", dbUrl
        );
    }
}
