package com.pl.mushy;

import com.pl.mushy.program.ConverterXml;

public class Main {
    public static void main(String[] args) {
        ConverterXml converterXml = new ConverterXml();
        String path = "data.txt";

        converterXml.begin(path);
    }
}
