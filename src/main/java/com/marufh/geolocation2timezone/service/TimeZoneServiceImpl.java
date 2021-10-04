package com.marufh.geolocation2timezone.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marufh.geolocation2timezone.controller.dto.TimeZoneDto;
import com.marufh.geolocation2timezone.thirdparty.TimezoneMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.iakovlev.timeshape.TimeZoneEngine;
import org.springframework.stereotype.Service;

import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.TimeZone;

@Slf4j
@Service
@RequiredArgsConstructor
public class TimeZoneServiceImpl implements TimeZoneService {

    private final OkHttpClient okHttpClient;
    private final TimeZoneEngine engine;
    private final ObjectMapper objectMapper;

    @Override
    public TimeZoneDto getTimeZone(double lat, double lon, ServiceType serviceType) {
        log.info("lat: {}, lon: {}, service: {}", lat, lon, serviceType);

        ZoneId zoneId = null;
        LocalTime utcTime = LocalTime.now(ZoneOffset.UTC);

        if(serviceType.equals(ServiceType.TIME_SHAPE)) {
            zoneId =  getTimeZoneWithTimeShape(lat, lon);
        } else if(serviceType.equals(ServiceType.TIME_ZONE)) {
            zoneId =  getTimeZoneWithTimeZone(lat, lon);
        }

        assert zoneId != null;
        ZonedDateTime localTime = ZonedDateTime.now(zoneId);

        return TimeZoneDto.builder()
                .dstOffset((long) (TimeZone.getTimeZone(zoneId).getDSTSavings() / 1000))
                .rawOffset((long) (TimeZone.getTimeZone(zoneId).getRawOffset() / 1000))
                .timeZoneName(zoneId.getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH))
                .timeZoneId(zoneId.getId())
                .status("OK")
                .localTime(localTime.toLocalDateTime().toLocalTime())
                .utcTime(utcTime)
                .build();
    }

    private ZoneId getTimeZoneWithTimeShape(double lat, double lon) {
        return engine.query(lat, lon)
                .orElseThrow(() -> new RuntimeException("ZoneId not found"));
    }

    private ZoneId getTimeZoneWithTimeZone(double lat, double lon) {
        return ZoneId.of(TimezoneMapper.latLngToTimezoneString(lat, lon));
    }


    // Add google time zone api key before using this one
    public TimeZoneDto getTimeZoneWithGoogle(double lat, double lon) {
        log.info("lat: {}, lon: {} ", lat, lon);

        LocalTime utcTime = LocalTime.now(ZoneOffset.UTC);
        try {
            Request request = new Request.Builder().url(getTimeZoneUrl(lat, lon)).method("GET", null).build();
            String respStr = okHttpClient.newCall(request).execute().body().string();

            TimeZoneDto timeZoneDto = objectMapper.readValue(respStr, TimeZoneDto.class);
            timeZoneDto.setLocalTime(getLocalTime(utcTime, timeZoneDto.getRawOffset(), timeZoneDto.getDstOffset()));
            timeZoneDto.setUtcTime(utcTime);
            return timeZoneDto;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Something wrong with fetching timezone api");
        }
    }


    private LocalTime getLocalTime(LocalTime utcTime, long rawOffset, long dstOffset) {
        return utcTime.plusSeconds(rawOffset).plusSeconds(dstOffset);
    }

    private String getTimeZoneUrl(double lat, double lon) {
        return "https://maps.googleapis.com/maps/api/timezone/json?location=" +
                lat +
                "%2C" +
                lon +
                "&timestamp=" +
                Instant.now().getEpochSecond() +
                "&key=" +
                "<TIME-ZONE-API-KEY>";
    }

}
