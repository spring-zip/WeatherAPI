package com.myCompany.WA.program;

import java.util.Scanner;

public class InputData {
    private String command;
    private int historyNumber;

    public InputData(Scanner input) {
        if (input.hasNextInt()) {
            command = "historyNumber";
            historyNumber = input.nextInt();
        } else {
            command = input.next();
        }
    }

    public String getCommand() {
        return command;
    }

    public int getHistoryNumber() {
        return historyNumber;
    }
}
