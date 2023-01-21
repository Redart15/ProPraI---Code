//import java.util.Scanner;
//import java.util.Collection;
import java.util.*;

// cmd /c --%  java Sort < text.txt
// to feed lines into windows

/*
public class Sort{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        List<String> strings = new ArrayList<>();
        //List<String> strings = new LinkedList<>();
        String next = "";

        while(input.hasNextLine()){
            next = input.nextLine();
            strings.add(next);
        }

        Collections.sort(strings);

        for(String s : strings) {
             System.out.println(s);
        }
    }
}
 */
import java.util.*;

public class Sort{
    public static void main(String[]args){
        Scanner stdin = new Scanner(System.in);
        List<String> zeilen = new ArrayList<>();

        while(stdin.hasNext()){
            zeilen.add(stdin.nextLine());
        }
        Collections.sort(zeilen);
        zeilen.forEach(System.out::println);
    }
}