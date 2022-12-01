package com.nt.mobile.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Asset {
    @Id
    private String assetId;
    private String serialNumber;
    private String type;
    private String os;
    private String allocatedDate;
    private String expiryDate;
    private String owner;
    private boolean isClientOwned;
    private String allocatedTo;

    public Asset(String assetId,
                  String serialNumber,
                  String type,
                  String os,
                  String allocatedDate,
                  String expiryDate,
                  String owner,
                  boolean isClientOwned,
                  String allocatedTo) {
        this.assetId = assetId;
        this.serialNumber = serialNumber;
        this.type = type;
        this.os = os;
        this.allocatedDate = allocatedDate;
        this.expiryDate = expiryDate;
        this.owner = owner;
        this.isClientOwned = isClientOwned;
        this.allocatedTo = allocatedTo;
    }
}
