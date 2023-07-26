package com.dndcharacter.service.models.results;

import com.dndcharacter.service.models.UserModel;

public class DeleteUserResult {
    private UserModel user;

    public DeleteUserResult(Builder builder) {
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

        public DeleteUserResult build() {
            return new DeleteUserResult(this);
        }
    }
}
