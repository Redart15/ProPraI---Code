import java.time.LocalDateTime;
public class Hello{

    private String greeting(){
        int stunde = LocalDateTime.now().getHour();
        if(stunde <= 4 && stunde < 11) return "Guten Morgen";
        if(stunde <= 11 && stunde < 14) return "Mahlzeit";
        if(stunde <= 14 && stunde < 18) return "Guten Tag";
        if(stunde <= 18 && stunde < 22) return "Guten Abend";
        return "Gute Nacht";
    }
    public static void main(String[] args) {
        Hello app = new Hello();
        System.out.println(app.greeting());
    }
}