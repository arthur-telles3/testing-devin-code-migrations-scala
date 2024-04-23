import munit.FunSuite
import subdomains.utils._
import subdomains.domainB.{SubdomainOpInstance5, SubdomainOpInstance6, SubdomainOpInstance7, SubdomainOpInstance8}
import subdomains.domainA.{SubdomainOpInstance1, SubdomainOpInstance2, SubdomainOpInstance3, SubdomainOpInstance4}
import subdomains.domainC.{SubdomainOpInstance9, SubdomainOpInstance10, SubdomainOpInstance11, SubdomainOpInstance12}
import subdomains.domainD.{SubdomainOpInstance13, SubdomainOpInstance14}
import subdomains.domainE.{SubdomainOpInstance17, SubdomainOpInstance18, SubdomainOpInstance19, SubdomainOpInstance20}

class DAGConfigurationSpec extends FunSuite {
  // Define 'ops' as a collection of SubdomainOp instances from all domains
  val ops: Seq[SubdomainOp] = Seq(
    new SubdomainOpInstance1(),
    new SubdomainOpInstance2(),
    new SubdomainOpInstance3(),
    new SubdomainOpInstance4(),
    new SubdomainOpInstance5(),
    new SubdomainOpInstance6(),
    new SubdomainOpInstance7(),
    new SubdomainOpInstance8(),
    new SubdomainOpInstance9(),
    new SubdomainOpInstance10(),
    new SubdomainOpInstance11(),
    new SubdomainOpInstance12(),
    new SubdomainOpInstance13(),
    new SubdomainOpInstance14(),
    // new SubdomainOpInstance15(), // Removed as it does not exist
    // new SubdomainOpInstance16(), // Removed as it does not exist
    new SubdomainOpInstance17(),
    new SubdomainOpInstance18(),
    new SubdomainOpInstance19(),
    new SubdomainOpInstance20()
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
