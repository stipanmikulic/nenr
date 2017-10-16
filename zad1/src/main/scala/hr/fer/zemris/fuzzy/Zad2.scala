package hr.fer.zemris.fuzzy

import hr.fer.zemris.fuzzy.domain.Domain
import hr.fer.zemris.fuzzy.domain.DomainElement
import hr.fer.zemris.fuzzy.domain.IDomain
import hr.fer.zemris.fuzzy.set.{CalculatedFuzzySet, MutableFuzzySet, StandardFuzzySets}

object Zad2 {
  def main(args: Array[String]): Unit = {
    val d:IDomain = Domain.intRange(0, 11)
    val set1 = new MutableFuzzySet(d)
      .set(DomainElement.of(0), 1.0)
      .set(DomainElement.of(1), 0.8)
      .set(DomainElement.of(2), 0.6)
      .set(DomainElement.of(3), 0.4)
      .set(DomainElement.of(4), 0.2)
    Debug.print(set1, "Set1:")

    val d2 = Domain.intRange(-5, 6)
    // {-5,-4,...,4,5}
    val set2 = new CalculatedFuzzySet(d2, StandardFuzzySets.lambdaFunction(
        d2.indexOfElement(DomainElement.of(-4)),
        d2.indexOfElement(DomainElement.of(0)),
        d2.indexOfElement(DomainElement.of(4))))
    Debug.print(set2, "Set2:")
  }
}
