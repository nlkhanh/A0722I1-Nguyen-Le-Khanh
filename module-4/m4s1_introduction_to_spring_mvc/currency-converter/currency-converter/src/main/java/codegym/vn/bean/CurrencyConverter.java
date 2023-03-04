package codegym.vn.bean;

public class CurrencyConverter {
    private double usd;
    private double rate;
    private double result;

    public CurrencyConverter() {
    }

    public CurrencyConverter(double usd, double rate, double result) {
        this.usd = usd;
        this.rate = rate;
        this.result = result;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getUsd() {
        return usd;
    }

    public void setUsd(double usd) {
        this.usd = usd;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
