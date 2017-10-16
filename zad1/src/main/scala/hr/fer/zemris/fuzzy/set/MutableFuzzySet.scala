package hr.fer.zemris.fuzzy.set
import hr.fer.zemris.fuzzy.domain.{DomainElement, IDomain}

class MutableFuzzySet(domain: IDomain) extends IFuzzySet {
  var memberships: Array[Double] = Array.fill(domain.getCardinality)(0)

  override def getDomain: IDomain = domain

  override def getValueAt(el: DomainElement): Double = memberships(domain.indexOfElement(el))

  def set(el: DomainElement, value: Double): MutableFuzzySet = {
    memberships(domain.indexOfElement(el)) = value
    this
  }
}
