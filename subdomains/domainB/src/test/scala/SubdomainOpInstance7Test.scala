package subdomains.domainB

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import subdomains.utils.{SubdomainOp, Metadata, RunConfigurations}
import org.apache.spark.sql.SparkSession
import subdomains.domainB.SubdomainOpInstance7

class SubdomainOpInstance7Test extends AnyFlatSpec with Matchers {
  "SubdomainOpInstance7" should "have the correct name" in {
    SubdomainOpInstance7.name should be("subdomainB-op-instance-7")
  }

  it should "return an empty DataFrame on query" in {
    val sparkSession = SparkSession.builder().master("local").appName("SubdomainOpInstance7Test").getOrCreate()
    val result = SubdomainOpInstance7.query(Map.empty[String, org.apache.spark.sql.DataFrame])
    result should be(sparkSession.emptyDataFrame)
    sparkSession.stop()
  }

  it should "have a valid metadata and runConfigurations" in {
    SubdomainOpInstance7.metadata shouldBe a[Metadata]
    SubdomainOpInstance7.runConfigurations shouldBe a[RunConfigurations]
  }
}
