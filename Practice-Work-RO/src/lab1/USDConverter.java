package lab1;

import lab1.BaseService;

public class USDConverter extends BaseService {
    private String baseCurrency = "USD";
    private double value = 0 ;

    public USDConverter(double _value, String _convertTo){
        super(_value, _convertTo, "USD");
        value = _value;
    }

    public double convert(){
        return this.getOutput();
    }
}
