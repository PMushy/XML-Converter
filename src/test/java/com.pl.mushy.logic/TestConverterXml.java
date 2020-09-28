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
    String path;
    String in;

    @Before
    public void setUp() throws FileNotFoundException {
        output = new BufferedReader(new FileReader("data.xml"));
        expected = new BufferedReader(new FileReader("testData.xml"));
        converterXml = new ConverterXml();
        path = "data.txt";
    }

    @Test
    public void shouldReturnTrue() throws IOException {
        converterXml.begin(path);

        while ((in = expected.readLine()) != null && (in = output.readLine()) != null) {
            Assert.assertEquals(expected.readLine(), output.readLine());
        }
    }
}
