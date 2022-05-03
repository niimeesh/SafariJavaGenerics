package shopping;

// WATCH OUT, we here declare two type params, NOT two constraints
//public class ClothingPair<E extends Sized, String> extends Pair<E> {
// multiple constraints can include many interfaces and
// at most one class. IF we want a class, it must be specified FIRST
public class ClothingPair<E extends /*Object &*/ Sized & Colored>
    extends Pair<E> {
  java.lang.String m = "Hello";

  public ClothingPair(E left, E right) {
    super(left, right);
  }

  public boolean matched() {
    return left.getSize() == right.getSize()
        && left.getColor().equals(right.getColor());
  }
}
