package com.dndcharacter.service.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.dndcharacter.service.dependency.DaggerServiceComponent;
import com.dndcharacter.service.models.requests.UpdateCharacterRequest;
import com.dndcharacter.service.models.results.UpdateCharacterResult;

public class UpdateCharacterActivityProvider implements RequestHandler<UpdateCharacterRequest, UpdateCharacterResult> {
    public UpdateCharacterActivityProvider() {
    }

    @Override
    public UpdateCharacterResult handleRequest(UpdateCharacterRequest input, Context context) {
        var activity = DaggerServiceComponent.create().provideUpdateCharacterActivity();

        return activity.handleRequest(input, context);
    }
}
