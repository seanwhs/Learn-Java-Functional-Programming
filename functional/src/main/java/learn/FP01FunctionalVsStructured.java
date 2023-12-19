package learn;
import java.util.List;

public class FP01FunctionalVsStructured {

    private static void structured_odd(List<Integer> numbers){
        System.out.println("\nPrint odd integers using Structured Programming");
        for (int element:numbers){
            if (element%2!=0){
                System.out.println(element);
            }
        }
    }     
    
    private static void structuredCubesOdd(List<Integer> numbers){
        System.out.println("\nPrint cube of odd integers using Structured Programming");
        for (int number:numbers){
            if (number%2!=0){
                number = number * number * number;
                System.out.println(number);
            }
        }
    }
    
    private static void structuredPrintSpring(List<String> courses){
        System.out.println("\nPrint Spring courses using Structured Programming");
        for (String course:courses){
            if (course.contains("Spring")){
                System.out.println(course);
            }
        }
    }
    
    private static void structuredPrintCourseMoreThan4Chars(List<String> courses){
        System.out.println("\nPrint courses with more than 4 characters using Structured Programming");
        for (String course: courses){
            if (course.length()>4){
                System.out.println(course);
            }
        }
    }
    
    private static void functional_odd(List<Integer> numbers){
        System.out.println("\nPrint odd integers using Functional Programming");
        numbers.stream().filter(e->e%2!=0).forEach(System.out::println);
    }
    
    private static void functionalCubesOdd(List<Integer> numbers){
        System.out.println("\nPrint cube of odd integers using Functional Programming");
        numbers.stream().filter(number->number%2!=0).map(number->number*number*number).forEach(System.out::println);
    }
    
    private static void functionalPrintSpring(List<String> courses){
        System.out.println("\nPrint Spring courses using Functional Programming");
        courses.stream().filter(course->course.contains("Spring")).forEach(System.out::println);
    }
    
    private static void functionalPrintCourseMoreThan4Chars(List<String> courses){
        System.out.println("\nPrint courses with more than 4 characters using Functional Programming");
        courses.stream().filter(course->course.length()>4).forEach(System.out::println);   
    }
    
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9);
        List<String> courses = List.of("Spring Framework", "Spring Boot", "Java SE1", "Java SE2");

        structured_odd(numbers);
        functional_odd(numbers);

        structuredCubesOdd(numbers);
        functionalCubesOdd(numbers);

        structuredPrintSpring(courses);
        functionalPrintSpring(courses);

        structuredPrintCourseMoreThan4Chars(courses);
        functionalPrintCourseMoreThan4Chars(courses);
    }
}
