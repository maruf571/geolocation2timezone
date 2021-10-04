# geolocation-to-timezone
This is an investigation task to find out the suitable solution to get timezone from geolocaiton using java

### Solution using 3rd party 
I have found two suitable offline solutions to get the timezone from geolocation 

* Timzeshape (Java lib, https://github.com/RomanIakovlev/timeshape)
* TimeZoneMapper (A stand alone java class, https://github.com/drtimcooper/LatLongToTimezone)

### How to run
Using maven command for spring-boot 
```
$ mvn spring-boot:run
```

Test
```
$ mvn test
```


Using docker-compose:
```angular2html
$ docker-compose up
```

Browse
```
http://localhost:8080/timeshape/lat/52.0223/lon/5.16709
http://localhost:8080/timezone/lat/52.0223/lon/5.16709
```




