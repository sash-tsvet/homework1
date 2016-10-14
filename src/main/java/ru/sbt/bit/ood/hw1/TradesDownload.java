package ru.sbt.bit.ood.hw1;

import java.io.*;
import org.apache.commons.net.ftp.FTPClient;

public class TradesDownload {
    public static String downloadTradesFileFromFTP() {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect("localhost", 8090);
            ftpClient.login("foo", "password");
            File tempFile = File.createTempFile("trades", "download");
            OutputStream out = new FileOutputStream(tempFile);
            ftpClient.retrieveFile("public/prod/trades.csv", out);
            out.close();
            return tempFile.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not download the file");
        }
    }
}