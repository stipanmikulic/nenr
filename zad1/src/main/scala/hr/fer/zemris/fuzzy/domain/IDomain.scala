package hr.fer.zemris.fuzzy.domain

trait IDomain extends Iterable[DomainElement] {
  def getCardinality: Int
  def getComponent(n: Int): IDomain
  def getNumberOfComponents: Int
  def indexOfElement(domainElement: DomainElement): Int
  def elementForIndex(n: Int): DomainElement
  def iterator: Iterator[DomainElement]
}
