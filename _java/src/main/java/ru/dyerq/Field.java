package ru.dyerq;

public class Field {
    boolean[][] rowOccupied = new boolean[5][5];
    boolean[][] columnOccupied = new boolean[5][5];
    boolean[] mainDiagonalOccupied = new boolean[5];
    boolean[] secondaryDiagonalOccupied = new boolean[5];
    int[][] a = new int[5][5];

    public Field() {
        for (int i = 0; i < 5; i++) {
            a[0][i] = i + 1;
            rowOccupied[0][i] = true;
            columnOccupied[i][i] = true;
        }
        mainDiagonalOccupied[0] = true;
        secondaryDiagonalOccupied[4] = true;
    }

    public boolean canOccupy(int i, int j, int val) {
        return !rowOccupied[i][val - 1] && !columnOccupied[j][val - 1]
                && (i != j || !mainDiagonalOccupied[val - 1])
                && (i + j != 4 || !secondaryDiagonalOccupied[val - 1])
                ;
    }

    public void occupy(int i, int j, int val) {
        a[i][j] = val;
        rowOccupied[i][val - 1] = true;
        columnOccupied[j][val - 1] = true;
        if (i == j) {
            mainDiagonalOccupied[val - 1] = true;
        }
        if (i + j == 4) {
            secondaryDiagonalOccupied[val - 1] = true;
        }
    }

    public void deoccupy(int i, int j) {
        int val = a[i][j];
        a[i][j] = 0;
        rowOccupied[i][val - 1] = false;
        columnOccupied[j][val - 1] = false;
        if (i == j) {
            mainDiagonalOccupied[val - 1] = false;
        }
        if (i + j == 4) {
            secondaryDiagonalOccupied[val - 1] = false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < 5; i++) {
            if (i > 0) {
                sb.append(",\n");
            }
            sb.append("'");
            for (int j = 0; j < 5; j++) {
                sb.append(a[i][j]);
            }
            sb.append("'");
        }
        sb.append("]");
        return sb.toString();
    }
}
