package subdomains.domainB

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import subdomains.utils.{SubdomainOp, Metadata, RunConfigurations}
import org.apache.spark.sql.SparkSession
import subdomains.domainB.SubdomainOpInstance6

class SubdomainOpInstance6Test extends AnyFlatSpec with Matchers {
  "SubdomainOpInstance6" should "have the correct name" in {
    SubdomainOpInstance6.name should be("subdomainB-op-instance-6")
  }

  it should "return an empty DataFrame on query" in {
    val sparkSession = SparkSession.builder().master("local").appName("SubdomainOpInstance6Test").getOrCreate()
    val result = SubdomainOpInstance6.query(Map.empty[String, org.apache.spark.sql.DataFrame])
    result should be(sparkSession.emptyDataFrame)
    sparkSession.stop()
  }

  it should "have a valid metadata and runConfigurations" in {
    SubdomainOpInstance6.metadata shouldBe a[Metadata]
    SubdomainOpInstance6.runConfigurations shouldBe a[RunConfigurations]
  }
}
