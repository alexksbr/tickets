package com.myorg;

import software.amazon.awscdk.App;

public class TicketsApp {
    public static void main(final String[] args) {
        App app = new App();

        ConcertsStack.Builder.create(app, "ConcertsStack").build();

        app.synth();
    }
}
