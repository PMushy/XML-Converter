package com.pl.mushy.logic;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class ConverterXml {
    private StreamResult out;
    private TransformerHandler th;

    public void begin(String path) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            out = new StreamResult("data.xml");
            openXml();
            String str;
            List<String> elements;

            while ((str = in.readLine()) != null) {
                th.startElement(null, null, "sentence", null);
                String s = str.replaceAll("^\\s+", "");
                elements = Arrays.asList(s.split("[^\\w]+"));
                elements.sort(String::compareToIgnoreCase);
                for (String x : elements
                ) {
                    processWord(x);
                }

                th.endElement(null, null, "sentence");
            }
            in.close();
            closeXml();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openXml() throws ParserConfigurationException, TransformerConfigurationException, SAXException {
        SAXTransformerFactory tf = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
        th = tf.newTransformerHandler();

        Transformer serializer = th.getTransformer();
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
        serializer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        th.setResult(out);
        th.startDocument();
        th.startElement(null, null, "text", null);
    }

    private void processWord(String s) throws SAXException {
        th.startElement(null, null, "word", null);
        th.characters(s.toCharArray(), 0, s.length());
        th.endElement(null, null, "word");
    }

    private void closeXml() throws SAXException {
        th.endElement(null, null, "text");
        th.endDocument();
    }
}
