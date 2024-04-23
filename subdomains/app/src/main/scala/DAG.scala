package subdomains.app

import subdomains.utils.SubdomainOp
import subdomains.utils.Input
import subdomains.domainA._
import subdomains.domainB._
import subdomains.domainC._ // Added import for domain C
// import statements for domainD, and domainE are removed as their instances are not found

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.SparkSession

object DAG {
  val ops: Set[SubdomainOp] = Set(
    // Instances from domain A
    SubdomainOpInstance1,
    SubdomainOpInstance2,
    SubdomainOpInstance3,
    SubdomainOpInstance4,
    // Instances from domain B
    SubdomainOpInstance7,
    SubdomainOpInstance8,
    // Instances from domain C
    SubdomainOpInstance5, // Moved from domain B to domain C
    SubdomainOpInstance6  // Moved from domain B to domain C
    // Instances from domain D, and E are removed as they are not found
    // ... any other migrated SubdomainOp instances
  )
}
