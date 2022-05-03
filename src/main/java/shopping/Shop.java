package shopping;

public class Shop {
  public static void main(String[] args) {
    ClothingPair<Shoe> ps =
        new ClothingPair<>(new Shoe(9, "Black"), new Shoe(10, "Black"));
    System.out.println(ps);
    Shoe left = ps.getLeft();
    ps.setRight(new Shoe(8, "Black"));
    if (ps.matched()) {
      System.out.println("Sell, 'em, they're a matched pair!");
    } else {
      System.out.println("Charge a premium for an unmatched pair!");
    }

    ClothingPair<Shoe> ps2 =
        new ClothingPair<>(new Shoe(10, "Red"), new Shoe(10, "Black"));
    System.out.println("ps2 matches? " + ps2.matched());
  }
}
