package com.myorg.infrastructure.concertsstack;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.constructs.Construct;

public class ConcertsStack extends Stack {
    public ConcertsStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public ConcertsStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        new ConcertsServiceCluster(this, "ConcertsServiceCluster");
    }
}
