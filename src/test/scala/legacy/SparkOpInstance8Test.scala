import org.scalatest.funsuite.AnyFunSuite
import subdomains.domainB.SubdomainOpInstanceB

class SubdomainOpInstanceBTest extends AnyFunSuite {
  test("SubdomainOpInstanceB: name should be subdomain-op-instance-B") {
    assert(SubdomainOpInstanceB.name == "subdomain-op-instance-B")
  }

  // Additional tests for inputs, query, metadata, and runConfigurations can be added here
}
