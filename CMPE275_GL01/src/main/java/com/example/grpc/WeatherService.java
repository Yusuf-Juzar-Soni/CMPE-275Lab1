package com.example.grpc;
import com.example.CMPE275.*;
import com.example.reader.MesonetData;
import com.example.reader.MesonetReader;
import io.grpc.stub.StreamObserver;
import java.awt.Rectangle;
import java.util.stream.Collectors;
import java.io.File;
import java.util.*;



public class WeatherService extends LargeMessageServiceGrpc.LargeMessageServiceImplBase{
    int portNumber = 8080;
    public WeatherService(){

    }
    public WeatherService(int port){
        portNumber = port;
    }
    @Override
    public void largeMessage(GreetingServiceOuterClass.HelloRequest request,
                             StreamObserver<GreetingServiceOuterClass.Responses> responseObserver) {
        System.out.println(request);
        String path = "C:\\Users\\Checkout\\Downloads\\lab-g01\\data\\0201\\CDR_Extract";
        String dataSource = null;
        File dataSourceF = null;
        if(portNumber==8080) {
            System.out.println("Service Running on port 8080");
            dataSource =path+"\\catalog.csv";
            dataSourceF = new File(path+"\\20120201_0100");
        }else if(portNumber==8081){
            System.out.println("operating on port 8081");
            dataSource =path+"\\catalog1.csv";
            dataSourceF = new File(path+"\\20120201_0100");
        }else if(portNumber==8082){
            dataSource =path+"\\catalog2.csv";
            dataSourceF = new File(path+"\\20120201_0100");
        }
        else if(portNumber==8083){
            dataSource =path+"\\catalog3.csv";
        }

        //System.out.println(request.getCity()+"Printing city on service side");




            List<GreetingServiceOuterClass.HelloResponse> superList = new ArrayList<>();

            Date startDate = null;
            Date endDate = null;
            Rectangle region = null;
            Set<String> stationIDs = new HashSet<>();
            stationIDs.add(request.getCity());
            MesonetReader rawReader = new MesonetReader();
            List<MesonetData> data = null;
            try {
                data = rawReader.extract(dataSourceF, startDate , endDate, region, stationIDs);
                System.out.println("Processed " + data.size() + " entries in WeatherService");

                for (MesonetData d : data) {
                    // TODO do something other than print!
                    System.out.println("ObservationID: " + d.getStationID() + " Temperature = " + d.getTemperature() + ", WindSpeed = "
                            + d.getWindSpeed() + ", WindDirection = " + d.getWindDir() + ", RelativeHumidity = " + d.getRelHumidity());

                    GreetingServiceOuterClass.HelloResponse resp = GreetingServiceOuterClass.HelloResponse.newBuilder().setId(d.getStationID()).setName(""+d.getTemperature()).setMesonet(d.getStationName()).build();
                    System.out.println(d.getTemperature());
                    superList.add(resp);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


            System.out.println(superList.size());
            try {
            }catch (Exception e){
                e.printStackTrace();
            }


            GreetingServiceOuterClass.Responses responses = GreetingServiceOuterClass.Responses.newBuilder().addAllResponse(superList.stream().collect(Collectors.toList())).build();

            System.out.println("Response Sent");
            responseObserver.onNext(responses);
            responseObserver.onCompleted();


    }



}
