package hr.fer.zemris.fuzzy

import hr.fer.zemris.fuzzy.domain.Domain
import hr.fer.zemris.fuzzy.domain.DomainElement
import hr.fer.zemris.fuzzy.relations.Relations
import hr.fer.zemris.fuzzy.set.MutableFuzzySet

object Zad2 {
  def main(args: Array[String]): Unit = {

    val u1 = Domain.intRange(1, 5)
    val u2 = Domain.intRange(1, 4)
    val u3 = Domain.intRange(1, 5)

    val r1 = new MutableFuzzySet(Domain.combine(u1, u2))
      .set(DomainElement.of(1, 1), 0.3)
      .set(DomainElement.of(1, 2), 1)
      .set(DomainElement.of(3, 3), 0.5)
      .set(DomainElement.of(4, 3), 0.5)

    val r2 = new MutableFuzzySet(Domain.combine(u2, u3))
      .set(DomainElement.of(1, 1), 1)
      .set(DomainElement.of(2, 1), 0.5)
      .set(DomainElement.of(2, 2), 0.7)
      .set(DomainElement.of(3, 3), 1)
      .set(DomainElement.of(3, 4), 0.4)

    val r1r2 = Relations.compositionOfBinaryRelations(r1, r2)
    for (e <- r1r2.getDomain) {
      println("mu(" + e + ")=" + r1r2.getValueAt(e))
    }
  }
}
