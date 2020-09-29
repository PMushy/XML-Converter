package com.pl.mushy.logic;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConverterCsv {
    private int i = 1;

    public void begin(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        BufferedWriter bw = new BufferedWriter(new FileWriter("testingData/data.csv"));
        StringJoiner stringJoiner1 = new StringJoiner(",", "", "");

        List<String> elements, list = new ArrayList<>();
        String str;

        while ((str = br.readLine()) != null) {
            String s = str.replaceAll("^\\s+", "");
            elements = Arrays.asList(s.split("[^\\w]+"));
            elements.sort(String::compareToIgnoreCase);

            list.add(elements.toString().replace("[", "").replace("]", ""));
        }

        try (Stream<String> lines = list.stream()) {
            stringJoiner1.add(lines
                    .map(s -> s.split("\\z"))
                    .map(s -> "Sentence " + i++ + ", " + String.join(", ", s) + "\n")
                    .collect(Collectors.joining()));

            String[] commas = stringJoiner1
                    .toString()
                    .replaceAll("[^,\n]", "")
                    .split("\n");
            int words = 0;
            for (String x : commas
            ) {
                if (x.length() > words) words = x.length();
            }

            StringJoiner stringJoiner2 = new StringJoiner("", "", "");
            for (int j = 1; j < words + 1; j++) {
                stringJoiner2.add(", " + "Word " + j);
            }
            stringJoiner2.add("\n");

            stringJoiner2.merge(stringJoiner1);
            String result = stringJoiner2.toString();

            bw.append(result);
            bw.close();
        }
    }
}
