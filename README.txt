Ensure you have jdk-17 installed and set JAVA_HOME
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home

Follow these steps to run this program:
1. cd to the directory <yourUnzipDir>/MLBTakeHomeProject/mlbTakeHome
2. Bring the local service: ./gradlew bootrun
3. cd .. to <your unzip dir>/MLBTakeHomeProject
4. compile the java program: javac MlbWeather.java
5. run the MlbWeather java program like below:  
    java MlbWeather --team 112 --date 2022-04-07
    java MlbWeather --venue 17
    java MlbWeather --team 112 --date 2023-04-07
6. To run the tests : ./gradlew clean test





