package ru.sbt.bit.ood.hw1;


import org.apache.commons.csv.CSVRecord;


public class TradesJob {

    private final TradesDAO tradesDAO;

    public TradesJob(TradesDAO tradesDAO) {
        this.tradesDAO = tradesDAO;
    }

    public void run() {
        String filename = TradesDownload.downloadTradesFileFromFTP();
        Iterable<CSVRecord> tradeRecords = TradesParse.parse(filename);
        updateTrades(tradeRecords);
    }

    private void updateTrades(Iterable<CSVRecord> trades) {
        tradesDAO.deleteAll();
        for (CSVRecord tradeRecord : trades) {
            Trade trade = new Trade(tradeRecord.toMap());
            tradesDAO.save(trade);
        }
    }
}
