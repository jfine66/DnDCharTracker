package com.dndcharacter.service.models.results;

import com.dndcharacter.service.models.UserModel;

public class CreateCharacterResult {
    private UserModel user;

    public CreateCharacterResult(Builder builder) {
        this.user = builder.user;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private UserModel user;

        public Builder withUser(UserModel user) {
            this.user = user;
            return this;
        }

        public CreateCharacterResult build(){
            return new CreateCharacterResult(this);
        }
    }
}
