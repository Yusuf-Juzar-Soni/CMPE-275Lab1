package com.example.CMPE275;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import io.grpc.*;
import com.google.common.util.concurrent.ListenableFuture;

import java.net.InetSocketAddress;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import com.example.loadBalancing.LoadBalancerClient;
import com.google.common.util.concurrent.MoreExecutors;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;

public class Client {

    private static AtomicLong rpcCount = new AtomicLong();
    static final Logger logger = Logger.getLogger(Client.class);

    public static void printResult(ListenableFuture<GreetingServiceOuterClass.Responses> res)  {
        try {
            System.out.println(res.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void createClient(LargeMessageServiceGrpc.LargeMessageServiceBlockingStub stub, AtomicReference<Throwable> errors, long st,int i){
        PropertyConfigurator.configure("log4j.properties");
        GreetingServiceOuterClass.HelloRequest request = GreetingServiceOuterClass.HelloRequest.newBuilder().setCity("C7959").build();
        GreetingServiceOuterClass.Responses responses = stub.largeMessage(request);
        responses.getResponseList();
        long endTime = System.currentTimeMillis();
        logger.debug("End time-Start time:="+(endTime-st)+" iteration"+i);
    }
    public static void createClient(LargeMessageServiceGrpc.LargeMessageServiceFutureStub stub,AtomicReference<Throwable> errors,long st,int i) throws InterruptedException {
        logger.debug("Welcome to the log file!");

        GreetingServiceOuterClass.HelloRequest request = GreetingServiceOuterClass.HelloRequest.newBuilder().setCity("C7959").build();
        ListenableFuture<GreetingServiceOuterClass.Responses> responses = stub.largeMessage(request);
        responses.addListener(()-> new Runnable() {
            public void run() {
                try {
                    responses.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }}, MoreExecutors.directExecutor());

        Futures.addCallback(responses, new FutureCallback<GreetingServiceOuterClass.Responses>() {
            @Override
            public void onSuccess(@NullableDecl GreetingServiceOuterClass.Responses result) {
                System.out.println("Success");
                //Configure logger
                PropertyConfigurator.configure("log4j.properties");

                if(!result.equals(GreetingServiceOuterClass.Responses.getDefaultInstance())){
                    errors.compareAndSet(null, new RuntimeException("Invalid Response"));
                }
                synchronized (result){
                    result.getResponseList();
                }
                long endTime = System.currentTimeMillis();
//
                logger.debug("End time-Start time:="+(endTime-st)+" iteration"+i);




            }


            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("Failed");
            }
        }, MoreExecutors.directExecutor());

    }

    public static void main( String[] args ) throws Exception
    {



        AtomicReference<Throwable> errors = new AtomicReference<>();
        //Load Balancing Client
        NameResolver.Factory nameResolverFactory = new LoadBalancerClient(
                //new InetSocketAddress("169.254.198.55", 8080),
                new InetSocketAddress("localhost", 8080),
                new InetSocketAddress("localhost", 8081),
                new InetSocketAddress("localhost", 8082),
                new InetSocketAddress("localhost", 8083)
        );

        ManagedChannel channel = ManagedChannelBuilder.forTarget("service")
                .nameResolverFactory(nameResolverFactory)
                .defaultLoadBalancingPolicy("round_robin")
                .usePlaintext()
                .build();

        //LargeMessageServiceGrpc.LargeMessageServiceFutureStub stub = LargeMessageServiceGrpc.newFutureStub(channel);
        LargeMessageServiceGrpc.LargeMessageServiceBlockingStub stub = LargeMessageServiceGrpc.newBlockingStub(channel);
        Instant start = Instant.now();
        long startTime = 0;
        int count = 0;
        for(int i=0;i<10;i++){
            startTime = System.currentTimeMillis();

            createClient(stub,errors, startTime,i);
            count += 1;
        }
        Instant finish = Instant.now();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);


        System.out.println("In loop  Individual"+ Duration.between(start,finish).toMillis());

            System.out.println("Final Time"+ Duration.between(start,finish).toMillis()+"=>"+ count);
            Thread.sleep(500);


    }
}
