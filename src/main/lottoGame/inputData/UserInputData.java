package inputDataTest;

import config.DataConfig;
import services.MessagePrinter;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UserInputData {
    MessagePrinter printedMessage = new MessagePrinter();

    public Set<Integer> loadNumberFromUSer(Scanner scanner) {
        Set<Integer> listOfNumberProvidedByUser = loadUserNumber(scanner);
        scanner.close();
        return listOfNumberProvidedByUser;
    }

    private Set<Integer> loadUserNumber(Scanner scanner) {
        Set<Integer> setGenerator = new HashSet<>();
        printedMessage.printText("You need to provide 6 number from range 1 to 100");
        while (setGenerator.size() < DataConfig.REQUIRED_NUMBERS) {
            printedMessage.printText("Please give number: " + (setGenerator.size() + 1));
            try {
                while (!scanner.hasNext()) {
                    if (!scanner.hasNextInt()) {
                        return Collections.emptySet();
                    }
                }
                int readNumber = scanner.nextInt();
                if (isInRange(readNumber)) {
                    setGenerator.add(readNumber);
                }else {
                    printedMessage.printText(readNumber + " is incorrect number, please enter number from 1 to 100");
                }
            } catch (Exception e) {
                printedMessage.printText("It is not a number");
                scanner.nextLine();
            }
        }
        return setGenerator;
    }

    private boolean isInRange(int number){
        return number >= DataConfig.MIN_RANGE && number <= DataConfig.MAX_RANGE;
    }
}


