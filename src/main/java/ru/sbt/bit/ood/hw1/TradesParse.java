package ru.sbt.bit.ood.hw1;

import java.io.*;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVFormat;

public class TradesParse{
    public static Iterable<CSVRecord> parse(String filename) {
        try {
            Reader in = new FileReader(filename);
            Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
            return records;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("There was an error while parsing CSV file");
        }
    }
}