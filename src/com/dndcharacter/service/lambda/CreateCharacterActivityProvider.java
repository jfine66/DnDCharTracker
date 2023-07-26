package com.dndcharacter.service.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.dndcharacter.service.activity.CreateCharacterActivity;
import com.dndcharacter.service.dependency.DaggerServiceComponent;
import com.dndcharacter.service.models.requests.CreateCharacterRequest;
import com.dndcharacter.service.models.results.CreateCharacterResult;


public class CreateCharacterActivityProvider implements RequestHandler<CreateCharacterRequest, CreateCharacterResult> {
    public CreateCharacterActivityProvider() {
    }

    @Override
    public CreateCharacterResult handleRequest(CreateCharacterRequest input, Context context) {
        CreateCharacterActivity activity = DaggerServiceComponent.create().provideCreateCharacterActivity();

        return activity.handleRequest(input, context);
    }
}
