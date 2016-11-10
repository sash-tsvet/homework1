package ru.sbt.bit.ood.hw1;


import java.util.Collection;

/**
 * Created by kitty on 10.11.2016.
 */
public interface Parser {
    Collection<Trade> parse(String filename);
}
