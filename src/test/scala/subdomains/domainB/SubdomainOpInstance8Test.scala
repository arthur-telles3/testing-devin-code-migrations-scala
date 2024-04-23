import org.scalatest.funsuite.AnyFunSuite
import subdomains.domainB.SubdomainOpInstance8

class SubdomainOpInstance8Test extends AnyFunSuite {
  test("SubdomainOpInstance8: name should be subdomainB-op-instance-8") {
    val instance = new SubdomainOpInstance8()
    assert(instance.name == "subdomainB-op-instance-8")
  }

  // Additional tests for inputs, query, metadata, and runConfigurations can be added here
}
