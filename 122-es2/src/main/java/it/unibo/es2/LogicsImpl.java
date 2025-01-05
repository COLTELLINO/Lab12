package it.unibo.es2;

import java.util.ArrayList;
import java.util.List;

public class LogicsImpl implements Logics {

    private String[][] symbols; 
    private final int size;

    public LogicsImpl(int size) {
        this.symbols = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                symbols[i][j] = " ";
            }
        }
        this.size = size;
    }

    @Override
    public String hit(Pair<Integer,Integer> elem) {
        String symbol = this.symbols[elem.getX()][elem.getY()];
        if (symbol == " ") {
            this.symbols[elem.getX()][elem.getY()] = "*";
        } else {
            this.symbols[elem.getX()][elem.getY()] = " ";   
        }
        return this.symbols[elem.getX()][elem.getY()];
    }

    @Override
    public boolean toQuit() {
        List<String> l = new ArrayList<>();
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                l.add(symbols[i][j]);
            }
        }
        return (l.stream().distinct().count() == 1) && l.get(0) == "*";
    }
}