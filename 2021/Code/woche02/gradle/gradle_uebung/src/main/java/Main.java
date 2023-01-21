import com.google.inject.*;

public class Main {

 public static void main(String[] as) {
     Injector inj = Guice.createInjector();
     System.out.println("Works: "+inj);
 } 

}