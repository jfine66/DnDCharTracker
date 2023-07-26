package com.dndcharacter.service.models.requests;

import java.util.Objects;

public class GetUserRequest {
    private String userName;
    private String password;

    public GetUserRequest() {
    }

    public GetUserRequest(Builder builder) {
        this.userName = builder.name;
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

    //******************** Override Methods *********************************
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        GetUserRequest that = (GetUserRequest) obj;
        return Objects.equals(userName, that.userName) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password);
    }

    @Override
    public String toString() {
        return "GetUserRequest{" +
                "name=" + userName + '\'' + "}";
    }

    // ********************** Builder ************************

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String name;
        private String password;

        private Builder() {

        }

        public Builder withUserName(String nameToUse) {
            this.name = nameToUse;
            return this;
        }

        public Builder withPassWord(String passWord){
            this.password = passWord;
            return this;
        }

        public GetUserRequest build() {
            return new GetUserRequest(this);
        }
    }
}
