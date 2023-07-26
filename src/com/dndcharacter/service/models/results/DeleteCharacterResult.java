package com.dndcharacter.service.models.results;

import com.dndcharacter.service.models.UserModel;

public class DeleteCharacterResult {
    private UserModel user;

    public DeleteCharacterResult(Builder builder) {
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

        public DeleteCharacterResult build() {
            return new DeleteCharacterResult(this);
        }
    }
}
