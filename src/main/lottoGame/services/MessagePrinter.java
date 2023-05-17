package services;

public class MessagePrinter {
    public void printText(String text) {
        System.out.println(text);
    }

    public String printUserMessage(int size) {
        String result = "";
        switch (size) {
            case 0:
                result = "Please try again, you haven't hit any numbers yet.";
                break;
            case 1:
                result = "Good attitude, you hit " + size + " number!";
                break;
            case 6:
                result = "CONGRATULATIONS, YOU WIN, you hit " + size + " numbers";
                break;
            default:
                result = "Excellent, you hit " + size + " numbers";
                break;
        }
        return result;
    }
}

