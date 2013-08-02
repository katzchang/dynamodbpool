package dynamodbpool;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import org.apache.commons.pool.impl.SoftReferenceObjectPool;

public class DynamoDBPool extends SoftReferenceObjectPool<AmazonDynamoDBClient> {
    public DynamoDBPool(AWSCredentialsProvider awsCredentialsProvider, Region region) {
        super(new DynamoDBClientFactory(awsCredentialsProvider, region));
    }
}
