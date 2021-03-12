package ru.sergei.komarov.chatbot.ai.core;

import org.springframework.stereotype.Component;
import ru.sergei.komarov.chatbot.ai.models.Message;
import ru.sergei.komarov.chatbot.ai.models.User;

import java.time.LocalDateTime;

@Component
public class LanguageProcessor {

    private ChatBot chatBot;
    private GrammarChecker grammarChecker;

    public LanguageProcessor(ChatBot chatBot, GrammarChecker grammarChecker) {
        this.chatBot = chatBot;
        this.grammarChecker = grammarChecker;
    }

    public Message getAnswer(Message message) {
        Message answer;
        //1. Get answer by LSTM/RNN
        answer = chatBot.buildAnswer(message);
        //2. Validate student's mistakes and create advices
        grammarChecker.checkGrammarAndSetAdvices(message);
        //3. Return
        answer.setDateTime(LocalDateTime.now());
        answer.setMessage("Kill. All. Humans.");
        answer.setChat(message.getChat());
        User system = new User();
        system.setId(2);
        answer.setUser(system);
        return answer;
    }

}
