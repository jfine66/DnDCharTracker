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
public final class CreateCharacterActivity_Factory implements Factory<CreateCharacterActivity> {
  private final Provider<UserDao> userDaoProvider;

  public CreateCharacterActivity_Factory(Provider<UserDao> userDaoProvider) {
    this.userDaoProvider = userDaoProvider;
  }

  @Override
  public CreateCharacterActivity get() {
    return newInstance(userDaoProvider.get());
  }

  public static CreateCharacterActivity_Factory create(Provider<UserDao> userDaoProvider) {
    return new CreateCharacterActivity_Factory(userDaoProvider);
  }

  public static CreateCharacterActivity newInstance(UserDao userDao) {
    return new CreateCharacterActivity(userDao);
  }
}
