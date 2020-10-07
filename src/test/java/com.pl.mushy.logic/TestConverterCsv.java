package com.pl.mushy.logic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestConverterCsv {
    BufferedReader output, expected;
    ConverterCsv converterCsv;
    String pathIn, pathOut, in;

    @Before
    public void setUp() throws FileNotFoundException {
        output = new BufferedReader(new FileReader("testingData/data.csv"));
        expected = new BufferedReader(new FileReader("testingData/testData.csv"));
        converterCsv = new ConverterCsv();
        pathIn = "testingData/data.txt";
        pathOut = "testingData/data.csv";
    }

    @Test
    public void shouldReturnTrue() throws IOException {
        converterCsv.begin(pathIn, pathOut);

        while ((in = expected.readLine()) != null && (in = output.readLine()) != null) {
            Assert.assertEquals(expected.readLine(), output.readLine());
        }
    }
}
