package ru.dyerq;

public class Main {
    public static void main(String[] args) {
        Field field = new Field();
        tryCompleteField(field, 1, 0);
    }

    private static void tryCompleteField(Field field, int i, int j) {
        for (int val = 1; val <= 5; val++) {
            if (field.canOccupy(i, j, val)) {
                field.occupy(i, j, val);
                if (i == 4 && j == 4) {
                    System.out.println("new complete field found");
                    System.out.println(field);
                } else {
                    tryCompleteField(field, j == 4 ? i + 1 : i, j == 4 ? 0 : j + 1);
                }
                field.deoccupy(i, j);
            }
        }
    }
}
