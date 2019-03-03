# Verspaetung public transport

This is a Spring Boot application for retrieving public transport information of the city Verspaetung with three endpoints:

* Find a vehicle id/multiple vehicle ids for a given time and X & Y coordinates
```
localhost:8081/lines?x={xCoordinate}&y={yCoordinate}&time={time in HH:mm:ss}
```
* Return the vehicle id arriving next at a given stop and time
```
localhost:8081/stops/{stopId}/times/{time in HH:mm:ss}/line
```
* Indicate if a given line is currently delayed

```
localhost:8081/lines/{lineId}/delay
```

### How to start

* Java version 1.8 is required to run this application
* Go to this project's source code folder and run the following command to start the application:

```
java -jar verspaetung-0.0.1-SNAPSHOT.jar
```

### Assumptions/Deductions
Given the limited information I assume/deduct the following:

* I assume that `Vehicle` in the problem statement and `Line` in the given data set are the same 
* Given the data that a `Delay` object is associated with only one `Line` via line_name, I would not be able to provide specific delay data if multiple vehicles were given
* I assume the delay information is given in minutes
* Regarding the first feature: With the given data set, the service can only handle requests with X & Y coordinates which can be mapped to stops, as I do not have route information
* Regarding the second feature: Assume that "arriving next" means the next vehicle to arrive relative to current time point when the request was sent. I assume that the schedule given applies for every day