package com.pl.mushy.logic;

import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConverterCsv {
    private int i = 1;

    public void begin(String path) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("data.csv"));
        try (Stream<String> lines = new BufferedReader(new FileReader(path)).lines()) {
            String result = lines
                    .map(s -> s.replaceAll("^\\s+", ""))
                    .map(s -> s.split("[^\\w]+"))
                    .map(s -> "Sentence " + i++ + ", " + String.join(", ", s) + "\n")
                    .collect(Collectors.joining());
            bw.append(result);
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}