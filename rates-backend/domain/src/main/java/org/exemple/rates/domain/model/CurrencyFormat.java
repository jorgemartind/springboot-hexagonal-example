package org.exemple.rates.domain.model;

public class CurrencyFormat {
    private String symbol;
    private String code;
    private Integer decimals;

    public CurrencyFormat(String symbol, String code, Integer decimals) {
        this.symbol = symbol;
        this.code = code;
        this.decimals = decimals;
    }

    public CurrencyFormat() {
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getDecimals() {
        return decimals;
    }

    public void setDecimals(Integer decimals) {
        this.decimals = decimals;
    }

    @Override
    public String toString() {
        return "CurrencyFormat{" +
                "symbol='" + symbol + '\'' +
                ", code='" + code + '\'' +
                ", decimals=" + decimals +
                '}';
    }
}