# Atari Opener
A simple rebuild of the Atari opening screen

<img src="atari_opener.png" width="200" align=right />

## To run:

### Run Requirements

 - Java 25 (JRE)

## To build:

### Build Requirements

 - Java 21 (JDK)
 - Maven

The [pom.xml](pom.xml) file can be adjusted to build with earlier versions of Java, but it is not recommended to go below 17.

### Build command

    mvn clean install

### Running the build

    java -jar target/atariopener-0.0.1-SNAPSHOT-jar-with-dependencies.jar
