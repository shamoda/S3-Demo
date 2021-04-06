package com.ssm.aws.controller;

import com.ssm.aws.model.Activation;
import com.ssm.aws.service.ActivationService;
import com.ssm.aws.util.ActivationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;

import java.util.List;

@Controller
public class ActivationController {

    private final ActivationService service;

    @Autowired
    public ActivationController(ActivationService service) {
        this.service = service;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void readAndInsert() {
        String bucketName = "shamoda-aws-s3-bucket-01";
        String key = "activation.csv";

        Region region = Region.US_EAST_1;
        S3Client s3 = S3Client.builder()
                .region(region)
                .build();

        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();

        ResponseInputStream obj = s3.getObject(getObjectRequest);
        List<Activation> activations = ActivationUtil.getEntries(obj);

        System.out.println(activations);

        ///////////////////////////////////////////////////////////////////////////

        service.saveData(activations);

    }

}
