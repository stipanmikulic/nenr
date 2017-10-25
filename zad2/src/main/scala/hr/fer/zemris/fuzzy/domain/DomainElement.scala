package hr.fer.zemris.fuzzy.domain

class DomainElement(val values: Array[Int]) {
  def getNumberOfComponents: Int = values.length

  def getComponentValue(n: Int): Int = values(n)

  override def hashCode(): Int = values.hashCode()

  override def equals(obj: scala.Any): Boolean = obj match {
    case o: DomainElement => values.deep == o.values.deep
    case _ => false
  }

  override def toString: String = if (getNumberOfComponents == 1) values(0) toString else values.mkString("(", ",", ")")
}

object DomainElement {
  def of(values: Int*): DomainElement = new DomainElement(values.toArray)
}