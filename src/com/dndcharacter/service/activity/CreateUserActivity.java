package com.dndcharacter.service.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.dndcharacter.service.converters.ModelConverter;
import com.dndcharacter.service.dynamodb.UserDao;
import com.dndcharacter.service.dynamodb.models.DnDCharacter;
import com.dndcharacter.service.dynamodb.models.User;
import com.dndcharacter.service.models.UserModel;
import com.dndcharacter.service.models.requests.CreateUserRequest;
import com.dndcharacter.service.models.results.CreateUserResult;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class CreateUserActivity implements RequestHandler<CreateUserRequest, CreateUserResult>{
    private final UserDao userDao;

    @Inject
    public CreateUserActivity(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public CreateUserResult handleRequest(CreateUserRequest input, Context context) {
        User user = userDao.getUser(input.getName(), input.getPassword().hashCode());

        if (user != null) {
            throw new RuntimeException("You already have an account");
        }

        User newUser = new User();
        List<DnDCharacter> characterList = new ArrayList<>();
        newUser.setName(input.getName());
        newUser.setPasswordHashed(input.getPassword().hashCode());
        newUser.setCharacters(characterList);

        UserModel userModel = new ModelConverter().toUserModel(newUser);

        userDao.save(newUser);

        return CreateUserResult.builder().withUser(userModel).build();
    }
}
