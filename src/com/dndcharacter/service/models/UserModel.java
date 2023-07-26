package com.dndcharacter.service.models;

import com.dndcharacter.service.dynamodb.models.DnDCharacter;

import java.util.List;
import java.util.Objects;

public class UserModel {
    private String userName;
    private Integer passwordHashed;
    private List<DnDCharacter> characters;

    public UserModel() {
    }

    public UserModel(Builder builder){
        this.userName = builder.userName;
        this.passwordHashed = builder.passwordHashed;
        this.characters = builder.characters;
    }

    //*************  Getter and Setters *************************************

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<DnDCharacter> getCharacters() {
        return characters;
    }

    public void setCharacters(List<DnDCharacter> characters) {
        this.characters = characters;
    }

    public Integer getPasswordHashed() {
        return passwordHashed;
    }

    public void setPasswordHashed(Integer passwordHashed) {
        this.passwordHashed = passwordHashed;
    }

    // ********************* Override Methods ***********************
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        UserModel that = (UserModel) obj;

        return Objects.equals(userName, that.userName) && Objects.equals(characters, that.characters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, characters);
    }

    // *********************** Builder ******************************
    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String userName;
        private Integer passwordHashed;
        private List<DnDCharacter> characters;

        public Builder withUserName(String name) {
            this.userName = name;
            return this;
        }

        public Builder withPassword(Integer password) {
            this.passwordHashed = password;
            return this;
        }

        public Builder withCharacters(List<DnDCharacter> list) {
            this.characters = list;
            return this;
        }

        public UserModel build() {
            return new UserModel(this);
        }
    }
}