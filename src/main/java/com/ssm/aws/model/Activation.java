package com.ssm.aws.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.math.BigInteger;
import java.util.Date;

@Entity
@IdClass(ActivationID.class)
public class Activation {

    @Id
    private BigInteger accountId;
    @Id
    private String regionId;
    private String activationId;
    private String activationCode;
    private boolean prod;
    private boolean sre;
    private Date lastModified;

    public Activation() {
    }

    public Activation(BigInteger accountId, String regionId, String activationId, String activationCode, boolean prod, boolean sre, Date lastModified) {
        this.accountId = accountId;
        this.regionId = regionId;
        this.activationId = activationId;
        this.activationCode = activationCode;
        this.prod = prod;
        this.sre = sre;
        this.lastModified = lastModified;
    }

    public BigInteger getAccountId() {
        return accountId;
    }

    public void setAccountId(BigInteger accountId) {
        this.accountId = accountId;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getActivationId() {
        return activationId;
    }

    public void setActivationId(String activationId) {
        this.activationId = activationId;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public boolean isProd() {
        return prod;
    }

    public void setProd(boolean prod) {
        this.prod = prod;
    }

    public boolean isSre() {
        return sre;
    }

    public void setSre(boolean sre) {
        this.sre = sre;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public String toString() {
        return "Activation{" +
                "accountId=" + accountId +
                ", regionId='" + regionId + '\'' +
                ", activationId='" + activationId + '\'' +
                ", activationCode='" + activationCode + '\'' +
                ", prod=" + prod +
                ", sre=" + sre +
                ", lastModified=" + lastModified +
                '}';
    }
}
