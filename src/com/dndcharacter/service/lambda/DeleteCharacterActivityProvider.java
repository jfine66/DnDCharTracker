package com.dndcharacter.service.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.dndcharacter.service.dependency.DaggerServiceComponent;
import com.dndcharacter.service.models.requests.DeleteCharacterRequest;
import com.dndcharacter.service.models.results.DeleteCharacterResult;

public class DeleteCharacterActivityProvider implements RequestHandler<DeleteCharacterRequest, DeleteCharacterResult> {
    public DeleteCharacterActivityProvider() {
    }

    @Override
    public DeleteCharacterResult handleRequest(DeleteCharacterRequest input, Context context) {
        var activity = DaggerServiceComponent.create().provideDeleteCharacterActivity();

        return activity.handleRequest(input, context);
    }
}
