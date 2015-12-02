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

#The MIT License
--------
```
Copyright (c) 2015 Milan Adamovic 

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
```
