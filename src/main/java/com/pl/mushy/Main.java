package com.pl.mushy;

import com.pl.mushy.logic.ConverterCsv;
import com.pl.mushy.logic.ConverterXml;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ConverterXml converterXml = new ConverterXml();
        ConverterCsv converterCsv = new ConverterCsv();
        String path = "data.txt";

//        converterXml.begin(path);
        converterCsv.begin(path);
    }
}
