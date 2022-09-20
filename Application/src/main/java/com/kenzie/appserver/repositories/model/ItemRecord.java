package com.kenzie.appserver.repositories.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.kenzie.appserver.service.model.Item;

import java.util.Objects;

// TODO: change DynamoDB table name
@DynamoDBTable(tableName = "Example")
public class ItemRecord {

    private String id;
    private String genericName;
    private String brandName;
    private String weight;
    private String expirationDate;
    private int fillLevel;
    private String location;

    // blank constructor for tests. May remove this later as we continue to refactor, to me it makes sense for
    // the constructor to take in an Item and set all the values that way, rather than doing a blank record
    // and setting values manually
    public ItemRecord() {
        this.id = "";
        this.genericName = "";
        this.brandName = "";
        this.weight = "";
        this.expirationDate = "";
        this.fillLevel = 0;
        this.location = "";
    }

    public ItemRecord (Item item) {
        this.id = item.getId();
        this.genericName = item.getGenericName();
        this.brandName = item.getBrandName();
        this.weight = item.getWeight();
        this.expirationDate = item.getExpirationDate();
        this.fillLevel = item.getFillLevel();
        this.location = item.getLocation();
    }

    @DynamoDBHashKey(attributeName = "Id")
    public String getId() {
        return id;
    }

    @DynamoDBAttribute(attributeName = "GenericName")
    public String getGenericName() {
        return genericName;
    }

    @DynamoDBAttribute(attributeName = "BrandName")
    public String getBrandName() {
        return brandName;
    }

    @DynamoDBAttribute(attributeName = "Weight")
    public String getWeight() {
        return weight;
    }

    @DynamoDBAttribute(attributeName = "ExpirationDate")
    public String getExpirationDate() {
        return expirationDate;
    }

    @DynamoDBAttribute(attributeName = "FillLevel")
    public int getFillLevel() {
        return fillLevel;
    }

    @DynamoDBAttribute(attributeName = "Location")
    public String getLocation() {
        return location;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setFillLevel(int fillLevel) {
        if (fillLevel > 100 || fillLevel < 0) {
            throw new IllegalArgumentException("Fill level cannot be greater than 100 or less than 0!");
        } else {
            this.fillLevel = fillLevel;
        }
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ItemRecord itemRecord = (ItemRecord) o;
        return Objects.equals(id, itemRecord.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}