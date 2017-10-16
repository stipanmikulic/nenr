package hr.fer.zemris.fuzzy.set

object StandardFuzzySets {
  def lFunction(a: Int, b: Int): IIntUnaryFunction = (index: Int) =>
    if (index < a) 1
    else if(index >= b) 0
    else (b - index).toDouble/(b-a)


  def gammaFunction(a: Int, b: Int): IIntUnaryFunction = (index: Int) =>
    if (index < a) 0
    else if(index >= b) 1
    else (index - a).toDouble/(b-a)


  def lambdaFunction(a: Int, b: Int, c: Int): IIntUnaryFunction = (index: Int) =>
    if (index < a) 0
    else if(index >= a && index < b) (index - a).toDouble/(b-a)
    else if(index >= b && index < c) (c-index).toDouble/(c-b)
    else 0
}
