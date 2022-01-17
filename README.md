# gRPC vs REST- Why milliseconds matter?
### Introduction 
REST is a popular resource-based technique using GET, POST, PUT DELETE methods. Resources are data 
entities on which you perform actions, like the GET, POST, PUT and DELETE methods. REST’s communication 
often includes sending a JSON and can run over HTTP/1.1 or HTTP/2 

gRPC is an open-source RPC framework that is created and used by Google. It is built upon HTTP/2.0 which 
makes bi-directional communication possible. gRPC communicates using binary data using protocol buffers by 
default for serializing structured data. gRPC servers allow cross-language unary calls or stream calls.
There are a number of differences between gRPC and REST which make it suitable in different scenarios. REST 
is more widely used because of two primary reasons. 

* REST APIs are desirable when a system needs high speed iteration and standardization of HTTP protocol 
(runs on HTTP 1.1).
* When system is highly reliant on third party tools. Since REST is more widely used it is likely that 
application integration will be easier as there is widespread support for REST.

Since gRPC is not as widely used, most third-party tools lack in built features for gRPC compatibility. Therefore, 
gRPC is mainly used to build internal systems. i.e. systems that are closed to the external world. The following 
scenarios would be ideal to use gRPC. 

* Microservices connections: Because of its low latency and high throughput connectivity, gRPC is ideal 
for linking systems made up of lightweight microservices where message transmission efficiency is 
critical.
*  Multi-language systems: gRPC is ideal for handling connections in a multilingual context since it supports 
native code generation for a broad range of programming languages.
* Real time streaming: When real-time communication is required, gRPC's ability to manage bidirectional 
streaming allows your system to send and receive messages without having to wait for Unary client response communication. 
* Low bandwidth networks: gRPC's use of serialized protobuf messages provides lightweight 
communications, increased efficiency, and speed for low-power, low bandwidth networks (especially 
when compared to JSON). The Internet of Things (IoT) is an example of a network that might benefit 
from gRPC API

### Research Document
Kingly refer to pdf document present in repo to view detailed analysis.

### Conclusion
When receiving data, gRPC is around 7 times quicker than REST, and when sending data, gRPC is roughly 10 
times faster than REST. This is mostly due to gRPC's usage of HTTP/2 and the tight packing of Protocol Buffers.
Further research is required to help understand the unusual behavior of gRPC streaming. Still, the benefits of gRPC 
outweigh its disadvantages, if so “Why hasn’t it been widely adopted?”. The answer, REST is supported 
universally and virtually every microservices-based infrastructure depends entirely on REST APIs as the glue that 
holds them together. 
It took me a lot more time to implement and understand gRPC as compared to the traditional WebAPI 
approach. This is mainly due to REST becoming mainstream a long time back, and most major frameworks having 
built in support to quickly build up such services. At present, gRPC although more beneficial should be avoided 
in large scale applications unless the use case of the application is very specific.

