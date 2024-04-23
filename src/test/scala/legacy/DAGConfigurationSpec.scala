import munit.FunSuite
import subdomains.utils._
import subdomains.domainB.{SubdomainOpInstance5, SubdomainOpInstance6, SubdomainOpInstance7, SubdomainOpInstance8}
import subdomains.domainA.{SubdomainOpInstance1, SubdomainOpInstance2, SubdomainOpInstance3, SubdomainOpInstance4}
import subdomains.domainC.SubdomainOpInstance9
import subdomains.domainD.SubdomainOpInstance13
import subdomains.domainE.SubdomainOpInstance17

class DAGConfigurationSpec extends FunSuite {
  // Define 'ops' as a collection of SubdomainOp instances from all domains
  val ops: Seq[SubdomainOp] = Seq(
    SubdomainOpInstance1,
    SubdomainOpInstance2,
    SubdomainOpInstance3,
    SubdomainOpInstance4,
    SubdomainOpInstance5,
    SubdomainOpInstance6,
    SubdomainOpInstance7,
    SubdomainOpInstance8,
    SubdomainOpInstance9,
    SubdomainOpInstance10,
    SubdomainOpInstance11,
    SubdomainOpInstance12,
    SubdomainOpInstance13,
    SubdomainOpInstance14,
    // SubdomainOpInstance15, // Removed as it does not exist
    // SubdomainOpInstance16, // Removed as it does not exist
    SubdomainOpInstance17,
    SubdomainOpInstance18,
    SubdomainOpInstance19,
    SubdomainOpInstance20
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
        ops.exists(_.name == input) && isCyclic(ops.find(_.name == input).get)
      }
      recStack.remove(op.name)
      result
    }

    val hasCycles = ops.exists(isCyclic)
    assert(!hasCycles, "The DAG contains cycles")
  }

  test("SubdomainOp inputs must exist in the DAG") {
    val opNames = ops.map(_.name).toSet
    val inputsExist = ops.forall(op => op.inputs.forall(input => opNames.contains(input)))

    assert(inputsExist, "All SubdomainOp inputs must exist in the DAG")
  }
}
