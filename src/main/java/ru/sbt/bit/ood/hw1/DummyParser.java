package ru.sbt.bit.ood.hw1;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by kitty on 10.11.2016.
 */
public class DummyParser implements Parser {
    public Collection<Trade> parse(String filename) {
        System.out.println("Parsing going on");
        return new ArrayList<Trade>();
    }
}
