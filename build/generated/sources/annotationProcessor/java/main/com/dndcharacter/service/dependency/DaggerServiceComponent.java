package com.dndcharacter.service.dependency;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.dndcharacter.service.activity.CreateCharacterActivity;
import com.dndcharacter.service.activity.CreateUserActivity;
import com.dndcharacter.service.activity.DeleteCharacterActivity;
import com.dndcharacter.service.activity.DeleteUserActivity;
import com.dndcharacter.service.activity.GetUserActivity;
import com.dndcharacter.service.activity.UpdateCharacterActivity;
import com.dndcharacter.service.dynamodb.UserDao;
import com.dndcharacter.service.dynamodb.UserDao_Factory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class DaggerServiceComponent {
  private DaggerServiceComponent() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static ServiceComponent create() {
    return new Builder().build();
  }

  public static final class Builder {
    private DaoModule daoModule;

    private Builder() {
    }

    public Builder daoModule(DaoModule daoModule) {
      this.daoModule = Preconditions.checkNotNull(daoModule);
      return this;
    }

    public ServiceComponent build() {
      if (daoModule == null) {
        this.daoModule = new DaoModule();
      }
      return new ServiceComponentImpl(daoModule);
    }
  }

  private static final class ServiceComponentImpl implements ServiceComponent {
    private final ServiceComponentImpl serviceComponentImpl = this;

    private Provider<DynamoDBMapper> provideDynamoDBMapperProvider;

    private Provider<UserDao> userDaoProvider;

    private ServiceComponentImpl(DaoModule daoModuleParam) {

      initialize(daoModuleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final DaoModule daoModuleParam) {
      this.provideDynamoDBMapperProvider = DoubleCheck.provider(DaoModule_ProvideDynamoDBMapperFactory.create(daoModuleParam));
      this.userDaoProvider = DoubleCheck.provider(UserDao_Factory.create(provideDynamoDBMapperProvider));
    }

    @Override
    public GetUserActivity provideGetUserActivity() {
      return new GetUserActivity(userDaoProvider.get());
    }

    @Override
    public CreateUserActivity provideCreateUserActivity() {
      return new CreateUserActivity(userDaoProvider.get());
    }

    @Override
    public DeleteUserActivity provideDeleteUserActivity() {
      return new DeleteUserActivity(userDaoProvider.get());
    }

    @Override
    public CreateCharacterActivity provideCreateCharacterActivity() {
      return new CreateCharacterActivity(userDaoProvider.get());
    }

    @Override
    public UpdateCharacterActivity provideUpdateCharacterActivity() {
      return new UpdateCharacterActivity(userDaoProvider.get());
    }

    @Override
    public DeleteCharacterActivity provideDeleteCharacterActivity() {
      return new DeleteCharacterActivity(userDaoProvider.get());
    }
  }
}
