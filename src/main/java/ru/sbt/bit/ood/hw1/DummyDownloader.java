package ru.sbt.bit.ood.hw1;

/**
 * Created by kitty on 10.11.2016.
 */
public class DummyDownloader implements Downloader {
    public String download() {
        System.out.println("downloading");
        return null;
    }
}
