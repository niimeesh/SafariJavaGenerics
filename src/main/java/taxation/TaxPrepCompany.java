package taxation;

import java.util.List;

public class TaxPrepCompany {
  public static void prepareTaxes(Taxable t) {}

  // ? represents the caller's type, and we are constraining
  // the relationship between that type and our Taxable (I call this
  // the "Anchor" type) BUT we have no other use for the caller's type

  // This form is generally called "co-variance"
  public static void prepareBulkTaxes(List<? extends Taxable> lt) {
    // This works (and is perhaps an easier step to understand)
//  public static <E extends Taxable>
//    void prepareBulkTaxes(List<E> lt/*, E item*/) {
//    lt.clear();
//    lt.size();
    Taxable t1 = lt.get(0); // if lt were ACTUALLY List<Individual> we get Individual
//    lt.add(new Taxable()); // this would fail for a List<Individual>
//    lt.add(new Charity()); // this would fail for a List<Individual>
//    lt.add(item); // IFF we used E and E item...
    for (int idx = 0; idx < lt.size(); idx++) {
      Taxable t = lt.get(idx);
      prepareTaxes(t);
    }
  }


  // NOT VALID SYNTAX, but expresses the necessary concept
//  public static <Individual extends E> void collectJoesClients(List<E> li) {

  // Called "contra-variance"
  public static void collectJoesClients(List<? super Individual> li) {
    Individual i = new Individual();
    li.add(i);
    li.add(new Individual());
  }

  // This is called "invariant" and is the ONLY syntax that will
  // permit both adding and removing
  public static void doStuff(List<Taxable> lt) {
    lt.add(new Taxable());
    lt.add(new Charity());
    Taxable t = lt.get(0);
  }

  public static void main(String[] args) {
    List<Taxable> clients = List.of(
        new Individual(),
        new Corporation(),
        new Individual(),
        new Charity()
    );
    collectJoesClients(clients);

    prepareBulkTaxes(clients);

    // Joe's tax prep service, only works with individuals
    List<Individual> joesClients = List.of(
        new Individual(),
        new Individual(),
        new Individual()
    );

    collectJoesClients(joesClients);

    prepareBulkTaxes(joesClients);

//    List<Charity> lc = null;
//    collectJoesClients(lc);

    List<Object> lo = null;
    collectJoesClients(lo);
  }
}
