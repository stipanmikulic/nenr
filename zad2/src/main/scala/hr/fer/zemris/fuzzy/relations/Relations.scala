package hr.fer.zemris.fuzzy.relations

import hr.fer.zemris.fuzzy.domain.{Domain, DomainElement, SimpleDomain}
import hr.fer.zemris.fuzzy.set.{IFuzzySet, MutableFuzzySet}

object Relations {
  def isReflexive(s: IFuzzySet): Boolean =
    if (!isUtimesURelation(s))
      false
    else s.getDomain.iterator
      .filter(e => e.getComponentValue(0) == e.getComponentValue(1)).forall(e => s.getValueAt(e) == 1)


  def isSymmetric(s: IFuzzySet): Boolean =
    if (!isUtimesURelation(s))
      false
    else s.getDomain.iterator.forall(e => s.getValueAt(e) == s.getValueAt(DomainElement.of(e.getComponentValue(1), e.getComponentValue(0))))


  def isMaxMinTransitive(s: IFuzzySet): Boolean = {
    def checkTransitivity(x: Int, z: Int): Boolean = {
      s.getValueAt(DomainElement.of(x, z)) >= max_min_binary_composition(s, s, x, z)
    }

    if (!isUtimesURelation(s))
      false
    else
      s.getDomain.iterator.forall(e => checkTransitivity(e.getComponentValue(0), e.getComponentValue(1)))
  }


  def isUtimesURelation(s: IFuzzySet): Boolean =
    if (s.getDomain.getNumberOfComponents != 2)
      false
    else
      s.getDomain.getComponent(0).iterator sameElements s.getDomain.getComponent(1).iterator


  def isFuzzyEquivalence(s: IFuzzySet): Boolean = isSymmetric(s) && isReflexive(s) && isMaxMinTransitive(s)


  def compositionOfBinaryRelations(s1: IFuzzySet, s2: IFuzzySet): IFuzzySet = {
    if (s1.getDomain.getNumberOfComponents != 2 || s2.getDomain.getNumberOfComponents != 2) null
    else {
      val u = s1.getDomain.getComponent(0)
      val w = s2.getDomain.getComponent(1)
      val fs = new MutableFuzzySet(Domain.combine(u, w))
      fs.getDomain.iterator.foreach(e => fs.set(e, max_min_binary_composition(s1, s2, e.getComponentValue(0), e.getComponentValue(1))))
      fs
    }
  }

  private def max_min_binary_composition(s1: IFuzzySet, s2: IFuzzySet, x: Int, z: Int): Double = {
    val domain: SimpleDomain = s1.getDomain.getComponent(1).asInstanceOf[SimpleDomain]
    val t_norm = (domain.getFirst until domain.getLast).map(y => Math.min(s1.getValueAt(DomainElement.of(x, y)), s2.getValueAt(DomainElement.of(y, z))))
    t_norm.max
  }
}
