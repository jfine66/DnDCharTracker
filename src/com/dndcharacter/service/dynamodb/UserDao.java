package com.dndcharacter.service.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.dndcharacter.service.dynamodb.models.User;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserDao {
    private final DynamoDBMapper dynamoDBMapper;

    @Inject
    public UserDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public User getUser(String userName, Integer password) {
        return this.dynamoDBMapper.load(User.class, userName, password);
    }

    public void save(User user) {
        dynamoDBMapper.save(user);
    }

    public void delete(User user) {
        dynamoDBMapper.delete(user);
    }
}
