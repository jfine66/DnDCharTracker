package com.dndcharacter.service.converters;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.dndcharacter.service.dynamodb.models.DnDCharacter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class CharacterConverter implements DynamoDBTypeConverter<String, List> {
    private static final Gson GSON = new Gson();


    @Override
    public String convert(List object) {
        return GSON.toJson(object);
    }

    @Override
    public List unconvert(String object) {
        return GSON.fromJson(object, new TypeToken<List<DnDCharacter>>() { } .getType());
    }
}