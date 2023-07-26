package com.dndcharacter.service.models.requests;

import com.dndcharacter.service.dynamodb.models.DnDCharacter;

import java.util.Objects;

public class DeleteCharacterRequest {
    private String userName;
    private String password;
    private DnDCharacter character;

    public DeleteCharacterRequest() {
    }

    public DeleteCharacterRequest(Builder builder) {
        this.userName = builder.userName;
        this.password = builder.password;
        this.character = builder.character;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DnDCharacter getCharacter() {
        return character;
    }

    public void setCharacter(DnDCharacter character) {
        this.character = character;
    }

    //******************** Override Methods *********************************
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DeleteCharacterRequest that = (DeleteCharacterRequest) obj;
        return Objects.equals(userName, that.userName) && Objects.equals(password, that.password) && Objects.equals(character, that.character);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password, character);
    }

    // ********************** Builder ************************
    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String userName;
        private String password;
        private DnDCharacter character;

        public Builder() {

        }

        public Builder withUserName(String name) {
            this.userName = name;
            return this;
        }

        public Builder withPassword(String pass) {
            this.password = pass;
            return this;
        }

        public Builder withCharacter(DnDCharacter character) {
            this.character = character;
            return this;
        }

        public DeleteCharacterRequest build() {
            return new DeleteCharacterRequest(this);
        }

    }


}
