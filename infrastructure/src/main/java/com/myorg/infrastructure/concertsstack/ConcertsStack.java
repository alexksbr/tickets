package com.myorg.infrastructure.concertsstack;

import java.util.List;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ec2.InstanceClass;
import software.amazon.awscdk.services.ec2.InstanceSize;
import software.amazon.awscdk.services.ec2.InstanceType;
import software.amazon.awscdk.services.ecs.*;
import software.amazon.awscdk.services.ecs.patterns.ApplicationLoadBalancedEc2Service;
import software.constructs.Construct;

public class ConcertsStack extends Stack {
    public ConcertsStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public ConcertsStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        final Cluster cluster =
                Cluster.Builder.create(this, "ConcertsServiceCluster")
                        .capacity(
                                AddCapacityOptions.builder()
                                        .instanceType(
                                                InstanceType.of(
                                                        InstanceClass.BURSTABLE2,
                                                        InstanceSize.MICRO))
                                        .desiredCapacity(1)
                                        .build())
                        .build();

        final Ec2TaskDefinition concertsServiceTaskDefinition =
                Ec2TaskDefinition.Builder.create(this, "ConcertsServiceTaskDefinition").build();
        concertsServiceTaskDefinition.addContainer(
                "ConcertsServiceContainer",
                ContainerDefinitionOptions.builder()
                        .image(ContainerImage.fromAsset("../concerts-service"))
                        .memoryLimitMiB(512)
                        .portMappings(List.of(PortMapping.builder().containerPort(8080).build()))
                        .build());

        ApplicationLoadBalancedEc2Service.Builder.create(this, "ConcertsService")
                        .cluster(cluster)
                        .taskDefinition(concertsServiceTaskDefinition)
                        .build();
    }
}
