package example;

import org.springframework.boot.SpringApplication;  
import org.springframework.boot.autoconfigure.SpringBootApplication; 

@SpringBootApplication 	////similar to @Configuration @EnableAutoConfiguration @ComponentScan 
public class Example 
{
public static void main(String[] args)
{  
SpringApplication.run(Example.class, args);  
} 
}