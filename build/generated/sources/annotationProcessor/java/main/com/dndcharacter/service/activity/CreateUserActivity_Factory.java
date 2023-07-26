package com.dndcharacter.service.activity;

import com.dndcharacter.service.dynamodb.UserDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class CreateUserActivity_Factory implements Factory<CreateUserActivity> {
  private final Provider<UserDao> userDaoProvider;

  public CreateUserActivity_Factory(Provider<UserDao> userDaoProvider) {
    this.userDaoProvider = userDaoProvider;
  }

  @Override
  public CreateUserActivity get() {
    return newInstance(userDaoProvider.get());
  }

  public static CreateUserActivity_Factory create(Provider<UserDao> userDaoProvider) {
    return new CreateUserActivity_Factory(userDaoProvider);
  }

  public static CreateUserActivity newInstance(UserDao userDao) {
    return new CreateUserActivity(userDao);
  }
}
