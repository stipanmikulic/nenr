package hr.fer.zemris.fuzzy

import hr.fer.zemris.fuzzy.domain.{Domain, DomainElement, IDomain}
import hr.fer.zemris.fuzzy.operations.Operations
import hr.fer.zemris.fuzzy.set.{IFuzzySet, MutableFuzzySet}

object Zad3 {
  def main(args: Array[String]): Unit = {
    val d: IDomain = Domain.intRange(0, 11)
    val set1: IFuzzySet = new MutableFuzzySet(d)
      .set(DomainElement.of(0), 1.0)
      .set(DomainElement.of(1), 0.8)
      .set(DomainElement.of(2), 0.6)
      .set(DomainElement.of(3), 0.4)
      .set(DomainElement.of(4), 0.2)

    Debug.print(set1, "Set1:")
    val notSet1: IFuzzySet = Operations.unaryOperation(
      set1, Operations.zadehNot())

    Debug.print(notSet1, "notSet1:")
    val union: IFuzzySet = Operations.binaryOperation(
      set1, notSet1, Operations.zadehOr())

    Debug.print(union, "Set1 union notSet1:")
    val hinters: IFuzzySet = Operations.binaryOperation(
      set1, notSet1, Operations.hamacherTNorm(1.0))

    Debug.print(hinters, "Set1 intersection with notSet1 using parameterised Hamacher T norm with parameter 1.0:")
  }

}
