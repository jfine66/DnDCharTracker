package com.dndcharacter.service.models.requests;

import java.util.Objects;

public class CreateUserRequest {
    private String name;
    private String password;

    public CreateUserRequest() {
    }

    public CreateUserRequest(Builder builder) {
        this.name = builder.name;
        this.password = builder.password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        CreateUserRequest that = (CreateUserRequest) obj;
        return Objects.equals(name, that.name) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }

    @Override
    public String toString() {
        return "GetUserRequest{" +
                "name=" + name + '\'' + "}";
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

        public CreateUserRequest build() {
            return new CreateUserRequest(this);
        }
    }
}
