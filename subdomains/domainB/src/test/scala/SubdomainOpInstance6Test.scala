package subdomains.domainB

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import subdomains.utils.{SubdomainOp, Metadata, RunConfigurations}
import org.apache.spark.sql.SparkSession

class SubdomainOpInstance6Test extends AnyFlatSpec with Matchers {
  "SubdomainOpInstance6" should "have the correct name" in {
    val instance = new SubdomainOpInstance6()
    instance.name should be("SubdomainOpInstance6")
  }

  it should "return an empty DataFrame on query" in {
    val sparkSession = SparkSession.builder().master("local").appName("SubdomainOpInstance6Test").getOrCreate()
    val instance = new SubdomainOpInstance6()
    val result = instance.query(Map.empty[String, org.apache.spark.sql.DataFrame])
    result should be(sparkSession.emptyDataFrame)
    sparkSession.stop()
  }

  it should "have a valid metadata and runConfigurations" in {
    val instance = new SubdomainOpInstance6()
    instance.metadata shouldBe a[Metadata]
    instance.runConfigurations shouldBe a[RunConfigurations]
  }
}
