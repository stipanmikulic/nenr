package hr.fer.zemris.fuzzy.domain

class SimpleDomain(first: Int, last: Int) extends Domain {

  override def getCardinality: Int = math.abs(last - first)

  override def getComponent(n: Int): SimpleDomain = this

  override def getNumberOfComponents = 1

  def iterator: Iterator[DomainElement] = new Iterator[DomainElement] {
    var current: Int = first

    override def hasNext: Boolean = current != last

    override def next: DomainElement = {
      if (hasNext) {
        val n = current
        current = current + 1
        DomainElement.of(n)
      } else null
    }
  }

  def getFirst: Int = first

  def getLast: Int = last
}
