package ru.sbt.bit.ood.hw1;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;

public class TradesParse implements Parser {
    public Collection<Trade> parse(String filename) {
        try {
            Reader in = new FileReader(filename);
            Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
            Collection<Trade> trades = new ArrayList<Trade>();
            for (CSVRecord tradeRecord : records) {
                Trade trade = new Trade(tradeRecord.toMap());
                trades.add(trade);
            }
            return trades;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("There was an error while parsing CSV file");
        }
    }
}