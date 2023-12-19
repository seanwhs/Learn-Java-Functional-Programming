package learn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FP02StreamOperations {
    private static int structuredSum(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static int structuredSumCubeOdd(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            if (number % 2 != 0) {
                number = number * number * number;
                sum += number;
            }
        }
        return sum;
    }

    private static void structuredSortedDistinct(List<Integer> numbers) {
        System.out.println("Print distinct numbers from a List using structured programming ");
        Set<Integer> distinctNumbers = new HashSet<>(numbers); // Use a Set to store distinct numbers
        List<Integer> distinctList = new ArrayList<>(distinctNumbers); // Convert the set to a list for sorting
        Collections.sort(distinctList); // Sort the list
        for (Integer number : distinctList) {  // Print the sorted distinct numbers
            System.out.println(number);
        }
    }

    private static int functionalSum(List<Integer> numbers) {
        return numbers.stream().reduce(0, (a, b) -> a + b);
    }

    private static int functionalSumCubeOdd(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 != 0).map(n -> n * n * n).reduce(0, (a, b) -> a + b);
    }

    private static void functionalSortedDistinct(List<Integer> numbers) {
        System.out.println("Print distinct numbers from a List using functional programming ");
        numbers.stream().distinct().sorted().forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 2, 2, 8, 2, 3, 6, 6, 6, 6, 8, 1, 1, 1, 9, 4, 4, 4, 4, 5, 7, 8);

        System.out.println("Sum using Structured Programming: " + structuredSum(numbers));
        System.out.println("Sum using Functional Programming: " + functionalSum(numbers));

        System.out.println("Add cube of odd numbers using Structured Programming: " + structuredSumCubeOdd(numbers));
        System.out.println("Add cube of odd numbers using Functional Programming: " + functionalSumCubeOdd(numbers));

        structuredSortedDistinct(numbers);
        functionalSortedDistinct(numbers);
    }
}
