import org.scalatest.funsuite.AnyFunSuite
import subdomains.domainA.SubdomainOpInstance1

class SubdomainOpInstance1Test extends AnyFunSuite {
  test("SubdomainOpInstance1: name should be subdomainA-op-instance-1") {
    assert(SubdomainOpInstance1.name == "subdomainA-op-instance-1")
  }

  // Additional tests for inputs, query, metadata, and runConfigurations can be added here
}
