import platform.common_classes.SparkOp

object DAG {
  val ops: Set[SparkOp] = Set(
    subdomains.domainA.SubdomainOpInstance1,
    subdomains.domainA.SubdomainOpInstance2,
    subdomains.domainA.SubdomainOpInstance3,
    subdomains.domainA.SubdomainOpInstance4,
    subdomains.domainB.SubdomainOpInstance5,
    subdomains.domainB.SubdomainOpInstance6,
    subdomains.domainB.SubdomainOpInstance7,
    subdomains.domainB.SubdomainOpInstance8
  )
}
