package com.dndcharacter.service.models.results;

import com.dndcharacter.service.models.UserModel;

public class GetUserResult {
    private UserModel user;

    public GetUserResult(Builder builder) {
        this.user = builder.userModel;
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
        private UserModel userModel;

        public Builder withUser(UserModel userModel) {
            this.userModel = userModel;
            return this;
        }

        public GetUserResult build() {
            return new GetUserResult(this);
        }
    }
}
