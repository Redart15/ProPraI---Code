import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Verteiler<K,V> {

  public Map<K, List<V>> verteilen(List<V> studierende, List<K> tutoren,
                                              int min, int max) {

    Map<K, List<V>> result = new HashMap<>();
    int size = studierende.size();

    // Berechne n, so dass die Studierenden auf n Gruppen verteilt werden können
    int n = (int) Math.ceil((double) size / max);

    // gleichmäßig verteilen
    int gruppeidx = 0;
    for (int i = 0; i < size; i++) {
      store(result, tutoren.get(gruppeidx), studierende.get(i));
      gruppeidx = (gruppeidx + 1) % n;
    }

    return result;
  }

  private void store(Map<K, List<V>> result, K key, V value) {
    List<V> list = result.getOrDefault(key, new ArrayList<>());
    list.add(value);
    result.putIfAbsent(key,list);
  }
}
