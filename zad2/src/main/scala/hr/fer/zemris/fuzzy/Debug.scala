package hr.fer.zemris.fuzzy

import hr.fer.zemris.fuzzy.domain.IDomain
import hr.fer.zemris.fuzzy.set.IFuzzySet

object Debug {
  def print(domain: IDomain, headingText: String): Unit = {
    if (headingText != null) println(headingText)
    for (e <- domain) {
      println("Element domene: " + e)
    }
    println("Kardinalitet domene je: " + domain.getCardinality)
    println()
  }

  def print(fuzzySet: IFuzzySet, headingText: String): Unit = {
    if (headingText != null) println(headingText)
    for (e <- fuzzySet.getDomain) {
      println("d(%s)=%f" format (e.toString, fuzzySet.getValueAt(e)))
    }
    println()
  }


}
