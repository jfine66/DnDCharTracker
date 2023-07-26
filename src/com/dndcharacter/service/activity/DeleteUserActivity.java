package com.dndcharacter.service.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.dndcharacter.service.converters.ModelConverter;
import com.dndcharacter.service.dynamodb.UserDao;
import com.dndcharacter.service.dynamodb.models.User;
import com.dndcharacter.service.models.UserModel;
import com.dndcharacter.service.models.requests.DeleteUserRequest;
import com.dndcharacter.service.models.results.DeleteUserResult;

import javax.inject.Inject;

public class DeleteUserActivity implements RequestHandler<DeleteUserRequest, DeleteUserResult> {
    private final UserDao userDao;


    @Inject
    public DeleteUserActivity(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public DeleteUserResult handleRequest(DeleteUserRequest input, Context context) {
        User user = userDao.getUser(input.getUserName(), input.getPassword().hashCode());

        if (user == null) {
            throw new RuntimeException("Could not find user");
        }

        userDao.delete(user);

        UserModel userModel = new ModelConverter().toUserModel(user);

        return DeleteUserResult.builder().withUser(userModel).build();
    }
}
