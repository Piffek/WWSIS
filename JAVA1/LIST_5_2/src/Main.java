package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

        public static Operation parse(String text) throws SelectOperationException {
            for (Operation operation : values()) {
                if (operation.text.equalsIgnoreCase(text)) {
                    return operation;
                }
            }
            throw new SelectOperationException(text);
        }
    }


    public static void main(String[] args) {

        List<String> fileItems =  read("D:\\test.txt");
        List<String> resultItems =  new ArrayList<>();
        for (String item : fileItems){
            StringBuilder sb = new StringBuilder(item).append( " = ");
            sb.append(getOperationResult(item.split("\\s+")));
            resultItems.add(sb.toString());
        }
        store("D:\\testResult.txt", resultItems);
    }

    private static List<String> read(final String fileName) {
        List<String> output = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));

            String line;
            while ((line = reader.readLine()) != null) {
                output.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close(); // zawsze zamykamy takie rzeczy dla pamiecie !!! reader, writer, cursor itd
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return output;
    }

    private static void store(final String fileName, final List<String> data) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fileName,
                    true));
            for (String item : data){
                writer.append(item);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private static String getOperationResult(String... items){
        StringBuilder stringBuilder = new StringBuilder();
        if (items.length > 1) {
            try {
                stringBuilder.append(getOperationResult(items[0], parseElements(items)));
            } catch (NumberFormatException e) {
                stringBuilder.append(e.getMessage());
            }
        }
        return stringBuilder.toString();
    }

    private static String getOperationResult(String operation, Integer... elements) {
        Operation enumOperation;
        try {
            enumOperation = Operation.parse(operation);
        } catch (Exception e) {
            return e.getMessage();

        }
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
                        if (elements[i] == 0){
                            return new Exception("Divide By ZERO!").getMessage();
                        }
                        result /= elements[i];
                    }
                }
                break;
        }
        return String.valueOf(result);
    }

    private static Integer[] parseElements(String[] elements) throws NumberFormatException {
        Integer[] items = new Integer[elements.length - 1];
        for (int i = 1; i <= elements.length - 1; i++) {
            items[i - 1] = Integer.parseInt(elements[i]);
        }
        return items;
    }
}