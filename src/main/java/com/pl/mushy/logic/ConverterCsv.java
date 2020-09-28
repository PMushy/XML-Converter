package com.pl.mushy.logic;

import java.io.*;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConverterCsv {
    private int i = 1;


    public void begin(String path) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("data.csv"));
        StringJoiner stringJoiner1 = new StringJoiner(",", "", "");

        try (Stream<String> lines = new BufferedReader(new FileReader(path)).lines()) {
            stringJoiner1.add(lines
                    .map(s -> s.replaceAll("^\\s+", ""))
                    .map(s -> s.split("[^\\w]+"))
                    .map(s -> "Sentence " + i++ + ", " + String.join(", ", s) + "\n")
                    .collect(Collectors.joining()));

        } catch (IOException e) {
            e.printStackTrace();
        }

        String commas = stringJoiner1.toString();
        commas = commas.replaceAll("[^,\n]", "");
        String[] tab = commas.split("\n");
        int words = 0;
        for (String x : tab
        ) {
            if (x.length() > words) words = x.length();
        }

        StringJoiner stringJoiner2 = new StringJoiner("", "", "");
        stringJoiner2.add(",");
        for (int j = 1; j < words + 1; j++) {
            stringJoiner2.add(" " + "Word " + j + ",");
        }
        stringJoiner2.add("\n");

        stringJoiner2.merge(stringJoiner1);
        String result = stringJoiner2.toString();

        bw.append(result);
        bw.close();

    }
}
