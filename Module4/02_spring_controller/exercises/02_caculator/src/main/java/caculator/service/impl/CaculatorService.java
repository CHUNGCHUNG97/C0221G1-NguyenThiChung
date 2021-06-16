package caculator.service.impl;

import caculator.service.ICaculatorService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CaculatorService implements ICaculatorService {
    @Override
    public String caculator(Map<String, String> caculator, String cal) {
        String result = "";
        try {
            int number1 = Integer.parseInt(caculator.get("number1"));
            int number2 = Integer.parseInt(caculator.get("number2"));
            cal = caculator.get("caculator");
            switch (cal) {
                case "addition": {
                    result = Integer.toString(number1 + number2);
                    break;
                }
                case "subtraction": {
                    result = Integer.toString(number1 - number2);
                    break;
                }
                case "multiplication": {
                    result = Integer.toString(number1 * number2);
                    break;
                }
                case "division": {
                    if (number2 != 0) {
                        result = Integer.toString(number1 / number2);
                    }else {
                        result="the denominator must be other than 0";
                    }
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
