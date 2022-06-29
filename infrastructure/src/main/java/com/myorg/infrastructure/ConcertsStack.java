package com.myorg.infrastructure;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ec2.InstanceClass;
import software.amazon.awscdk.services.ec2.InstanceSize;
import software.amazon.awscdk.services.ec2.InstanceType;
import software.amazon.awscdk.services.ecs.AddCapacityOptions;
import software.amazon.awscdk.services.ecs.Cluster;
import software.constructs.Construct;

public class ConcertsStack extends Stack {
    public ConcertsStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public ConcertsStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        Cluster.Builder.create(this, "ConcertsServiceCluster")
                .capacity(
                        AddCapacityOptions.builder()
                                .instanceType(
                                        InstanceType.of(
                                                InstanceClass.BURSTABLE2, InstanceSize.MICRO))
                                .desiredCapacity(1)
                                .build())
                .build();
    }
}
