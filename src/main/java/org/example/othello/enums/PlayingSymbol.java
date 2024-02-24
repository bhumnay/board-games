package org.example.othello.enums;

public enum PlayingSymbol {
    WHITE("W"),
    BLACK("B");

    private final String symbol;

    PlayingSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
