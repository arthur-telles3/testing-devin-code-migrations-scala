package subdomains.utils

import org.apache.spark.sql.DataFrame

trait SubdomainOp {
  def name: String
  def query(inputs: Map[String, DataFrame]): DataFrame
  def metadata: Metadata
  def runConfigurations: RunConfigurations
  def inputs: Set[String]
}

case class Metadata()

case class RunConfigurations()
