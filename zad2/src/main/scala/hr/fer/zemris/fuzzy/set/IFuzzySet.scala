package hr.fer.zemris.fuzzy.set

import hr.fer.zemris.fuzzy.domain.{DomainElement, IDomain}

abstract class IFuzzySet {
  def getDomain: IDomain

  def getValueAt(el: DomainElement): Double
}
