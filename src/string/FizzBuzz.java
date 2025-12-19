package string;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            boolean isDivisibleBy3 = i % 3 == 0;
            boolean isDivisibleBy5 = i % 5 == 0;

            String value = "";

            if (isDivisibleBy3)
                value += "Fizz";

            if (isDivisibleBy5)
                value += "Buzz";

            if (value.isEmpty())
                value += i;
            
            ans.add(value);
        }

        return ans;
    }
}
