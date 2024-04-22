package legacy
import org.apache.spark.sql.SparkSession

import platform.common_classes.SparkOp
import org.apache.spark.sql.DataFrame
import platform.common_classes.Metadata
import platform.common_classes.RunConfigurations

object SparkOpInstance9 extends SparkOp {
  val randomValue: Int = 4821 // Hardcoded random value

  override def name: String = "nu-br/dataset/spark-op-instance-9"
  override def inputs: Set[String] = Set(subdomains.domainB.SubdomainOpInstanceB.name) // Updated reference to SubdomainOpInstanceB as an input using object name
  override def query(inputs: Map[String, DataFrame]): DataFrame = {
    // Using randomValue from SubdomainOpInstanceB as instructed
    val _ = subdomains.domainB.SubdomainOpInstanceB.randomValue
    SparkSession.builder().getOrCreate().emptyDataFrame
  }
  override def metadata: Metadata = {
    new Metadata()
  }
  override def runConfigurations: RunConfigurations = {
    new RunConfigurations()
  }
}
