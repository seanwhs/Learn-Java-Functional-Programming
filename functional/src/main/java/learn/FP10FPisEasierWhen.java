package learn;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FP10FPisEasierWhen {
    private static void traditionalThread(){       
        Runnable runable = new Runnable() {
            int count = 50; 
            @Override
            public void run(){
                for (int i=0; i<count; i++){
                    System.out.println(Thread.currentThread().threadId() + "::" +i);
                }
            }
        };
        
        Thread thread1 = new Thread(runable);
        thread1.start();
        Thread thread2 = new Thread(runable);
        thread2.start();
        Thread thread3 = new Thread(runable);
        thread3.start();
    }
    
    private static void functionalThread(){  //Runnable is a functional Interface    
        Runnable runable2 = () -> {
            int count = 50; 
            for (int i=0; i<count; i++){
                System.out.println(Thread.currentThread().threadId() + "::" +i);
            }
        };
        
        Thread thread1 = new Thread(runable2);
        thread1.start();
        Thread thread2 = new Thread(runable2);
        thread2.start();
        Thread thread3 = new Thread(runable2);
        thread3.start();
    }

    public static void main(String[] args) throws IOException {
        List<String> courses 
            = new ArrayList<>(List.of
                ("Spring", "Java", "TypeScript", "AWS", "GCP", "Microservices")
                );
        System.out.println("--- 1. We can pass methods as arguments to functions!!!");
        courses.replaceAll(str->str.toUpperCase());
        System.out.println(courses);
        courses.removeIf(c->c.length()<6);
        System.out.println(courses);
        
        System.out.println("--- 2. File Processing is easier too!!!!");
        String filePath = "D:\\Documents\\SCTP Training\\javase2\\src\\main\\java\\com\\sctp\\Functional\\test.txt";
        System.out.println("\n**Raed in Entire File line by line:::");
        Files.lines(Paths.get(filePath)) //read in all lines
        .forEach(System.out::println);       
        
        System.out.println("\n**Process words in file:::");
        Files.lines(Paths.get(filePath)) //read in all lines
        .map(str->str.split(" ")) //split EACH Line into array of strings
        .flatMap(Arrays::stream) //convert into a single stream
        .distinct()
        .sorted()
        .forEach(System.out::println);       
        
        System.out.println("\n**Print Files and Directories at Root of Java Project:::");
        Files.list(Paths.get(".")).forEach(System.out::println);
        
        System.out.println("\n**Print ONLY Directories at Root of Java Project:::");
        System.out.println("--Notice that POM.xml is no longer printed");
        Files.list(Paths.get(".")).filter(Files::isDirectory).forEach(System.out::println);
        
        System.out.println("/n--- 3. Running Threads is easier to write too!!!!");
        traditionalThread();
        functionalThread();
    }
}
