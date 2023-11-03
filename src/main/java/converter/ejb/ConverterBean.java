package converter.ejb;

import java.text.DecimalFormat;
import jakarta.ejb.Stateless;
import jakarta.ejb.LocalBean;

@Stateless
@LocalBean
public class ConverterBean implements ConverterBeanLocal {
    
    private final DecimalFormat twoDigits = new DecimalFormat("0.00");
    
    public String ctor(double c) {
        String result = twoDigits.format(c * 4/5);
        return result;
    }
    
    public String rtoc(double r) {
        String result = twoDigits.format(r * 5/4);
        return result;
    }
}
