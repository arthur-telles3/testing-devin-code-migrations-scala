package subdomains.domainA

import org.apache.spark.sql.{DataFrame, SparkSession}
import platform.common_classes.SubdomainOp
import subdomains.utils.{Metadata, RunConfigurations}

object SubdomainOpInstance2 extends SubdomainOp {
  val hardcodedValue: Int = 1987 // Previously randomValue

  override def name: String = "SubdomainOpInstance2"
  override def inputs: Set[String] = Set("SubdomainOpInstance1") // Reference to SubdomainOpInstance1 as an input using hardcoded name
  override def query(inputs: Map[String, DataFrame]): DataFrame = {
    // Direct reference to SubdomainOpInstance1 removed
    SparkSession.builder().getOrCreate().emptyDataFrame
  }
  override def metadata: Metadata = {
    // Mock implementation for metadata
    new Metadata()
  }
  override def runConfigurations: RunConfigurations = {
    // Mock implementation for runConfigurations
    new RunConfigurations()
  }
}
