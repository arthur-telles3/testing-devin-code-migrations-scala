import platform.common_classes.SubdomainOp
import subdomains.domainA.SubdomainOpInstanceA
import subdomains.domainB.SubdomainOpInstanceBPrevious
import subdomains.domainB.SubdomainOpInstanceB

object DAG {
  val ops: Set[SubdomainOp] = Set(
    // Instances from domain A
    SubdomainOpInstanceA,
    // Instances from domain B
    SubdomainOpInstanceBPrevious,
    SubdomainOpInstanceB
    // ... any other migrated SparkOp instances
  )
}
