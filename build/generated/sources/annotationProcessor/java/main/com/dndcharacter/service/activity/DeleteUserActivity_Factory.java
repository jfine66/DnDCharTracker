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
public final class DeleteUserActivity_Factory implements Factory<DeleteUserActivity> {
  private final Provider<UserDao> userDaoProvider;

  public DeleteUserActivity_Factory(Provider<UserDao> userDaoProvider) {
    this.userDaoProvider = userDaoProvider;
  }

  @Override
  public DeleteUserActivity get() {
    return newInstance(userDaoProvider.get());
  }

  public static DeleteUserActivity_Factory create(Provider<UserDao> userDaoProvider) {
    return new DeleteUserActivity_Factory(userDaoProvider);
  }

  public static DeleteUserActivity newInstance(UserDao userDao) {
    return new DeleteUserActivity(userDao);
  }
}
