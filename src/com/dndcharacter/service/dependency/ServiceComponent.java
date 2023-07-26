package com.dndcharacter.service.dependency;

import com.dndcharacter.service.activity.*;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = DaoModule.class)
public interface ServiceComponent {
    GetUserActivity provideGetUserActivity();
    CreateUserActivity provideCreateUserActivity();
    DeleteUserActivity provideDeleteUserActivity();
    CreateCharacterActivity provideCreateCharacterActivity();
    UpdateCharacterActivity provideUpdateCharacterActivity();
    DeleteCharacterActivity provideDeleteCharacterActivity();
}
