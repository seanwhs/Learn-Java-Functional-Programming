// FP07CustomClass.java
package learn;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class ITCourse {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;
    
    public ITCourse(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public int getReviewScore() {
        return reviewScore;
    }
    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }
    public int getNoOfStudents() {
        return noOfStudents;
    }
    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    @Override
    public String toString() {
        return "Program [name=" + name + ", category=" + category + ", reviewScore=" + reviewScore + ", noOfStudents="
                + noOfStudents + "]";
    }    
    
}

public class FP07QueryingData {
    public static void main(String[] args) {
        List <ITCourse> courses = List.of(
            new ITCourse("Spring", "Framework",98 , 15),
            new ITCourse("REACT", "Framework",88 , 8),
            new ITCourse("Angular", "Framework",78 , 5),
            new ITCourse("Java SE I", "Language",65 , 28),
            new ITCourse("Java SE II", "Language",48 , 9),
            new ITCourse("TypeScript", "Language",88 , 25),
            new ITCourse("JavaScript", "Language",78 , 28),
            new ITCourse("Python", "Language",55 , 68),
            new ITCourse("Microservices", "Architecture",98 , 38),
            new ITCourse("REST API", "Architecture",98 , 18),
            new ITCourse("Event Driven Architecture", "Architecture",88 , 38),
            new ITCourse("AWS", "Cloud", 25 , 38),
            new ITCourse("Azure", "Cloud",91 , 36),
            new ITCourse("GCP", "Cloud",92 , 28)
        );

        Predicate<ITCourse> distinction = course->course.getReviewScore()>90;
        Predicate<ITCourse> highScore = course->course.getReviewScore()>80;
        Predicate<ITCourse> nonExistent = course->course.getReviewScore()<8;

        System.out.println(
            "\n-------------------------------------------" +
            "\nAll Courses have review scores of distinction? " +
            courses.stream().allMatch(distinction) +
            "\nNO Course have review scores of distinction? " +
            courses.stream().noneMatch(distinction) +
            "\nAny Course have review scores of distinction ? " +
            courses.stream().anyMatch(distinction) +
            "\n-------------------------------------------" +
            "\n\nAll Courses have review scores of High Score ? " +
            courses.stream().allMatch(highScore) +
            "\nNO Course have review scores of High Score ? " +
            courses.stream().noneMatch(highScore) +
            "\nAny Course have review scores of High Score ? " +
            courses.stream().anyMatch(highScore)
            );
            
            Comparator <ITCourse> comparingByNumberOfStudentsIncreasing 
                = Comparator.comparingInt(ITCourse::getNoOfStudents);
            Comparator <ITCourse> comparingByNumberOfStudentsDecreasing 
                = Comparator.comparingInt(ITCourse::getNoOfStudents).reversed();
            Comparator <ITCourse> comparingByNumberOfStudentsAndReviewScore 
                = Comparator.comparingInt(ITCourse::getNoOfStudents).thenComparing(ITCourse::getReviewScore);
                       
            System.out.println(
                "\n-------------------------------------------" +
                "\nComparing Courses by Number Of Studemts(Increasing):: \n" 
            );
            
            courses.stream()
                .sorted(comparingByNumberOfStudentsIncreasing)
                .collect(Collectors.toList())
                .forEach(System.out::println);
            
            System.out.println(
                "\n-------------------------------------------" +
                "\nWHILE Review Score >50:: Compare Courses by Number Of Studemts(Increasing):: " + 
                "\nSTOP PROVCESSING WHEN REVIEW SCORE !>50 is reached\n" 
            );
            
            courses.stream()
                .sorted(comparingByNumberOfStudentsIncreasing)
                .takeWhile(course->course.getReviewScore()>50)
                .collect(Collectors.toList())
                .forEach(System.out::println);
            
                System.out.println(
                "\n-------------------------------------------" +
                "\nDROP ALL Until Review Score >50:: Compare Courses by Number Of Studemts(Increasing):: " + 
                "\nSTOP PROVCESSING UNTILL REVIEW SCORE !>50 is reached\n" 
            );
            
            courses.stream()
                .sorted(comparingByNumberOfStudentsIncreasing)
                .dropWhile(course->course.getReviewScore()>50)
                .collect(Collectors.toList())
                .forEach(System.out::println);
            
            System.out.println(
                "\n-------------------------------------------" +
                "\nComparing FIRST FIVE Courses by Number Of Studemts(Increasing):: \n" 
            );
            
            courses.stream()
                .sorted(comparingByNumberOfStudentsIncreasing)
                .limit(5)
                .collect(Collectors.toList())
                .forEach(System.out::println);
            
                System.out.println(
                "\n-------------------------------------------" +
                "\nSKIP FIRST 3 & Compare FIRST 5 Courses by Number Of Studemts(Increasing):: \n" 
            );
            
            courses.stream()
                .sorted(comparingByNumberOfStudentsIncreasing)
                .skip(3)
                .limit(5)
                .collect(Collectors.toList())
                .forEach(System.out::println);
            
            System.out.println(
                "\n-------------------------------------------" +
                "\nComparing Courses by Number Of Studemts(Decreasing):: \n" 
            );
            
            courses.stream()
                .sorted(comparingByNumberOfStudentsDecreasing)
                .collect(Collectors.toList())
                .forEach(System.out::println);
            
            System.out.println(
                "\n-------------------------------------------" +
                "\nComparing Courses by Number Of Studemts(Increasing) and Review Score (Increasing):: \n" 
            );
            
            courses.stream()
                .sorted(comparingByNumberOfStudentsAndReviewScore)
                .collect(Collectors.toList())
                .forEach(System.out::println);
            
            System.out.println(
                "\n-------------------------------------------" +
                "\nMost Popular Course - Number Of Studemts:: \n" +
                courses.stream().max(comparingByNumberOfStudentsAndReviewScore)
            );
            
            System.out.println(
                "\n-------------------------------------------" +
                "\nLeast Popular Course - Number Of Studemts:: \n" +
                courses.stream().min(comparingByNumberOfStudentsAndReviewScore)
            );
           
            System.out.println(
                "\n-------------------------------------------" +
                "\nNonExistent Record::Review Score TOO LOW::  " +
                "\nNotice that it returns Optional.Empty, NOT NUll::  \n" +
                courses.stream().filter(nonExistent).min(comparingByNumberOfStudentsAndReviewScore)
            );
            
            System.out.println(
                "\n-------------------------------------------" +
                "\nNonExistent Record::Review Score TOO LOW::  " +
                "\nWe can write code to return default Course::  \n" +
                courses.stream()
                    .filter(nonExistent)
                    .min(comparingByNumberOfStudentsAndReviewScore)
                    .orElse(new ITCourse("Ethics Course", "Mandatory", 0, 0))
            );
            
            System.out.println(
                "\n-------------------------------------------" +
                "\nFind FIRST RECORD that MEETS CRITERIA::  \n" +
                courses.stream()
                    .filter(distinction)
                    .findFirst()
            );
            
            System.out.println(
                "\n-------------------------------------------" +
                "\nTotal Number of Students in Course with Distinction Review Score::  \n" +
                courses.stream()
                    .filter(distinction)
                    .mapToInt(c->c.getNoOfStudents())
                    .sum()
            );
            
            System.out.println(
                "\n-------------------------------------------" +
                "\nAverage Number of Students in Course with Distinction Review Score::  \n" +
                courses.stream()
                    .filter(distinction)
                    .mapToInt(c->c.getNoOfStudents())
                    .average()
            );
            
            System.out.println(
                "\n-------------------------------------------" +
                "\nGROUP Courses BY CATEGORY::  \n" 
                );
            
            courses.stream()
                .collect(Collectors.groupingBy(c->c.getCategory()))
                .forEach((category, categoryCourses) -> {
                    System.out.println(category + ": " + categoryCourses + "\n");
                });
            
                System.out.println(
                "\n-------------------------------------------" +
                "\nLIST ONLY COURSE NAMES BY CATEGORY::  \n" 
                );
            
            courses.stream()
                .collect(Collectors.groupingBy(c->c.getCategory(),
                    Collectors.mapping(ITCourse::getName, Collectors.toList())))
                .forEach((category, categoryCourses) -> {
                    System.out.println(category + ": " + categoryCourses);
                });
            
            System.out.println(
                "\n-------------------------------------------" +
                "\nCount Courses BY CATEGORY::  \n" 
                );
            
            courses.stream()
                .collect(Collectors.groupingBy(c->c.getCategory(), Collectors.counting()))
                .forEach((category, categoryCourses) -> {
                    System.out.println(category + ": " + categoryCourses);
                });
            
            System.out.println(
                "\n-------------------------------------------" +
                "\nList Course with highest review Score BY CATEGORY::  \n" 
                );
            
            courses.stream()
                .collect(Collectors.groupingBy(c->c.getCategory(), 
                    Collectors.maxBy(Comparator.comparing(ITCourse::getReviewScore))))
                .forEach((category, categoryCourses) -> {
                    System.out.println(category + ": " + categoryCourses);
                });
            
            
        }
        
}
