package com.example.loadBalancing;

import io.grpc.Attributes;
import io.grpc.EquivalentAddressGroup;
import io.grpc.NameResolver;


import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LoadBalancerClient extends NameResolver.Factory {

    final List<EquivalentAddressGroup> addresses;

    public LoadBalancerClient(SocketAddress... addresses) {
        this.addresses = Arrays.stream(addresses)
                .map(EquivalentAddressGroup::new)
                .collect(Collectors.toList());
    }

    public NameResolver newNameResolver(URI notUsedUri, NameResolver.Args args) {
        return new NameResolver() {
            @Override
            public String getServiceAuthority() {
                return "fakeAuthority";
            }
            public void start(Listener2 listener) {
                listener.onResult(ResolutionResult.newBuilder().setAddresses(addresses).setAttributes(Attributes.EMPTY).build());
            }
            public void shutdown() {
            }
        };
    }

    @Override
    public String getDefaultScheme() {
        return "multiaddress";
    }
}