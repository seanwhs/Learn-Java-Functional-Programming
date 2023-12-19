package learn;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.LongStream;

class UpgradingCourse {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public UpgradingCourse(String name, String category, int reviewScore, int noOfStudents) {
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

    // Predicate <ITCourse> cutOffReviewScore = course->course.getReviewScore()
    // >cutOffScore;
    // Now we can create Predicates with higher order function
    Predicate<UpgradingCourse> cutOffReviewScore65 = createCutOffReviewScorePredicate(65);
    Predicate<UpgradingCourse> cutOffReviewScore85 = createCutOffReviewScorePredicate(85);

    private Predicate<UpgradingCourse> createCutOffReviewScorePredicate(int cutOffScore) {
        return course -> course.getReviewScore() > cutOffScore;
    }
}

public class FP09HigherOrderFunctions {
    private static void performantFP(List<UpgradingCourse> courses) {
        // Performant Code in Functional Programming
        // Intermediate Operations are executed ONLY after terminal Operation
        System.out.println("\n--- FP with Streams is Performant----\n");
        String course = courses.stream()
                .peek(System.out::println) // did not process entire List. Stops after finding match
                .filter(c -> c.getName().length() > 6)
                .map(c -> c.getName().toUpperCase())
                .peek(System.out::println)
                .findFirst()
                .orElse("Nothing Found!!!");

        System.out.println("Final Result:: " + course);
    }

    public static void main(String[] args) {
        List<UpgradingCourse> courses = List.of(
                new UpgradingCourse("Spring", "Framework", 98, 15),
                new UpgradingCourse("Angular", "Framework", 78, 5),
                new UpgradingCourse("JavaScript", "Language", 78, 28),
                new UpgradingCourse("Python", "Language", 55, 68),
                new UpgradingCourse("Microservices", "Architecture", 98, 38));

        performantFP(courses);

        //Sum 1 to 1.9Billion 20 Tuimes using both single threaded and parallel operations
        long time = System.currentTimeMillis();
        int count = 20; //run 20 times
        for (int i=0;i<count;i++){
            System.out.println(
                "Sum 1 to 1.9 Billion using ONE Thread is:: " +
                LongStream.range(1, 1_900_000_000).sum());     
            }
            long duration1 = System.currentTimeMillis() - time;
            System.out.println(
                "\n SINGLE Threaded Operation Takes " + 
                (duration1) + "milliseconds\n"
                );
            
            long time2 = System.currentTimeMillis();
            for (int i=1;i<count;i++){
                System.out.println(
                    "Sum 1 to 1.9 Billion in PARALLEL (.parallel()) is:: " +
                    LongStream.range(1, 1_900_000_000).parallel().sum());
                }
            long duration2=System.currentTimeMillis() - time2;
            System.out.println(
                "\n PARALLEL Operation Takes " + 
                (duration2) + "milliseconds\n"
                );
            System.out.printf("Improvement in performance is %d percent", 100 * (duration1 - duration2) / duration1);

    }
}
