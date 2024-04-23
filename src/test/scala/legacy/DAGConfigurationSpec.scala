import munit.FunSuite
import subdomains.utils._
import subdomains.domainB._

class DAGConfigurationSpec extends FunSuite {
  // Define 'ops' as a collection of SubdomainOp instances from domain B
  val ops: Seq[SubdomainOp] = Seq(
    new SubdomainOpInstance5(),
    new SubdomainOpInstance6(),
    new SubdomainOpInstance7(),
    new SubdomainOpInstance8()
  )

  test("DAG should have no cycles") {
    val visited = scala.collection.mutable.Set[String]()
    val recStack = scala.collection.mutable.Set[String]()

    def isCyclic(op: SubdomainOp): Boolean = {
      println(s"Checking for cycles at: ${op.name}")
      if (recStack.contains(op.name)) return true
      if (visited.contains(op.name)) return false

      visited.add(op.name)
      recStack.add(op.name)

      val result = op.inputs.exists { input =>
        ops.exists(_.name == input.name) && isCyclic(ops.find(_.name == input.name).get)
      }
      recStack.remove(op.name)
      result
    }

    val hasCycles = ops.exists(isCyclic)
    assert(!hasCycles, "The DAG contains cycles")
  }

  test("SubdomainOp inputs must exist in the DAG") {
    val opNames = ops.map(_.name).toSet
    val inputsExist = ops.forall(op => op.inputs.forall(input => opNames.contains(input.name)))

    assert(inputsExist, "All SubdomainOp inputs must exist in the DAG")
  }
}
