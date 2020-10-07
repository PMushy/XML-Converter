package com.pl.mushy.logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LineOfFile {

    private BufferedReader br;

    public LineOfFile(String pathIn) throws FileNotFoundException {
        br = new BufferedReader(new FileReader(pathIn));
    }

    public BufferedReader getBr() {
        return br;
    }

    public String getSentence() throws IOException {
        return this.br.readLine();
    }
}
