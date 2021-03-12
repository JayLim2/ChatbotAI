package ru.sergei.komarov.chatbot.ai.core;

import org.springframework.stereotype.Component;
import ru.sergei.komarov.chatbot.ai.models.Advice;
import ru.sergei.komarov.chatbot.ai.models.Message;

import java.util.ArrayList;
import java.util.List;

@Component
public class GrammarChecker {

    public void checkGrammarAndSetAdvices(Message message) {
        List<Advice> advices = checkGrammar(message);
        message.setAdvices(advices);
    }

    public List<Advice> checkGrammar(Message message) {
        List<Advice> advices = new ArrayList<>();
        //TODO build advices here
        return advices;
    }

}
