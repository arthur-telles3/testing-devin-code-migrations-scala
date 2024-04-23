package subdomains.domainA

import org.apache.spark.sql.{DataFrame, SparkSession}
import subdomains.utils.{SubdomainOp, Metadata, RunConfigurations}

object SubdomainOpInstance2 extends SubdomainOp {
  val hardcodedValue: Int = 1987 // Previously randomValue

  override def name: String = "subdomainA-op-instance-2"
  override def inputs: Set[String] = Set("subdomainA-op-instance-1") // Corrected reference to SubdomainOpInstance1 as an input using the updated name
  override def query(inputs: Map[String, DataFrame]): DataFrame = {
    // Direct reference to SubdomainOpInstance1 removed
    SparkSession.builder().getOrCreate().emptyDataFrame
  }
  override def metadata: Metadata = Metadata.apply() // Updated to use apply method
  override def runConfigurations: RunConfigurations = RunConfigurations.apply() // Updated to use apply method
}
