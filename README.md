# geolocation-to-timezone
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=maruf571_geolocation2timezone&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=maruf571_geolocation2timezone)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=maruf571_geolocation2timezone&metric=bugs)](https://sonarcloud.io/summary/new_code?id=maruf571_geolocation2timezone)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=maruf571_geolocation2timezone&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=maruf571_geolocation2timezone)

This project aims to explore solutions for retrieving the timezone from geolocation using Java.


### Solutions 
We have identified two suitable offline solutions and a Google API for obtaining timezone information based on geolocation

* Timzeshape (Java Library, https://github.com/RomanIakovlev/timeshape)
* TimeZoneMapper (Java Class, https://github.com/drtimcooper/LatLongToTimezone)
* Google Timezone API


## Usage
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

## Prerequisites
* Java 17
* Maven
* Docker
* Docker-compose
* Google Timezone API (Optional)


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


