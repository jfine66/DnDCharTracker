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
public final class GetUserActivity_Factory implements Factory<GetUserActivity> {
  private final Provider<UserDao> userDaoProvider;

  public GetUserActivity_Factory(Provider<UserDao> userDaoProvider) {
    this.userDaoProvider = userDaoProvider;
  }

  @Override
  public GetUserActivity get() {
    return newInstance(userDaoProvider.get());
  }

  public static GetUserActivity_Factory create(Provider<UserDao> userDaoProvider) {
    return new GetUserActivity_Factory(userDaoProvider);
  }

  public static GetUserActivity newInstance(UserDao userDao) {
    return new GetUserActivity(userDao);
  }
}
