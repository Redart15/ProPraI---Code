import java.util.*;

public class Uebung1{

    public static HashMap<String,ArrayList<String>> sort(ArrayList<String> studenten, ArrayList<String> tutoren, int anzahlGruppen, int maxStudis){
        HashMap<String, ArrayList<String>> zuteilung = new HashMap<>();

        int tutor_idx = 0;
        int studis_idx = 0;

        for(int i = 0; i < anzahlGruppen; i++){
            ArrayList<String> gruppe = new ArrayList<>();
            for(int j = 0; j < maxStudis; j++){
                gruppe.add(studenten.get(studis_idx));
                studis_idx++;
               // zuteilung.put(tutor.get(tutor_idx), null);
            }
            zuteilung.put(tutoren.get(tutor_idx), gruppe);
            tutor_idx++;
        }
        
    return zuteilung;

    }

    public static void main(String[] args) {

                ArrayList<String> studis = new ArrayList<>();
                //List<String> studis = new ArrayList<>();
                //List<String> tutoren = new ArrayList<>();
                ArrayList<String> tutoren = new ArrayList<>();

                studis.add("Kathrin");
                tutoren.add("Max");

                int min = 1;
                int max = 1;
                int gruppenanzahl =(int) (Math.ceil(studis.size() / max));

                HashMap<String, ArrayList<String>> zuteilung = sort(studis, tutoren, gruppenanzahl, max);
                System.out.println(zuteilung.toString());

    }
}
