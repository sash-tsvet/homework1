package ru.sbt.bit.ood.hw1;


import java.util.Collection;


public class TradesJob {

    private final TradesDAO tradesDAO;
    private final Parser parser;
    private final Downloader downloader;

    public TradesJob(TradesDAO tradesDAO, Parser parser, Downloader downloader) {
        this.tradesDAO = tradesDAO;
        this.parser = parser;
        this.downloader = downloader;
    }


    public void run() {
        String filename = downloader.download();
        Collection<Trade> tradeRecords = parser.parse(filename);
        updateTrades(tradeRecords);
    }

    private void updateTrades(Collection<Trade> trades) {
        tradesDAO.deleteAll();
        for (Trade trade : trades) {
            tradesDAO.save(trade);
        }
    }
}
