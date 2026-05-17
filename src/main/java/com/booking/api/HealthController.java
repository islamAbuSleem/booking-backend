package com.booking.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class HealthController {
    @GetMapping("/api/health")
    public Map<String, String> healthCheck() {
        return Map.of("status", "UP", "message", "Booking System API is running");
    }
}
