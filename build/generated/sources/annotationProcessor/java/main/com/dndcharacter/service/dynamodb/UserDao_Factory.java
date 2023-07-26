package com.dndcharacter.service.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class UserDao_Factory implements Factory<UserDao> {
  private final Provider<DynamoDBMapper> dynamoDBMapperProvider;

  public UserDao_Factory(Provider<DynamoDBMapper> dynamoDBMapperProvider) {
    this.dynamoDBMapperProvider = dynamoDBMapperProvider;
  }

  @Override
  public UserDao get() {
    return newInstance(dynamoDBMapperProvider.get());
  }

  public static UserDao_Factory create(Provider<DynamoDBMapper> dynamoDBMapperProvider) {
    return new UserDao_Factory(dynamoDBMapperProvider);
  }

  public static UserDao newInstance(DynamoDBMapper dynamoDBMapper) {
    return new UserDao(dynamoDBMapper);
  }
}
