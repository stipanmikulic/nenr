package hr.fer.zemris.fuzzy
import hr.fer.zemris.fuzzy.domain.{Domain, DomainElement, IDomain}
import hr.fer.zemris.fuzzy.relations.Relations
import hr.fer.zemris.fuzzy.set.{IFuzzySet, MutableFuzzySet}

object Zad1 {
  def main(args: Array[String]): Unit = {
    val u: IDomain = Domain.intRange(1, 6)
    val u2: IDomain = Domain.combine(u, u)

    val r1: IFuzzySet = new MutableFuzzySet(u2)
      .set(DomainElement.of(1,1), 1)
      .set(DomainElement.of(2,2), 1)
      .set(DomainElement.of(3,3), 1)
      .set(DomainElement.of(4,4), 1)
      .set(DomainElement.of(5,5), 1)
      .set(DomainElement.of(3,1), 0.5)
      .set(DomainElement.of(1,3), 0.5)
    val r2: IFuzzySet = new MutableFuzzySet(u2)
      .set(DomainElement.of(1,1), 1)
      .set(DomainElement.of(2,2), 1)
      .set(DomainElement.of(3,3), 1)
      .set(DomainElement.of(4,4), 1)
      .set(DomainElement.of(5,5), 1)
      .set(DomainElement.of(3,1), 0.5)
      .set(DomainElement.of(1,3), 0.1)
    val r3: IFuzzySet = new MutableFuzzySet(u2)
      .set(DomainElement.of(1,1), 1)
      .set(DomainElement.of(2,2), 1)
      .set(DomainElement.of(3,3), 0.3)
      .set(DomainElement.of(4,4), 1)
      .set(DomainElement.of(5,5), 1)
      .set(DomainElement.of(1,2), 0.6)
      .set(DomainElement.of(2,1), 0.6)
      .set(DomainElement.of(2,3), 0.7)
      .set(DomainElement.of(3,2), 0.7)
      .set(DomainElement.of(3,1), 0.5)
      .set(DomainElement.of(1,3), 0.5)
    val r4: IFuzzySet = new MutableFuzzySet(u2)
      .set(DomainElement.of(1,1), 1)
      .set(DomainElement.of(2,2), 1)
      .set(DomainElement.of(3,3), 1)
      .set(DomainElement.of(4,4), 1)
      .set(DomainElement.of(5,5), 1)
      .set(DomainElement.of(1,2), 0.4)
      .set(DomainElement.of(2,1), 0.4)
      .set(DomainElement.of(2,3), 0.5)
      .set(DomainElement.of(3,2), 0.5)
      .set(DomainElement.of(1,3), 0.4)
      .set(DomainElement.of(3,1), 0.4)

    val test1: Boolean = Relations.isUtimesURelation(r1)
    println("r1 je definiran nad UxU? "+test1)

    val test2: Boolean = Relations.isSymmetric(r1)
    println("r1 je simetrična? "+test2)

    val test3: Boolean = Relations.isSymmetric(r2)
    println("r2 je simetrična? "+test3)

    val test4: Boolean = Relations.isReflexive(r1)
    println("r1 je refleksivna? "+test4)

    val test5: Boolean = Relations.isReflexive(r3)
    println("r3 je refleksivna? "+test5)

    val test6: Boolean = Relations.isMaxMinTransitive(r3)
    println("r3 je max-min tranzitivna? "+test6)

    val test7: Boolean = Relations.isMaxMinTransitive(r4)
    println("r4 je max-min tranzitivna? "+test7)

  }
}
