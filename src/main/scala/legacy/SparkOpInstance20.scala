package legacy
import org.apache.spark.sql.SparkSession

import platform.common_classes.SparkOp
import org.apache.spark.sql.DataFrame
import platform.common_classes.Metadata
import platform.common_classes.RunConfigurations
import subdomains.utils.SharedRandomValues

object SparkOpInstance20 extends SparkOp {
  val randomValue: Int = SharedRandomValues.randomValue20

  override def name: String = "dataset/spark-op-instance-20"
  override def inputs: Set[String] = Set(SharedRandomValues.randomValue19.toString) // Updated to use shared random value as a placeholder for input name
  override def query(inputs: Map[String, DataFrame]): DataFrame = {
    SparkSession.builder().getOrCreate().emptyDataFrame
  }
  override def metadata: Metadata = {
    new Metadata()
  }
  override def runConfigurations: RunConfigurations = {
    new RunConfigurations()
  }
}
