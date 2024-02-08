package lab1;

import lab1.BaseService;

public class JPYConverter extends BaseService {
    private String baseCurrency = "JPY";
    private double value = 0 ;

    public JPYConverter(double _value, String _convertTo){
        super(_value, _convertTo, "JPY");
        value = _value;
    }

    public double convert(){
        return this.getOutput();
    }
}
