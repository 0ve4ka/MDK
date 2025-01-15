public class Main {
    public static void main(String[] args) {
        final UserInputException userInputException = new UserInputException("Ошибка ввода!");
        System.out.println(userInputException.getMessage());
    }
}

class UserInputException extends Exception{
    public UserInputException() {
        super();
    }

    public UserInputException(String message) {
        super(message);
    }
}