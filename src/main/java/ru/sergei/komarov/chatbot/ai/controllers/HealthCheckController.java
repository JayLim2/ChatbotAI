package ru.sergei.komarov.chatbot.ai.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hc")
public class HealthCheckController {

    @Value("${ai.service.version}")
    private String version;

    @GetMapping("/version")
    public String getVersion() {
        return "AI: " + version;
    }

}
