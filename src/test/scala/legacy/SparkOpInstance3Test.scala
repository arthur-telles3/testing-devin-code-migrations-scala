import org.scalatest.funsuite.AnyFunSuite
import subdomains.domainC.SubdomainOpInstance3

class SubdomainOpInstance3Test extends AnyFunSuite {
  test("SubdomainOpInstance3: name should be subdomainC-op-instance-3") {
    assert(SubdomainOpInstance3.name == "subdomainC-op-instance-3")
  }

  // Additional tests for inputs, query, metadata, and runConfigurations can be added here
}
