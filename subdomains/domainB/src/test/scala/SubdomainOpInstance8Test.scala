package subdomains.domainB

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import subdomains.utils.{SubdomainOp, Metadata, RunConfigurations}
import org.apache.spark.sql.SparkSession
import subdomains.domainB.SubdomainOpInstance8

class SubdomainOpInstance8Test extends AnyFlatSpec with Matchers {
  "SubdomainOpInstance8" should "have the correct name" in {
    SubdomainOpInstance8.name should be("SubdomainOpInstance8")
  }

  it should "return an empty DataFrame on query" in {
    val sparkSession = SparkSession.builder().master("local").appName("SubdomainOpInstance8Test").getOrCreate()
    val result = SubdomainOpInstance8.query(Map.empty[String, org.apache.spark.sql.DataFrame])
    result should be(sparkSession.emptyDataFrame)
    sparkSession.stop()
  }

  it should "have a valid metadata and runConfigurations" in {
    SubdomainOpInstance8.metadata shouldBe a[Metadata]
    SubdomainOpInstance8.runConfigurations shouldBe a[RunConfigurations]
  }
}
