import java.util.Scanner;

public class Main {
    public enum Operation {
        ADD("ADD"),
        SUB("SUB"),
        MUL("MUL"),
        DIV("DIV");

        String text;

        Operation(String text) {
            this.text = text;
        }

        public static Operation parse(String text) throws Exception {
            for (Operation operation : values()) {
                if (operation.text.equalsIgnoreCase(text)) {
                    return operation;
                }
            }
            throw new Exception("Operation " + text + " not found");
        }
    }


    public static void main(String[] args) {
        String stringIn = "SUB 1 1 1"; // TODO: from user

        Scanner action = new Scanner(System.in);
        String whatAction = action.nextLine();

        String[] items = whatAction.split("\\s+");
        if (items.length > 0) {
            try {
                doOperation(items[0], getElements(items));
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void doOperation(String operation, Integer... elements) {
        Operation enumOperation;
        try {
            enumOperation = Operation.parse(operation);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("result: ");
        int result = 0;
        switch (enumOperation) {
            case ADD:
                for (Integer element : elements) {
                    result += element;
                }
                break;
            case SUB:
                for (int i = 0; i < elements.length; i++) {
                    if (i == 0) {
                        result = elements[i];
                    } else {
                        result -= elements[i];
                    }
                }
                break;
            case MUL:
                for (int i = 0; i < elements.length; i++) {
                    if (i == 0) {
                        result = elements[i];
                    } else {
                        result *= elements[i];
                    }
                }
                break;
            case DIV:
                for (int i = 0; i < elements.length; i++) {
                    if (i == 0) {
                        result = elements[i];
                    } else {
                        try {
                            result /= elements[i];
                        } catch (ArithmeticException e) {
                            System.out.println(e.getMessage());
                            return;
                        }
                    }
                }
                break;
        }
        System.out.println(stringBuilder.append(result));
    }

    private static Integer[] getElements(String[] elements) throws NumberFormatException {
        Integer[] items = new Integer[elements.length - 1];
        for (int i = 1; i <= elements.length - 1; i++) {
            items[i - 1] = Integer.parseInt(elements[i]);
        }
        return items;
    }
}