package com.example.CMPE275;

import com.example.grpc.WeatherService;
import io.grpc.*;
import com.example.reader.Reader;
import java.util.concurrent.Executors;

public class Server
{
    public static void main( String[] args ) throws Exception
    {
        // Create a new server to listen on port 8080

        io.grpc.Server server = ServerBuilder.forPort(Integer.parseInt(args[0])).executor(Executors.newFixedThreadPool(8))
                .addService(new WeatherService(Integer.parseInt(args[0])))

                .build();

        // Start the server
        server.start();
        Reader reader = new Reader();
        String[] args1 = {args[0]};
        reader.readFile(args1);



        server.awaitTermination();
    }


}
