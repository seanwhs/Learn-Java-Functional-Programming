package learn;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class FP08Streams {
    public static void main(String[] args) {
            System.out.println(
                "\nCreating Integer (Wrapper Integer Class) streams using Stream API:: " +
                "\nNotice that ReferencePipeline object is created::" +
                "\n-----------------------------------------------------------------\n" +
                Stream.of(10, 1,101,2,99,3,3,88,4,681,4,33,5,77,5,6,6,6,7,44,7,8,8,9,9,22) +
                "\nCount number of elements in the stream of integers:: \n" +
                Stream.of(10, 1,101,2,99,3,3,88,4,681,4,33,5,77,5,6,6,6,7,44,7,8,8,9,9,22).count() +
                "\nAll up all elements in the stream of integers:: \n" +
                Stream.of(10, 1,101,2,99,3,3,88,4,681,4,33,5,77,5,6,6,6,7,44,7,8,8,9,9,22) 
                .reduce(0, Integer::sum) +
                "\nCreating primitive int streams:: " +
                "\nNotice that IntPipeline object is created::" +
                "\n------------------------------------------------------------------\n" +
                Arrays.stream(new int[] {201,1,45,2,3,4,33,4,55,6,7,8,9}) +
                "\nOperations possible on primitive int streams:: " +
                "\nsum():: \n" +
                Arrays.stream(new int[] {201,1,45,2,3,4,33,4,55,6,7,8,9}).sum() +
                "\nmax():: \n" +
                Arrays.stream(new int[] {201,1,45,2,3,4,33,4,55,6,7,8,9}).max() +
                "\nmin():: \n" +
                Arrays.stream(new int[] {201,1,45,2,3,4,33,4,55,6,7,8,9}).min() +
                "\navg():: \n" +
                Arrays.stream(new int[] {201,1,45,2,3,4,33,4,55,6,7,8,9}).average()+
                "\nCreating primitive integer streams using IntStream API:: " +
                "\nNotice that IntPipeline object is created::" +
                "\n------------------------------------------------------------------\n" +
                IntStream.range(1,101) + //101 NOT included
                "\nsum() on IntStream.range():: \n" +
                IntStream.range(1,101).sum() + //gives total. excludes 11
                "\nIntStream.rangeClosed():: \n" +
                IntStream.rangeClosed(1,100) + //100 INCLUDED
                "\nsum() on IntStream.rangeClosed():: \n" +
                IntStream.rangeClosed(1,100).sum() + //gives total. excludes 11
                "\navg():: \n" +
                IntStream.range(1,101).average() + //average 11
                "\nmax():: \n" +
                IntStream.range(1,101).max() + 
                "\nmin():: \n" +
                IntStream.range(1,101).min() 
                ); 

            System.out.println("---IntStream.iterate(1, e->e+2).limit(10).forEach(System.out::println)::");    
            IntStream.iterate(1, e->e+2).limit(10).forEach(System.out::println);                
            System.out.println("Print 2 to 20::");    
            IntStream.iterate(2, e -> e + 2).limit(10).filter(e -> e % 2 == 0).forEach(System.out::println);
            int sum = IntStream.iterate(2, e -> e + 2).limit(10).filter(e -> e % 2 == 0).sum();
            System.out.println("Add even numbers from  2 to 20:: " + sum);    
            int sumOfSquares = IntStream.iterate(2, e -> e * 2).limit(10).filter(e -> e % 2 == 0).sum();
            System.out.println("Add squares of even numbers from  2 to 20:: " + sumOfSquares);    
            List<Integer> generatedListOfIntegers 
                = IntStream.iterate(1, e -> e + 2).limit(10).boxed().collect(Collectors.toList());
            System.out.println("Boxed int primitive into List of Integers" + generatedListOfIntegers);      
    
            long longTotal = LongStream.rangeClosed(1, 10)
                .reduce(0, (x,y)->x+y);
            
            double doubleTotal = IntStream.rangeClosed(1, 10)
                .reduce(0, (x, y) -> x + y);
        
            System.out.printf("\nSum of 1 to 10 for long is %d and double is %f", longTotal, doubleTotal);

            }
}
