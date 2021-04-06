package com.ssm.aws;

import com.ssm.aws.model.Activation;
import com.ssm.aws.repository.ActivationRepository;
import com.ssm.aws.service.ActivationService;
import com.ssm.aws.util.ActivationUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class AwsApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(AwsApplication.class, args);

//		String bucketName = "shamoda-aws-s3-bucket-01";
//		String key = "activation.csv";
//
//		Region region = Region.US_EAST_1;
//		S3Client s3 = S3Client.builder()
//				.region(region)
//				.build();
//
//		GetObjectRequest getObjectRequest = GetObjectRequest.builder()
//				.bucket(bucketName)
//				.key(key)
//				.build();
//
//		ResponseInputStream obj = s3.getObject(getObjectRequest);
//
//		List<Activation> activations = ActivationUtil.getEntries(obj);

//		System.out.println(activations);

//		ActivationService service = new ActivationService()

//		BufferedReader reader = new BufferedReader(new InputStreamReader(obj));
//		while (true) {
//			String line = reader.readLine();
//			if (line == null) break;
//			System.out.println(" " + line);
//		}


	}

}
