package learn;

import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FP05OtherFunctionInterfaces {
    public static void main(String[] args) {
        //Supplier Function Interface
        Supplier<Integer> randomIntGenerator = ()->{
            Random random = new Random();
            return random.nextInt(1000);
        };

        //UnaryOperatorFunction Interface
        UnaryOperator <Double> gst = (amount)->0.17*amount;


        // BiPredicate to check if the length of a string is equal to a specified integer
        BiPredicate<Integer, String> isStringLengthEqual = (number, str) ->{
            return number <10 && str.length()>5;
        }; 
        
        //BiFunction
        BiFunction<Integer, String, String> printIntStr = (number, str) ->{
            return number + ":" + str;
        }; 
        
        //BiConsumer
        BiConsumer<Integer, String> print2=(intr, str)->{
            System.out.println(intr);
            System.out.println(str);
        };

        System.out.println("\nRandom Number Less Than 1000:: " + randomIntGenerator.get());
        double amt = 65.75;
        System.out.printf("\nGST for $%f is $%f\n", amt, gst.apply(amt));
        int num = 5;
        String str = "I Love Java"; 
        System.out.printf("\n Is (%d) less than 10 & (%s) shorter than 5 characters? (%b)\n ", num, str, 
            isStringLengthEqual.test(num, str));
        System.out.println(printIntStr.apply(num, str));
        print2.accept(num, str);

    }
}
