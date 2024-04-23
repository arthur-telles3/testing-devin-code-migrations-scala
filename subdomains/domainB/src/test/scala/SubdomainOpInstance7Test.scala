package subdomains.domainB

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import subdomains.utils.{SubdomainOp, Metadata, RunConfigurations}
import org.apache.spark.sql.SparkSession
import subdomains.domainB.SubdomainOpInstance7

class SubdomainOpInstance7Test extends AnyFlatSpec with Matchers {
  "SubdomainOpInstance7" should "have the correct name" in {
    val instance = new SubdomainOpInstance7()
    instance.name should be("SubdomainOpInstance7")
  }

  it should "return an empty DataFrame on query" in {
    val sparkSession = SparkSession.builder().master("local").appName("SubdomainOpInstance7Test").getOrCreate()
    val instance = new SubdomainOpInstance7()
    val result = instance.query(Map.empty[String, org.apache.spark.sql.DataFrame])
    result should be(sparkSession.emptyDataFrame)
    sparkSession.stop()
  }

  it should "have a valid metadata and runConfigurations" in {
    val instance = new SubdomainOpInstance7()
    instance.metadata shouldBe a[Metadata]
    instance.runConfigurations shouldBe a[RunConfigurations]
  }
}
