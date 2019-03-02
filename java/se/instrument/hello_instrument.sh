javac MyApp.java
javac MyAgent.java
jar cfe MyApp.jar MyApp MyApp.class
jar cmf manifest.txt MyAgent.jar MyAgent.class
java -javaagent:MyAgent.jar -jar MyApp.jar
