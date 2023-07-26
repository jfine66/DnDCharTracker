package com.dndcharacter.service.dependency;



import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class DaoModule {
    @Provides
    @Singleton
    DynamoDBMapper provideDynamoDBMapper() {
        return new DynamoDBMapper(AmazonDynamoDBClientBuilder.standard().build());
    }

}