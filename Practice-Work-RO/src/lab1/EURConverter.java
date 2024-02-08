package lab1;

import lab1.BaseService;

public class EURConverter extends BaseService {
    private String baseCurrency = "EUR";
    private double value = 0 ;

    public EURConverter(double _value, String _convertTo){
        super(_value, _convertTo, "EUR");
        value = _value;
    }

    public double convert(){
        return this.getOutput();
    }
}
