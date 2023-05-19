package services;

import config.DataConfig;
import inputDataTest.UserInputData;
import lombok.Data;

import java.util.Scanner;
import java.util.Set;

@Data
public class LottoGame implements Game {

    private final RandomNumberGenerator randomNumberGenerator;

    private final UserInputData userInputData;
    private final MessagePrinter messagePrinter;


    private final Scanner scanner;


    @Override
    public LottoGameResult start() {
        LottoGameResult result = lottoGameResult();
        messagePrinter.printText(result.toString());
        return result;
    }

    private LottoGameResult lottoGameResult() {
        Set<Integer> randomSetNumbers = randomNumberGenerator.generateRandomNumbers();
        Set<Integer> userInputNumbers = userInputData.loadNumberFromUSer(scanner);
        String stringFromSets = createMessageFromSets(randomSetNumbers, userInputNumbers);
        String result = showResult(compareHitNumbers(randomSetNumbers, userInputNumbers));
        String finalResult = showFinalResult(stringFromSets, result);
        return new LottoGameResult(finalResult);


    }

    private String showResult(int hitSize) {

        return messagePrinter.printUserMessage(hitSize);
    }

    private String showFinalResult(String stringFromSets, String result) {
        return stringFromSets
                + "\n"
                + result;
    }

    private int compareHitNumbers(Set<Integer> randomSetNumbers, Set<Integer> userInputNumbers) {
        userInputNumbers.retainAll(randomSetNumbers);
        return userInputNumbers.size();
    }

    private String createMessageFromSets(Set<Integer> randomSetNumbers, Set<Integer> userInputData) {
        StringBuilder str = new StringBuilder();
        str.append(String.format("%25s", DataConfig.DRAWN_MESSAGE))
                .append(createStringFromSet(randomSetNumbers))
                .append("\n")
                .append(String.format("%25s", DataConfig.PROVIDED_MESSAGE))
                .append(createStringFromSet(userInputData));
        return str.toString();
    }

    private String createStringFromSet(Set<Integer> setNumbers) {
        StringBuilder str = new StringBuilder();
        setNumbers.forEach(i -> str.append(String.format("%2s", i)).append(" "));
        return str.toString();
    }
}
