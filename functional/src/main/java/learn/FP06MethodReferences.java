package learn;

import java.util.List;
import java.util.function.Supplier;

class Course {
    private String name;

    public Course() {
        this.name = "Default Course";
    }

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Course: " + name;
    }
}

public class FP06MethodReferences {
    public static void main(String[] args) {
        List<String> courseNames = List.of(
            "Spring Framework", "Spring Boot", "Spring Security", 
            "REST API", "Microservices", "AWS", 
            "Azure", "GCP", "Docker", 
            "Kubernetes", "EDA"
        );

        // Using method reference to transform course names to uppercase
        courseNames.stream()
            // .map(str->str.toLowerCase())
            .map(String::toUpperCase)
            .forEach(System.out::println);

        // Using constructor reference to create Course instances
        Supplier<Course> defaultCourseSupplier = Course::new;
        Supplier<Course> customCourseSupplier = () -> new Course("Custom Course");

        // Creating instances and printing them
        System.out.println(defaultCourseSupplier.get());
        System.out.println(customCourseSupplier.get());
    }
}
