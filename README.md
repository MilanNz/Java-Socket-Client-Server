# Java-Socket-Client-Server
Java Socket Client-Server implementation with listener and Base64 coder and decoder.



### Usage examples

#### Server side

```
  Transfer server = new SocketTransfer();
  // set server port and start server
  server.setPort(8888).startServer();
  // send message to client
  server.sendMessage("THX for connection!");
  // set on recive listener
  server.addListener(new EclaSocketListener() {
      @Override
      public void onRecive(String response) {
          System.out.println(response);
      }
  });

```

#### Client side

```
  Transfer client = new SocketTransfer();
  // set port, server's address and connect client
  client.setPort(8888).setAddress("localhost").startClient();
  // set on recive listener
  client.addListener(new EclaSocketListener() {
      @Override
      public void onRecive(String response) {
          System.out.println(response);
      }
  });
  // send message to server
  client.sendMessage("Hello to server");

```
#### Send Object
```
  // create object
  Person person = new Person();
  person.name = "Milan";
  person.lastname = "MilanNz";
  person.status = 1;
  
  // send object
  client.sendMessageObject(person);
```
##### Parse JSON
```
  MessageBuilder.parseMessage(response);
```
For this option we use [Gson](https://github.com/google/gson)

###How to install?
It's easy, just download EclaSocket.jar and iclude it in your project.
[EclaSocket.jar](https://github.com/MilanNz/Java-Socket-Client-Server/tree/master/dist)

#More about Java Socket
* [Socket](http://docs.oracle.com/javase/7/docs/api/java/net/Socket.html)
* [All About Sockets](https://docs.oracle.com/javase/tutorial/networking/sockets/)

