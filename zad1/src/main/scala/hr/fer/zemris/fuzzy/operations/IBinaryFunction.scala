package hr.fer.zemris.fuzzy.operations

trait IBinaryFunction {
  def valueAt(a: Double, b: Double): Double
}
