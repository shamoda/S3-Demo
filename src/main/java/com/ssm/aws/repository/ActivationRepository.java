package com.ssm.aws.repository;

import com.ssm.aws.model.Activation;
import com.ssm.aws.model.ActivationID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivationRepository extends JpaRepository<Activation, ActivationID> {

}
