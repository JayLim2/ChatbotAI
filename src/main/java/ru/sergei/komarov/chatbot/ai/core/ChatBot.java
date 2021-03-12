package ru.sergei.komarov.chatbot.ai.core;

import org.springframework.stereotype.Component;
import ru.sergei.komarov.chatbot.ai.models.Message;

@Component
public class ChatBot {

    public Message buildAnswer(Message message) {
        Message answer = new Message();
        //TODO LSTM, RNN and other - here
        return answer;
    }

}
