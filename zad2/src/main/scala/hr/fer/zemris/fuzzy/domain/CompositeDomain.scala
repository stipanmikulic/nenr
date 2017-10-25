package hr.fer.zemris.fuzzy.domain

class CompositeDomain(simpleDomains: Array[SimpleDomain]) extends Domain {
  override def getCardinality: Int = simpleDomains map {e => e.getCardinality} product

  override def getComponent(n: Int) = simpleDomains(n)

  override def getNumberOfComponents: Int = simpleDomains.length

  def getSimpleDomains: Array[SimpleDomain] = simpleDomains

  def iterator: Iterator[DomainElement] = new Iterator[DomainElement] {
    var domains: Int = simpleDomains.length
    var currentElements: Array[Int] = simpleDomains map {e => e.getFirst}

    override def hasNext: Boolean = currentElements(0) < simpleDomains(0).getLast

    override def next: DomainElement = {
      if (hasNext) {
        val elements = currentElements.clone()
        for ( i <- (0 until domains).reverse) {
          val newValue = currentElements(i) + 1
          val component = getComponent(i)
          if (newValue == component.getLast && i != 0)
            currentElements(i) = component.getFirst
          else {
            currentElements(i) = currentElements(i) + 1
            return new DomainElement(elements)
          }
        }
      }
      null
    }
  }
}
