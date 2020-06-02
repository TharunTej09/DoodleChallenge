# Build and run the code on Linux Environment
Follow the below instructions to run Kafka producer and consumer code in Linux environment.

## Pre-requisites
1. Make sure Java is installed.
    
    Use *javac* command in vi-editor to check if Java is installed. If not, install it using below command.
    sh
    $ sudo apt-get install openjdk-8-jdk
    

2. Make sure SBT (scala built tool) is installed. If not installed follow the below steps.
    
    Use the below commands to setup SBT.
    sh
        $ echo "deb https://dl.bintray.com/sbt/debian/" | sudo tee -a /etc/apt/sources.list.d/sbt.list
        $ sudo apt-get update 
        $ sudo apt-get install sbt
    
    Reference: https://www.scala-sbt.org/1.x/docs/Installing-sbt-on-Linux.html.

    > Once SBT is installed, you’ll be able to manage the package in aptitude or Synaptic after you updated their package cache. You should also be able to see the added repository at the bottom of the list in System Settings -> Software & Updates -> Other Software.

## Compile and execute Kafka code
### Producer

Create a directory for kafka projects and point to the directory using below commands.
sh
$ mkdir kafka_projects
$ cd kafka_projects/


Start SBT 
sh
$ sbt

To compile and execute we need to create and build.sbt file
sh
nano build.sbt

Copy the following content in the file
sh
name := "DataGenerator"
scalaVersion := "2.11.11"
libraryDependencies ++= Seq("org.apache.kafka" % "kafka-clients" % "1.0.0")

Create a source code file and copy paste the application code in the file.

For compiling the program
sh
$ sbt compile

We can execute the program
sh
$ sbt run 

To see message that is sent by producer, we need to start consumer. 
### Consumer
sh
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic SimpleProducerTopic --from-beginning

Through this we can see the message from producer.




 


 