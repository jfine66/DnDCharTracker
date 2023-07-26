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
public final class UpdateCharacterActivity_Factory implements Factory<UpdateCharacterActivity> {
  private final Provider<UserDao> userDaoProvider;

  public UpdateCharacterActivity_Factory(Provider<UserDao> userDaoProvider) {
    this.userDaoProvider = userDaoProvider;
  }

  @Override
  public UpdateCharacterActivity get() {
    return newInstance(userDaoProvider.get());
  }

  public static UpdateCharacterActivity_Factory create(Provider<UserDao> userDaoProvider) {
    return new UpdateCharacterActivity_Factory(userDaoProvider);
  }

  public static UpdateCharacterActivity newInstance(UserDao userDao) {
    return new UpdateCharacterActivity(userDao);
  }
}
