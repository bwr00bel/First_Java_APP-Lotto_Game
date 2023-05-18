import inputData.UserInputData;
import services.Game;
import services.LottoGame;
import services.MessagePrinter;
import services.RandomNumberGenerator;

import java.util.Scanner;

public class LottoApp {

    public static void main(String[] args) {

            Game lotto = new LottoGame(new RandomNumberGenerator(),
                    new UserInputData(),
                    new MessagePrinter(),
                    new Scanner(System.in));
            lotto.start();

    }
}