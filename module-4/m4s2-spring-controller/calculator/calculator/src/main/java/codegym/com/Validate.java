package codegym.com;

import org.springframework.stereotype.Component;
@Component
public class Validate {

    public Validate() {
    }

    public boolean isNumberRight(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
