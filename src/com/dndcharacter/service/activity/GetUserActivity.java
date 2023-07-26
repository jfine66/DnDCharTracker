package com.dndcharacter.service.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.dndcharacter.service.converters.ModelConverter;
import com.dndcharacter.service.dynamodb.UserDao;
import com.dndcharacter.service.dynamodb.models.User;
import com.dndcharacter.service.models.UserModel;
import com.dndcharacter.service.models.requests.GetUserRequest;
import com.dndcharacter.service.models.results.GetUserResult;

import javax.inject.Inject;

public class GetUserActivity implements RequestHandler<GetUserRequest, GetUserResult> {
    private final UserDao userDao;

    @Inject
    public GetUserActivity(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public GetUserResult handleRequest(GetUserRequest input, Context context) {
        User user = userDao.getUser(input.getUserName(), input.getPassword().hashCode());

        if (user == null) {
            throw new RuntimeException("Could not find user with name" + input.getUserName());
        }

        UserModel userModel = new ModelConverter().toUserModel(user);

        return GetUserResult.builder().withUser(userModel).build();
    }
}
