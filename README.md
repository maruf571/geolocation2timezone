# geolocation-to-timezone
This is an investigation task to find out the suitable solution to get timezone from geolocation using java

### Solution using 3rd party 
I have found two suitable offline solutions to get the timezone from geolocation 

* Timzeshape (Java lib, https://github.com/RomanIakovlev/timeshape)
* TimeZoneMapper (A stand alone java class, https://github.com/drtimcooper/LatLongToTimezone)
* Google timezone api

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
http://localhost:8080/google/lat/52.0223/lon/5.16709
```
** If you want to use google, you have to add google time zone api

### Request/Response
Sample request
```
http://localhost:8080/timeshape/lat/23.999941/lon/90.420273
```

Sample response
```
{
  "dstOffset": 0,
  "rawOffset": 21600,
  "status": "OK",
  "timeZoneId": "Asia/Dhaka",
  "timeZoneName": "Bangladesh Time",
  "localTime": "01:33:00.61443",
  "utcTime": "19:33:00.588057"
}
```


