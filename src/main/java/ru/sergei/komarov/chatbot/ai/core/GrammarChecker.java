package ru.sergei.komarov.chatbot.ai.core;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import ru.sergei.komarov.chatbot.ai.models.Advice;
import ru.sergei.komarov.chatbot.ai.models.AdviceType;
import ru.sergei.komarov.chatbot.ai.models.Message;
import ru.sergei.komarov.chatbot.ai.models.MistakeType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
public class GrammarChecker {

    public void checkGrammarAndSetAdvices(Message message) throws Exception {
        List<Advice> advices = checkGrammar(message);
        message.setAdvices(advices);
    }

    public List<Advice> checkGrammar(Message message) throws Exception {
        List<Advice> advices = new ArrayList<>();
        int length = message.getMessage().length();
        int startPos = length / 2;
        int endPos = Math.min(startPos + new Random().nextInt(length), length);
        Advice advice = new Advice();
        advice.setAdviceType(AdviceType.ERROR);
        advice.setMistakeType(MistakeType.GRAMMAR);
        advice.setStartPosition(startPos);
        advice.setEndPosition(endPos);
        advice.setComment("Я робот-сгибальщик, что ты от меня хочешь услышать? " +
                "Ликбез по английской грамматике?");
        advices.add(advice);

        advice = new Advice();
        advice.setAdviceType(AdviceType.WARN);
        advice.setMistakeType(MistakeType.ORTHOGRAPHY);
        advice.setStartPosition(startPos);
        advice.setEndPosition(endPos);
        advice.setComment("Поцелуй мой блестящий зад.");
        advices.add(advice);

        advice = new Advice();
        advice.setAdviceType(AdviceType.INFO);
        advice.setMistakeType(MistakeType.CUSTOM);
        advice.setStartPosition(startPos);
        advice.setEndPosition(endPos);
        advice.setComment("Бла-бла-бла, один пустой трёп. Пойду выпью пива.");

        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = "{\n" +
                "\t\"protocol\": {\n" +
                "\t\t\"resolveIntersection\": \"merge\",\n" +
                "\t\t\"mergePolicy\": {\n" +
                "\t\t\t\"styles\": {\n" +
                "\t\t\t\t\"underlineColor\": null,\n" +
                "\t\t\t\t\"fontColor\": \"white\",\n" +
                "\t\t\t\t\"backgroundColor\": \"green\"\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t},\n" +
                "\t\"data\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"startPosition\": 2,\n" +
                "\t\t\t\"endPosition\": 9,\n" +
                "\t\t\t\"mistakeType\": \"GRAMMAR\",\n" +
                "\t\t\t\"adviceType\": \"ERROR\",\n" +
                "\t\t\t\"comment\": \"Грамматика хромает, бро.\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"startPosition\": 4,\n" +
                "\t\t\t\"endPosition\": 11,\n" +
                "\t\t\t\"mistakeType\": \"ORTHOGRAPHY\",\n" +
                "\t\t\t\"adviceType\": \"WARN\",\n" +
                "\t\t\t\"comment\": \"Моя твоя не понимать.\"\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";
        JsonNode customData = mapper.readTree(jsonStr);
        advice.setCustomData(customData);
        advices.add(advice);

        int i = new Random().nextInt(advices.size());
        if (i < advices.size()) {
            return Collections.singletonList(advices.get(i));
        } else {
            return Collections.emptyList();
        }
    }

}
