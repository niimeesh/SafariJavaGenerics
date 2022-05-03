package shopping;

import java.time.LocalDate;

public class UseMyPair {
  public static void main(String[] args) {
//    Pair<String> p = new Pair<>("Hello", LocalDate.now());
    Pair<String> p = new Pair<>("Hello", "Bonjour");
    String l = p.getLeft();
    p.setRight("Guten Tag");
  }
}
