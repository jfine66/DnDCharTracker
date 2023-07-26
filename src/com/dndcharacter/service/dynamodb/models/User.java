package com.dndcharacter.service.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.dndcharacter.service.converters.CharacterConverter;

import java.util.List;
@DynamoDBTable(tableName = "DnDCharTracker")
public class User {
    private String userName;
    private Integer passwordHashed;
    private List<DnDCharacter> characters;

    @DynamoDBHashKey(attributeName = "UserName")
    public String getName() {
        return userName;
    }

    public void setName(String name) {
        this.userName = name;
    }

    @DynamoDBRangeKey(attributeName = "hashPass")
    public Integer getPasswordHashed() {
        return passwordHashed;
    }

    public void setPasswordHashed(Integer passwordHashed) {
        this.passwordHashed = passwordHashed;
    }

    @DynamoDBTypeConverted(converter = CharacterConverter.class)
    @DynamoDBAttribute(attributeName = "Characters")
    public List<DnDCharacter> getCharacters() {
        return characters;
    }

    public void setCharacters(List<DnDCharacter> characters) {
        this.characters = characters;
    }
}
