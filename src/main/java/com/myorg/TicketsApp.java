package com.myorg;

import software.amazon.awscdk.App;
import software.amazon.awscdk.StackProps;

public class TicketsApp {
    public static void main(final String[] args) {
        App app = new App();

        new TicketsStack(app, "TicketsStack", StackProps.builder().build());

        app.synth();
    }
}
