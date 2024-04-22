package subdomains.domainA

import org.apache.spark.sql.{DataFrame, SparkSession}
import platform.common_classes.SubdomainOp
import subdomains.utils.{Metadata, RunConfigurations}

object SubdomainOpInstance1 extends SubdomainOp {
  val hardcodedValue: Int = 7345 // Previously randomValue

  override def name: String = "SubdomainOpInstance1"
  override def inputs: Set[String] = Set() // No inputs, making it a root
  override def query(inputs: Map[String, DataFrame]): DataFrame = {
    // Direct reference to SparkOpInstance20 removed
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
