package hr.fer.zemris.fuzzy
import hr.fer.zemris.fuzzy.domain.{Domain, DomainElement, IDomain}

object Zad1 {
  def main(args: Array[String]): Unit = {
    val d1:IDomain = Domain.intRange(0, 5)
    Debug.print(d1, "Elementi domene d1:")

    val d2:IDomain = Domain.intRange(0, 3)
    Debug.print(d2, "Elementi domene d2:")

    val d3:IDomain = Domain.combine(d1, d2)
    Debug.print(d3, "Elementi domene d3:")

    println(d3.elementForIndex(0))
    println(d3.elementForIndex(5))
    println(d3.elementForIndex(14))
    println(d3.indexOfElement(DomainElement.of(4, 1)))
  }
}
