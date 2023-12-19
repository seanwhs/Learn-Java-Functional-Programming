// This class demonstrates  the use of functional interfaces in Java's functional programming paradigm
package learn;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03FunctionalInterfaces {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 2, 2, 8, 2, 3, 6, 6, 6, 6, 8, 1, 1, 1, 9, 4, 4, 4, 4, 5, 7, 8);

        // numbers
        // .stream()
        // .distinct()
        // .filter(n->n%2==0)
        // .map(n->n*n*n)
        // .forEach(System.out::println);

        // Instances of the Predicate functional interface are created
        // to check if a given integer is even.
        Predicate<Integer> isEvenPredicate = n -> n % 2 == 0; // instance of Predicate funtional interface crreated
        Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() { // behind the scene of a lambda expression
            @Override
            public boolean test(Integer t) {
                return t % 2 == 0;
            }
        };

        // Instances of the Function functional interface are created to cube an
        // integer.
        Function<Integer, Integer> cubeFunction = n -> n * n * n; // instance of Function funtional interface created
        Function<Integer, Integer> cubeFunction2 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer t) {
                return t * t * t;
            }
        };

        // Instances of the Consumer functional interface are created
        // to print an integer to the console.
        Consumer<Integer> sysoutConsumer = System.out::println; // instance of consumer funtional interfacecreated
        Consumer<Integer> sysoutConsumer2 = new Consumer<Integer>() {
            @Override
            public void accept(Integer t) {
                System.out.println(t);
            }
        };

        System.out.println("\n----------Use Lambdas----------");
        numbers
                .stream()
                .distinct()
                .filter(isEvenPredicate) // behind every lambda expression is a Functional interface
                .map(cubeFunction)
                .forEach(sysoutConsumer);

        System.out.println("\n----------Use Functional Intrerfaces----------");
        numbers
                .stream()
                .distinct()
                .filter(isEvenPredicate2) // behind every lambda expression is a Functional interface
                .map(cubeFunction2)
                .forEach(sysoutConsumer2);

                // creates a BinaryOperator<Integer> named accumulator. 
                // The lambda expression (a, b) -> a + b defines 
                // a binary operation that adds two integers (a and b) and produces a result of type Integer.        
        BinaryOperator<Integer> accumulator = (a, b) -> a + b;
        BinaryOperator<Integer> accumulator2 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer t, Integer u) {
                return t + u;
            }
        };

        System.out.println("\n-------Add List 0f Numbers Using Lambda------------");
        int sumLambda = numbers
                .stream()
                .reduce(0, accumulator);
        System.out.println("Sum :: " + sumLambda);

        System.out.println("\n-------Add List of NUmbers Using Functional Interface------------");
        int sumFunctionInterface = numbers
                .parallelStream()
                // .stream()
                .reduce(0, accumulator2);
        System.out.println("Sum :: " + sumFunctionInterface);
    }
}
