package hr.fer.zemris.fuzzy.domain

abstract class Domain extends IDomain {
  override def indexOfElement(domainElement: DomainElement): Int = this.iterator.indexOf(domainElement)

  override def elementForIndex(n: Int): DomainElement = this.iterator.zipWithIndex.find(e => e._2 == n).orNull._1
}

object Domain {
  def intRange(start: Int, end: Int): IDomain = new SimpleDomain(start, end)

  def combine(start: IDomain, end: IDomain): IDomain = new CompositeDomain(flatten(start) ++ flatten(end))

  private def flatten(domain: IDomain): Array[SimpleDomain] = domain match {
    case d: SimpleDomain => Array(d)
    case c: CompositeDomain => c.getSimpleDomains
    case _ => Array()
  }

}