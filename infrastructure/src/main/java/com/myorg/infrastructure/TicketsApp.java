package com.myorg.infrastructure;

import com.myorg.infrastructure.concertsstack.ConcertsStack;
import software.amazon.awscdk.App;

public class TicketsApp {
    public static void main(final String[] args) {
        App app = new App();

        new ConcertsStack(app, "ConcertsStack");

        app.synth();
    }
}
