package hr.fer.zemris.fuzzy.operations

import hr.fer.zemris.fuzzy.set.{IFuzzySet, MutableFuzzySet}

object Operations {
  def unaryOperation(fuzzySet: IFuzzySet, unaryFunction: IUnaryFunction): IFuzzySet = {
    val newFuzzySet = new MutableFuzzySet(fuzzySet.getDomain)
    fuzzySet.getDomain.iterator.foreach(e => newFuzzySet.set(e, unaryFunction.valueAt(fuzzySet.getValueAt(e))))
    newFuzzySet
  }

  def binaryOperation(fuzzySet1: IFuzzySet, fuzzySet2: IFuzzySet, binaryFunction: IBinaryFunction): IFuzzySet = {
    val newFuzzySet = new MutableFuzzySet(fuzzySet1.getDomain)
    fuzzySet2.getDomain.iterator.foreach(e => newFuzzySet.set(e, binaryFunction.valueAt(fuzzySet1.getValueAt(e), fuzzySet2.getValueAt(e))))
    newFuzzySet
  }

  def zadehNot(): IUnaryFunction = (a: Double) => 1 - a

  def zadehAnd(): IBinaryFunction = (a: Double, b: Double) => math.min(a, b)

  def zadehOr(): IBinaryFunction = (a: Double, b: Double) => math.max(a, b)

  def hamacherTNorm(value: Double): IBinaryFunction = (a: Double, b: Double) => (a*b)/(value+(1-value)*(a+b-a*b))

  def hamacherSNorm(value: Double): IBinaryFunction = (a: Double, b: Double) => (a+b-(2- value)*a*b)/(1-(1-value)*a*b)
}
