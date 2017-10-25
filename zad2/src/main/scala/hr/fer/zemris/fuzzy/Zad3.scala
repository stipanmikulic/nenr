package hr.fer.zemris.fuzzy

import hr.fer.zemris.fuzzy.domain.Domain
import hr.fer.zemris.fuzzy.domain.DomainElement
import hr.fer.zemris.fuzzy.relations.Relations
import hr.fer.zemris.fuzzy.set.{IFuzzySet, MutableFuzzySet}

object Zad3 {
  def main(args: Array[String]): Unit = {
    val u = Domain.intRange(1, 5)

    val r = new MutableFuzzySet(Domain.combine(u, u))
      .set(DomainElement.of(1, 1), 1)
      .set(DomainElement.of(2, 2), 1)
      .set(DomainElement.of(3, 3), 1)
      .set(DomainElement.of(4, 4), 1)
      .set(DomainElement.of(1, 2), 0.3)
      .set(DomainElement.of(2, 1), 0.3)
      .set(DomainElement.of(2,3), 0.5)
      .set(DomainElement.of(3,2), 0.5)
      .set(DomainElement.of(3,4), 0.2)
      .set(DomainElement.of(4,3), 0.2)

    var r2: IFuzzySet = r
    println("Početna relacija je neizrazita relacija ekvivalencije? " + Relations.isFuzzyEquivalence(r2))
    println()

    for(i <- 1 to 3) {
      r2 = Relations.compositionOfBinaryRelations(r2, r)
      println("Broj odrađenih kompozicija: " + i + ". Relacija je:")
      for(e <- r2.getDomain) {
        println("mu("+e+")="+r2.getValueAt(e))
      }
      println("Ova relacija je neizrazita relacija ekvivalencije? " + Relations.isFuzzyEquivalence(r2))
      println()
    }
  }

}
