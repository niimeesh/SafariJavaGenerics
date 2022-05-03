package shopping;

import java.util.function.BiPredicate;

public class Pair<E> {
  E left;
  E right;

  public Pair(E left, E right) {
    this.left = left;
    this.right = right;
  }

  public E getLeft() {
    return left;
  }

  public void setLeft(E left) {
    this.left = left;
  }

  public E getRight() {
    return right;
  }

  public void setRight(E right) {
    this.right = right;
  }

  // this is the "right" way
  public boolean matched(BiPredicate<E, E> test) {
    return test.test(left, right);
  }

//  public boolean matched() {
//    return left.getSize() == right.getSize();
//  }

  @Override
  public String toString() {
    return "Pair{" +
        "left=" + left +
        ", right=" + right +
        '}';
  }
}
