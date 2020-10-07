package com.pl.mushy.logic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestConverterXml {
    BufferedReader output, expected;
    ConverterXml converterXml;
    String pathIn, pathOut, in;

    @Before
    public void setUp() throws FileNotFoundException {
        output = new BufferedReader(new FileReader("testingData/data.xml"));
        expected = new BufferedReader(new FileReader("testingData/testData.xml"));
        converterXml = new ConverterXml();
        pathIn = "testingData/data.txt";
    }

    @Test
    public void shouldReturnTrue() throws IOException {
        converterXml.begin(pathIn, pathOut);

        while ((in = expected.readLine()) != null && (in = output.readLine()) != null) {
            Assert.assertEquals(expected.readLine(), output.readLine());
        }
    }
}
