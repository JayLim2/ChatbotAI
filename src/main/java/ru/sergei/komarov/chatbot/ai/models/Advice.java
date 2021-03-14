package ru.sergei.komarov.chatbot.ai.models;

import com.fasterxml.jackson.databind.JsonNode;

public class Advice {

    private Integer id;
    private Message message;
    private int startPosition;
    private int endPosition;
    private MistakeType mistakeType;
    private AdviceType adviceType;
    private String comment;
    private JsonNode customData;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
    }

    public MistakeType getMistakeType() {
        return mistakeType;
    }

    public void setMistakeType(MistakeType mistakeType) {
        this.mistakeType = mistakeType;
    }

    public AdviceType getAdviceType() {
        return adviceType;
    }

    public void setAdviceType(AdviceType adviceType) {
        this.adviceType = adviceType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public JsonNode getCustomData() {
        return customData;
    }

    public void setCustomData(JsonNode customData) {
        this.customData = customData;
    }
}
