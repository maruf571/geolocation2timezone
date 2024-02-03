# geolocation-to-timezone
This project aims to explore solutions for retrieving the timezone from geolocation using Java.


### Solutions 
We have identified two suitable offline solutions and a Google API for obtaining timezone information based on geolocation

* Timzeshape (Java Library, https://github.com/RomanIakovlev/timeshape)
* TimeZoneMapper (Java Class, https://github.com/drtimcooper/LatLongToTimezone
* Google Timezone API


### How to run
Run code locally:
```
git clone https://github.com/maruf571/geolocation2timezone.git
mvn spring-boot:run
```

Run test cases:
```
mvn test
```

Using docker-compose
```
docker-compose up
```

### Endpoints and Usage
```
http://localhost:8080/timeshape/lat/52.0223/lon/5.16709
http://localhost:8080/timezone/lat/52.0223/lon/5.16709
http://localhost:8080/google/lat/52.0223/lon/5.16709
```
** Note: If using Google, ensure that you have added the Google Time Zone API.

### Request/Response
Sample request
```
http://localhost:8080/timeshape/lat/23.999941/lon/90.420273
```

Response
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


