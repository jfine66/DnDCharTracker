package com.dndcharacter.service.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.dndcharacter.service.converters.ModelConverter;
import com.dndcharacter.service.dynamodb.UserDao;
import com.dndcharacter.service.dynamodb.models.DnDCharacter;
import com.dndcharacter.service.dynamodb.models.User;
import com.dndcharacter.service.models.UserModel;
import com.dndcharacter.service.models.requests.UpdateCharacterRequest;
import com.dndcharacter.service.models.results.UpdateCharacterResult;

import javax.inject.Inject;

public class UpdateCharacterActivity implements RequestHandler<UpdateCharacterRequest, UpdateCharacterResult> {
    private final UserDao userDao;

    @Inject
    public UpdateCharacterActivity(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UpdateCharacterResult handleRequest(UpdateCharacterRequest input, Context context) {
        User user = userDao.getUser(input.getUserName(), input.getPassword().hashCode());
        DnDCharacter character = input.getCharacter();
        int index = user.getCharacters().indexOf(character);

        if (index == -1) {
            throw new RuntimeException("Could not find character");
        }

        DnDCharacter characterToChange = user.getCharacters().get(index);

        // update all stats so get them separately
        characterToChange.setName(input.getCharacterName());
        characterToChange.setClassName(input.getClassName());
        characterToChange.setRace(input.getRace());
        characterToChange.setLevel(input.getLevel());
        characterToChange.setExpPoints(input.getExpPoints());
        characterToChange.setStrStat(input.getStrStat());
        characterToChange.setDexStat(input.getDexStat());
        characterToChange.setConStat(input.getConStat());
        characterToChange.setIntStat(input.getIntStat());
        characterToChange.setWisStat(input.getWisStat());
        characterToChange.setCharStat(input.getCharStat());
        characterToChange.setProficiencyBonus(input.getProficiencyBonus());
        characterToChange.setMaxHealth(input.getMaxHealth());
        characterToChange.setCurrentHealth(input.getCurrentHealth());
        characterToChange.setAC(input.getAC());
        characterToChange.setSpeed(input.getSpeed());
        characterToChange.setHitDie(input.getHitDie());
        characterToChange.setSavingThrows(input.getSavingThrows());
        characterToChange.setSkills(input.getSkills());

        userDao.save(user);

        UserModel model = new ModelConverter().toUserModel(user);

        return UpdateCharacterResult.builder().withUser(model).build();
    }
}
