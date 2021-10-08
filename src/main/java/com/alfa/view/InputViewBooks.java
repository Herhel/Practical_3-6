package com.alfa.view;

import java.util.Scanner;

public class InputViewBooks {
    private static Scanner sc = new Scanner(System.in);

    public String inputItem() {
        return sc.nextLine();
    }

    public String inputBook() {
        return sc.nextLine();
    }

    public String inputSearchParam() {
        return sc.nextLine();
    }

    public int inputSearchYear(ViewBooks view) {
        while (!sc.hasNextInt()) {
            sc.nextLine();
            view.printMessage(ViewConstants.ERROR_INPUT_YEAR);
        }
        int year = sc.nextInt();
        sc.nextLine();
        return year;
    }
}