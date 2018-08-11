package de.werling.ci;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComplexController {
    @RequestMapping("/api/calculate")
    public int calculate(@RequestParam(value = "left") int left,
                            @RequestParam(value = "right") int right,
                            @RequestParam(value = "op") char op)
    {
        switch (op){
            case '+':
                return left + right;
            case '-':
                return left - right;
            case '*':
                return left * right;
            case '/':
                return left / right;
            default: return Integer.MAX_VALUE;
        }
    }
}
