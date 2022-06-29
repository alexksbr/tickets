package com.myorg.infrastructure;

import software.amazon.awscdk.App;

public class TicketsApp {
    public static void main(final String[] args) {
        App app = new App();

        new ConcertsStack(app, "ConcertsStack");

        app.synth();
    }
}