package vn.techzen.academy_12.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    @GetMapping("/calculator")
    public ResponseEntity<String> calculator(
            @RequestParam(value = "num1", defaultValue = "") String number1,
            @RequestParam(value = "num2", defaultValue = "") String number2,
            @RequestParam(value = "operator", defaultValue = "") String operator) {

        if (number1.isEmpty()) {
            return ResponseEntity.badRequest().body("Please enter number1");
        } else if (number2.isEmpty()) {
            return ResponseEntity.badRequest().body("Please enter number2");
        }

        double num1;
        double num2;

        try {
            num1 = Double.parseDouble(number1);
            num2 = Double.parseDouble(number2);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Please enter valid numbers");
        }

        double result = 0.0;

        switch (operator) {
            case "Cộng":
                result = num1 + num2;
                break;
            case "Trừ":
                result = num1 - num2;
                break;
            case "Nhân":
                result = num1 * num2;
                break;
            case "Chia":
                if (num2 == 0) {
                    return ResponseEntity.badRequest().body("Cannot divide by zero");
                } else {
                    result = num1 / num2;
                }
                break;
            default:
                return ResponseEntity.badRequest().body("Invalid operator. Please use Cộng, Trừ, Nhân, or Chia.");
        }

        return ResponseEntity.ok(String.valueOf(result));
    }
}