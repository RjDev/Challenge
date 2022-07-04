import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

public class Test {

/**
* @param args
 * @throws JSONException 
*/
public static void main(String[] args) throws JSONException {
static AmazonEC2 ec2
  ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
		try {
			credentialsProvider.getCredentials();
		} catch (Exception e) {
			throw new AmazonClientException("Cannot load the credentials from the credential profiles file. "
					+ "Please make sure that your credentials file is at the correct ", e);
		}
		ec2 = AmazonEC2ClientBuilder.standard().withCredentials(credentialsProvider).withRegion("us-east-1").build();
  // Getting instance Id
		String instanceId = EC2MetadataUtils.getInstanceId();
		 
		// Getting EC2 private IP
		String privateIP = EC2MetadataUtils.getInstanceInfo().getPrivateIp();
		 
		// Getting EC2 public IP
		 ec2 = AmazonEC2ClientBuilder.defaultClient();
		String publicIP = ec2.describeInstances(new DescribeInstancesRequest()
		                     .withInstanceIds(instanceId))
		                        .getReservations()
		                        .stream()
		                        .map(Reservation::getInstances)
		                        .flatMap(List::stream)
		                        .findFirst()
		                        .map(Instance::getPublicIpAddress)
		                        .orElse(null);
  
  
}
  //or we can simply call the metadata service using rest api call and parse the json using json parser like i have written code in challenge 3. this question is not giving much clarity so i need to discuss this first then can come with  solution
}
