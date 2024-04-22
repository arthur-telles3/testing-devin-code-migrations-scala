import org.scalatest.funsuite.AnyFunSuite
import subdomains.domainB.SubdomainOpInstanceBPrevious

class SubdomainOpInstanceBPreviousTest extends AnyFunSuite {
  test("SubdomainOpInstanceBPrevious: name should be subdomain-op-instance-B-previous") {
    assert(SubdomainOpInstanceBPrevious.name == "subdomain-op-instance-B-previous")
  }

  // Additional tests for inputs, query, metadata, and runConfigurations can be added here
}
