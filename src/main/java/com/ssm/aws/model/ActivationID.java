package com.ssm.aws.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

public class ActivationID implements Serializable {

    private BigInteger accountId;
    private String regionId;

    public ActivationID() {
    }

    public ActivationID(BigInteger accountId, String regionId) {
        this.accountId = accountId;
        this.regionId = regionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ActivationID)) return false;
        ActivationID that = (ActivationID) o;
        return accountId.equals(that.accountId) && regionId.equals(that.regionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, regionId);
    }
}
