public class StaticInit {
    static{
        System.out.print("Hello");
    }

    private static final String HELLO = hello();
    
    static{
        System.out.println("world");
    }

    public static String hello(){
        System.out.print(", ");
        return "Hello";
    }
    
    public static void main(String[] args) {
        
    }
}
