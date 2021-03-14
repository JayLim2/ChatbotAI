package ru.sergei.komarov.chatbot.ai.controllers;

import org.springframework.web.bind.annotation.*;
import ru.sergei.komarov.chatbot.ai.core.LanguageProcessor;
import ru.sergei.komarov.chatbot.ai.models.Message;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private LanguageProcessor languageProcessor;

    public ChatController(LanguageProcessor languageProcessor) {
        this.languageProcessor = languageProcessor;
    }

    @PostMapping("/getAnswer")
    public Message getAnswer(@RequestBody Message message) throws Exception {
        return languageProcessor.getAnswer(message);
    }

}
