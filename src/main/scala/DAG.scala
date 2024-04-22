import subdomains.utils.SubdomainOp
import subdomains.domainA.SubdomainOpInstance1
import subdomains.domainA.SubdomainOpInstance2
import subdomains.domainA.SubdomainOpInstance3
import subdomains.domainA.SubdomainOpInstance4
import subdomains.domainB.SubdomainOpInstance5
import subdomains.domainB.SubdomainOpInstance6
import subdomains.domainB.SubdomainOpInstance7
import subdomains.domainB.SubdomainOpInstance8

object DAG {
  val ops: Set[SubdomainOp] = Set(
    // Instances from domain A
    SubdomainOpInstance1,
    SubdomainOpInstance2,
    SubdomainOpInstance3,
    SubdomainOpInstance4,
    // Instances from domain B
    SubdomainOpInstance5,
    SubdomainOpInstance6,
    SubdomainOpInstance7,
    SubdomainOpInstance8
    // ... any other migrated SubdomainOp instances
  )
}
