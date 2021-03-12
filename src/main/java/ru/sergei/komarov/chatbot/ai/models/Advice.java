package ru.sergei.komarov.chatbot.ai.models;

import com.fasterxml.jackson.databind.JsonNode;

public class Advice {

    private Integer id;
    private Message message;
    private int startPosition;
    private int endPosition;
    private MistakeType mistakeType;
    private AdviceType adviceType;
    private JsonNode customData;

}
