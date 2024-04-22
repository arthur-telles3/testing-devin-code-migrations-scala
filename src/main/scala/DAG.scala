import platform.common_classes.SubdomainOp
import subdomains.domainA.SubdomainOpInstanceA

object DAG {
  val ops: Set[SubdomainOp] = Set(
    // Assuming all legacy SparkOp instances have been migrated to SubdomainOp instances
    // and are located in their respective domain packages
    SubdomainOpInstanceA,
    subdomains.domainB.SubdomainOpInstanceBPrevious,
    subdomains.domainB.SubdomainOpInstanceB,
    // ... other SubdomainOp instances from domains C, D, E, and any other migrated SparkOp instances
  )
}
