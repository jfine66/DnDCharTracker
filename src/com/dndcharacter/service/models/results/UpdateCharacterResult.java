package com.dndcharacter.service.models.results;

import com.dndcharacter.service.models.UserModel;

public class UpdateCharacterResult {
    private UserModel user;

    public UpdateCharacterResult(Builder builder){
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

        public UpdateCharacterResult build() {
            return new UpdateCharacterResult(this);
        }
    }
}
