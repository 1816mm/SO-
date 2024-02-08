package lab1;

public class BaseService {
    private double value;
    private String convertTo;
    private String convertFrom;
    private double USDEURRate = 0.85;
    private double USDJPYRate = 109.34;
    private double EURJPYRate = 157.9;
    private double EURUSDRate = 1.18;
    private double JPYUSDRate = 0.009;
    private double JPYEURRate = 0.006;


    public BaseService(double _value, String _convertTo, String _convertFrom) {
        value = _value;
        convertTo = _convertTo;
        convertFrom = _convertFrom;
    }

    private double getRate() {
        String rateCase = convertFrom + convertTo;
        switch (rateCase) {
            case "USDEUR":
                return USDEURRate;
            case "USDJPY":
                return USDJPYRate;
            case "EURJPY":
                return EURJPYRate;
            case "EURUSD":
                return EURUSDRate;
            case "JPYUSD":
                return JPYUSDRate;
            case "JPYEUR":
                return JPYEURRate;
            default:
                return 1;
        }
    }

    public double getOutput() {
        return value * getRate();
    }
}
