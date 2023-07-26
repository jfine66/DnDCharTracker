package com.dndcharacter.service.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.dndcharacter.service.converters.ModelConverter;
import com.dndcharacter.service.dynamodb.UserDao;
import com.dndcharacter.service.dynamodb.models.DnDCharacter;
import com.dndcharacter.service.dynamodb.models.User;
import com.dndcharacter.service.models.UserModel;
import com.dndcharacter.service.models.requests.CreateCharacterRequest;
import com.dndcharacter.service.models.results.CreateCharacterResult;

import javax.inject.Inject;

public class CreateCharacterActivity implements RequestHandler<CreateCharacterRequest, CreateCharacterResult> {
    private final UserDao userDao;

    @Inject
    public CreateCharacterActivity(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public CreateCharacterResult handleRequest(CreateCharacterRequest input, Context context) {
        User user = userDao.getUser(input.getUserName(), input.getPassword().hashCode());

        if (user == null) {
            throw new RuntimeException("Can not find user");
        }

        if (user.getCharacters().size() >= 5) {
            throw new RuntimeException("Max number of characters reached");
        }

        DnDCharacter characterToAdd = new DnDCharacter();
        characterToAdd.setName(input.getCharacterName());
        characterToAdd.setClassName(input.getClassName());
        characterToAdd.setRace(input.getRace());
        characterToAdd.setLevel(1);
        characterToAdd.setExpPoints(0);
        characterToAdd.setStrStat(input.getStrStat());
        characterToAdd.setDexStat(input.getDexStat());
        characterToAdd.setConStat(input.getConStat());
        characterToAdd.setIntStat(input.getIntStat());
        characterToAdd.setWisStat(input.getWisStat());
        characterToAdd.setCharStat(input.getCharStat());
        characterToAdd.setProficiencyBonus(input.getProficiencyBonus());
        characterToAdd.setMaxHealth(input.getMaxHealth());
        characterToAdd.setCurrentHealth(input.getMaxHealth());
        characterToAdd.setAC(input.getAC());
        characterToAdd.setSpeed(input.getSpeed());
        characterToAdd.setHitDie(input.getHitDie());
        characterToAdd.setSavingThrows(input.getSavingThrows());
        characterToAdd.setSkills(input.getSkills());

        user.getCharacters().add(characterToAdd);

        userDao.save(user);

        UserModel model = new ModelConverter().toUserModel(user);

        return CreateCharacterResult.builder().withUser(model).build();
    }
}
