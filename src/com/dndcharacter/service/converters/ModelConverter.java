package com.dndcharacter.service.converters;

import com.dndcharacter.service.dynamodb.models.DnDCharacter;
import com.dndcharacter.service.dynamodb.models.User;
import com.dndcharacter.service.models.CharacterModel;
import com.dndcharacter.service.models.UserModel;

public class ModelConverter {
    public UserModel toUserModel(User user) {
        return UserModel.builder()
                .withUserName(user.getName())
                .withPassword(user.getPasswordHashed().hashCode())
                .withCharacters(user.getCharacters())
                .build();
    }

    public CharacterModel toCharacterModel(DnDCharacter character) {
        return CharacterModel.builder()
                .withName(character.getName())
                .withClassName(character.getClassName())
                .withRace(character.getRace())
                .withLevel(character.getLevel())
                .withExpPoints(character.getExpPoints())
                .withStrStat(character.getStrStat())
                .withDexStat(character.getDexStat())
                .withConStat(character.getConStat())
                .withIntStat(character.getIntStat())
                .withWisStat(character.getWisStat())
                .withCharStat(character.getCharStat())
                .withProficiencyBonus(character.getProficiencyBonus())
                .withMaxHealth(character.getMaxHealth())
                .withCurrentHealth(character.getCurrentHealth())
                .withAC(character.getAC())
                .withSpeed(character.getSpeed())
                .withHitDie(character.getHitDie())
                .withSavingThrows(character.getSavingThrows())
                .withSkills(character.getSavingThrows())
                .build();
    }
}