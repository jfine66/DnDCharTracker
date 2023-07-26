package com.dndcharacter.service.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.dndcharacter.service.converters.ModelConverter;
import com.dndcharacter.service.dynamodb.UserDao;
import com.dndcharacter.service.dynamodb.models.DnDCharacter;
import com.dndcharacter.service.dynamodb.models.User;
import com.dndcharacter.service.models.UserModel;
import com.dndcharacter.service.models.requests.DeleteCharacterRequest;
import com.dndcharacter.service.models.results.DeleteCharacterResult;

import javax.inject.Inject;

public class DeleteCharacterActivity implements RequestHandler<DeleteCharacterRequest, DeleteCharacterResult> {
    private final UserDao userDao;

    @Inject
    public DeleteCharacterActivity(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public DeleteCharacterResult handleRequest(DeleteCharacterRequest input, Context context) {
        User user = userDao.getUser(input.getUserName(), input.getPassword().hashCode());
        DnDCharacter character = input.getCharacter();
        int index = user.getCharacters().indexOf(character);

        if (index == -1) {
            throw new RuntimeException("Character not found");
        }

        user.getCharacters().remove(index);

        userDao.save(user);

        UserModel userModel = new ModelConverter().toUserModel(user);

        return DeleteCharacterResult.builder().withUser(userModel).build();
    }
}
