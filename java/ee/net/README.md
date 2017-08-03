# Java Networking

## Identity a machine

### Domain name

+ viktorvlasov.ru

### IP address

+ 127.0.1.1

### [Java Example](examples/WhoAmI.groovy)

## Servers and Clients

### Server is request receiver
### Client is request initiator

## Port

+ One machine can have many services
+ For making request to specific server you 
    need to know what port it listen

## Socket

+ Socket is abstraction to represent data transfer 
    channel between two points
+ Java use Stream API for working with sockets data
+ Server is ServerSocket java class object
    + [Example](examples/SampleServer.groovy)
+ Client is Socket java class object
