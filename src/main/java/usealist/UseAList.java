package usealist;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UseAList {

  public static void doStuff(List<String> ls) {}
  public static void doStuff(int ls) {}
  // not a valid overload: generic type param doesn't make it different
//  public static void doStuff(List<StringBuilder> ls) {}

//  public static void addToList(List<String> l) {
  public static void addToList(List l) {
    l.add(0, LocalDate.now());
  }

  public static void main(String[] args) {
    List<String> names =
//        new ArrayList<String>(List.of(LocalDate.now(), "Alice"));
        new ArrayList<>(List.of(/*LocalDate.now(), */"Alice"));
    names = Collections.checkedList(names, String.class);
    names.add("Fred");
    names.add("Jim");
//    names.add(LocalDate.now());
    System.out.println(names);
    System.out.println(names.get(0));
//    addToList(names);
    System.out.println(names);
//    String s = (String)names.get(0);
    String s = names.get(0); // cast is coded by the complier for us

    Object obj = names;
//    if (obj instanceof List<String>) {
//      System.out.println("Yup, it's a list");
//    }

    var var = new ArrayList<>(List.of("hello"));

    boolean b = Math.random() > 0.5;
    var obj2
//        = b ? "Hello" : new StringBuilder();
        = b ? "Hello" : 99;

    Class listCl = new ArrayList<String>().getClass();
    System.out.println(listCl);

    Class list2Cl = new ArrayList<LocalDate>().getClass();
    System.out.println(list2Cl);

    System.out.println(listCl == list2Cl);

    // Nope, generics (currently) is limited to reference types
//    List<int> li;
  }
}
