package com.ssm.aws.service;

import com.ssm.aws.model.Activation;
import com.ssm.aws.repository.ActivationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivationService {

    private final ActivationRepository activationRepository;

    @Autowired
    public ActivationService(ActivationRepository activationRepository) {
        this.activationRepository = activationRepository;
    }

    public void saveData(List<Activation> activations) {
        activationRepository.saveAll(activations);
        System.out.println("Data inserted successfully.");
    }

}
