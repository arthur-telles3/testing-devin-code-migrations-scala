package subdomains.app

import subdomains.utils.SubdomainOp
import subdomains.domainA._
import subdomains.domainB._
import subdomains.domainC._
import subdomains.domainD._
import subdomains.domainE._
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.SparkSession
import platform.common_classes.Input

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
    SubdomainOpInstance8,
    // Instances from domain C
    SubdomainOpInstance9,
    SubdomainOpInstance10,
    SubdomainOpInstance11,
    SubdomainOpInstance12,
    // Instances from domain D
    SubdomainOpInstance13,
    SubdomainOpInstance14,
    SubdomainOpInstance15,
    SubdomainOpInstance16,
    // Instances from domain E
    SubdomainOpInstance17,
    SubdomainOpInstance18,
    SubdomainOpInstance19,
    SubdomainOpInstance20
    // ... any other migrated SubdomainOp instances
  )
}
