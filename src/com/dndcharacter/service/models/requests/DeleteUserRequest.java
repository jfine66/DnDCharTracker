package com.dndcharacter.service.models.requests;

import java.util.Objects;

public class DeleteUserRequest {
    private String userName;
    private String password;

    public DeleteUserRequest() {
    }

    public DeleteUserRequest(Builder builder) {
        this.userName = builder.userName;
        this.password = builder.password;
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

    // ********************************* Override Methods *****************************************
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != getClass()) return false;
        var that = (DeleteUserRequest) obj;

        return Objects.equals(userName, that.userName) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password);
    }
    // ********************************* Builder *****************************************

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String userName;
        private String password;

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

        public DeleteUserRequest build() {
            return new DeleteUserRequest(this);
        }

    }

}
