package com.pl.mushy;

import com.pl.mushy.logic.ConverterCsv;
import com.pl.mushy.logic.ConverterXml;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        String pathIn = "testingData/data.txt", pathOut = "converted.txt";

        ConverterXml converterXml = new ConverterXml();
        ConverterCsv converterCsv = new ConverterCsv();

        do {
            System.out.println("Select an action:\n1 - Convert text to xml\n2 - Convert text to csv\n0 - Exit");
            i = scanner.nextInt();

            switch (i) {
                case 1:
                    System.out.println("Input file path: ");
                    pathIn = scanner.next();
                    System.out.println("Output file path: ");
                    pathOut = scanner.next();
                    try {
                        converterXml.begin(pathIn, pathOut);
                    } catch (Exception e) {
                        System.out.println("No such file or directory");
                    }
                    break;
                case 2:
                    System.out.println("Input file path: ");
                    pathIn = scanner.next();
                    System.out.println("Output file path: ");
                    pathOut = scanner.next();
                    try {
                        converterCsv.begin(pathIn, pathOut);
                    } catch (Exception e) {
                        System.out.println("No such file or directory");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Wrong number!");
                    break;
            }
        } while (i != 0);

    }

}
