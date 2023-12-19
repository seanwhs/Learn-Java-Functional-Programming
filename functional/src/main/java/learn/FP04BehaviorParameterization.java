package learn;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP04BehaviorParameterization {
    public static void main(String[] args) {
        List<Integer> numbers 
            = List.of(2, 2, 2, 8, 2, 3, 6, 6, 6, 6, 8, 1, 1, 1, 9, 4, 4, 4, 4, 5, 7, 8);

        System.out.println("\n Print Sorted Even Numbers by passinging in 'method' as argument");    
        filterAndPrint(numbers, n->n%2==0);
        System.out.println("\n Print Sorted Odd Numbers by passinging in 'method' as argument");    
        filterAndPrint(numbers, n->n%2!=0);
        System.out.println("\n Print Numbers divisible by 3 by passinging in 'method' as argument");    
        filterAndPrint(numbers, n->n%3==0);
        
        System.out.println("\n LIST - Power of 2");
        List <Integer> power2 = power(numbers, n->n*n);
        System.out.println("Powered List" + power2);
        System.out.println("\n LIST - Power of 3");
        List <Integer> power3 = power(numbers, n->n*n*n);
        System.out.println("Powered List" + power3);
    }

    private static List<Integer> power(
        List<Integer> numbers, 
        Function<Integer, Integer> mapper) {
        return numbers.stream().distinct().map(mapper).collect(Collectors.toList());
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers.stream().distinct().sorted().filter(predicate).forEach(System.out::println);
    }
}
