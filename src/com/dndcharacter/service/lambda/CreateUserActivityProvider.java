package com.dndcharacter.service.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.dndcharacter.service.activity.CreateUserActivity;
import com.dndcharacter.service.dependency.DaggerServiceComponent;
import com.dndcharacter.service.models.requests.CreateUserRequest;
import com.dndcharacter.service.models.results.CreateUserResult;

public class CreateUserActivityProvider implements RequestHandler<CreateUserRequest, CreateUserResult> {
    public CreateUserActivityProvider() {
    }

    @Override
    public CreateUserResult handleRequest(CreateUserRequest input, Context context) {
        CreateUserActivity activity = DaggerServiceComponent.create().provideCreateUserActivity();

        return activity.handleRequest(input, context);
    }
}
