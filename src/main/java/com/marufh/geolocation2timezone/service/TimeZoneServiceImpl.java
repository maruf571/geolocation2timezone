package com.marufh.geolocation2timezone.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marufh.geolocation2timezone.controller.dto.GoogleResponse;
import com.marufh.geolocation2timezone.controller.dto.TimeZoneDto;
import com.marufh.geolocation2timezone.thirdparty.TimezoneMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.ResponseBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.iakovlev.timeshape.TimeZoneEngine;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Slf4j
@Service
@RequiredArgsConstructor
public class TimeZoneServiceImpl implements TimeZoneService {

    private final OkHttpClient client;
    private final TimeZoneEngine engine;
    private final ObjectMapper objectMapper;

    @Override
    public TimeZoneDto getTimeZone(double lat, double lon, ServiceType serviceType) {
        log.info("lat: {}, lon: {}, service: {}", lat, lon, serviceType);

        ZoneId zoneId = null;

        long start = System.nanoTime();
        if(serviceType.equals(ServiceType.TIME_SHAPE)) {
            zoneId =  getTimeZoneWithTimeShape(lat, lon);
        } else if(serviceType.equals(ServiceType.TIME_ZONE)) {
            zoneId =  getTimeZoneWithTimeZone(lat, lon);
        } else if(serviceType.equals(ServiceType.GOOGLE)) {
            zoneId = getTimeZoneWithGoogle(lat, lon);
        }

        long elapsedTime = System.nanoTime() - start;
        log.info("elapsedTime: {}", elapsedTime);

        return TimeZoneDto.builder()
                .zone(zoneId)
                .time(LocalDateTime.now(zoneId))
                .build();
    }

    private ZoneId getTimeZoneWithTimeShape(double lat, double lon) {
        return engine.query(lat, lon)
                .orElseThrow(() -> new RuntimeException("ZoneId not found"));
    }

    private ZoneId getTimeZoneWithTimeZone(double lat, double lon) {
        return ZoneId.of(TimezoneMapper.latLngToTimezoneString(lat, lon));
    }


    // Please add google map key before using this one
    private ZoneId getTimeZoneWithGoogle(double lat, Double lon)  {
        Request request = new Request.Builder()
                .url("https://maps.googleapis.com/maps/api/timezone/json?location="+lat+"%2C"+lon+"&timestamp=0&key=API-KEY")
                .method("GET", null)
                .build();

        GoogleResponse googleResponse = null;
        try {
            ResponseBody responseBody = client.newCall(request).execute().body();
            googleResponse = objectMapper.readValue(responseBody.string(), GoogleResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert googleResponse != null;
        return ZoneId.of(googleResponse.getTimeZoneId());
    }

}
