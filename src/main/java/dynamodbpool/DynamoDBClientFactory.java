package dynamodbpool;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import org.apache.commons.pool.PoolableObjectFactory;

public class DynamoDBClientFactory implements PoolableObjectFactory<AmazonDynamoDBClient> {
    private final AWSCredentialsProvider awsCredentialsProvider;
    private final Region region;

    public DynamoDBClientFactory(AWSCredentialsProvider awsCredentialsProvider, Region region) {
        this.awsCredentialsProvider = awsCredentialsProvider;
        this.region = region;
    }

    @Override
    public AmazonDynamoDBClient makeObject() {
        AmazonDynamoDBClient amazonDynamoDBClient = new AmazonDynamoDBClient(awsCredentialsProvider);
        amazonDynamoDBClient.setRegion(region);
        return amazonDynamoDBClient;
    }

    @Override
    public void destroyObject(AmazonDynamoDBClient amazonDynamoDBClient) {
        amazonDynamoDBClient.shutdown();
    }

    @Override
    public boolean validateObject(AmazonDynamoDBClient amazonDynamoDBClient) {
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void activateObject(AmazonDynamoDBClient amazonDynamoDBClient) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void passivateObject(AmazonDynamoDBClient amazonDynamoDBClient) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}

/*
class DynamoDBClientPoolFactory(val awsCredentialsProvider: AWSCredentialsProvider, val region: Region) extends PoolableObjectFactory[AmazonDynamoDBClient] {

        def makeObject: AmazonDynamoDBClient = {
        val dynamoDB = new AmazonDynamoDBClient(awsCredentialsProvider)
        dynamoDB.setRegion(region)
        dynamoDB
        }

        def destroyObject(o: AmazonDynamoDBClient): Unit = {o.shutdown()}

        def validateObject(o: AmazonDynamoDBClient): Boolean = {true}

        def activateObject(o: AmazonDynamoDBClient): Unit = {}

        def passivateObject(o: AmazonDynamoDBClient): Unit = {}
        }
*/