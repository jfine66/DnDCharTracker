package com.dndcharacter.service.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.dndcharacter.service.dependency.DaggerServiceComponent;
import com.dndcharacter.service.models.requests.GetUserRequest;
import com.dndcharacter.service.models.results.GetUserResult;

public class GetUserActivityProvider implements RequestHandler<GetUserRequest, GetUserResult> {
    public GetUserActivityProvider() {
    }

    @Override
    public GetUserResult handleRequest(GetUserRequest input, Context context) {
        var activity = DaggerServiceComponent.create().provideGetUserActivity();

        return activity.handleRequest(input, context);
    }
}
