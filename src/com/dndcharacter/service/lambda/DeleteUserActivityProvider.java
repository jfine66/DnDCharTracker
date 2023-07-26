package com.dndcharacter.service.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.dndcharacter.service.dependency.DaggerServiceComponent;
import com.dndcharacter.service.models.requests.DeleteUserRequest;
import com.dndcharacter.service.models.results.DeleteUserResult;

public class DeleteUserActivityProvider implements RequestHandler<DeleteUserRequest, DeleteUserResult> {
    public DeleteUserActivityProvider() {
    }

    @Override
    public DeleteUserResult handleRequest(DeleteUserRequest input, Context context) {
        var activity = DaggerServiceComponent.create().provideDeleteUserActivity();

        return activity.handleRequest(input, context);
    }
}
