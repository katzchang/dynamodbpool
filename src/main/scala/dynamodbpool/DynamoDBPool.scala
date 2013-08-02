package dynamodbpool

import org.apache.commons.pool.PoolableObjectFactory
import org.apache.commons.pool.impl.SoftReferenceObjectPool
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient
import com.amazonaws.auth.{AWSCredentialsProvider, ClasspathPropertiesFileCredentialsProvider}
import com.amazonaws.regions.{Regions, Region}

class DynamoDBPool(val factory: PoolableObjectFactory[AmazonDynamoDBClient]) extends SoftReferenceObjectPool[AmazonDynamoDBClient](factory) {
  def this(awsCredentialsProvider: AWSCredentialsProvider, region: Region) =
    this(new DynamoDBClientPoolFactory(awsCredentialsProvider, region))
}

