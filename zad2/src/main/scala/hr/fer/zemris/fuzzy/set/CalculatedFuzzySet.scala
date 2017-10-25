package hr.fer.zemris.fuzzy.set

import hr.fer.zemris.fuzzy.domain.{DomainElement, IDomain}

class CalculatedFuzzySet(domain: IDomain, f: IIntUnaryFunction) extends IFuzzySet  {

  override def getDomain: IDomain = domain

  override def getValueAt(el: DomainElement): Double = f.valueAt(domain.indexOfElement(el))

}
