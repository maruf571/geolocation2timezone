package com.marufh.geolocation2timezone.controller;

import com.marufh.geolocation2timezone.controller.dto.TimeZoneDto;
import com.marufh.geolocation2timezone.service.ServiceType;
import com.marufh.geolocation2timezone.service.TimeZoneService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping
@RequiredArgsConstructor
public class TimeZoneController {

    private final TimeZoneService timeZoneService;

    @GetMapping("/timeshape/lat/{lat}/lon/{lon}")
    public TimeZoneDto getTimeZoneWithTimeShape(@PathVariable double lat, @PathVariable double lon) {
        return timeZoneService.getTimeZone(lat, lon, ServiceType.TIME_SHAPE);
    }

    @GetMapping("/timezone/lat/{lat}/lon/{lon}")
    public TimeZoneDto getTimeZoneWithTimeZoneMapper(@PathVariable double lat, @PathVariable double lon) {
        return timeZoneService.getTimeZone(lat, lon, ServiceType.TIME_ZONE);
    }

    @GetMapping("/google/lat/{lat}/lon/{lon}")
    public TimeZoneDto getTimeZoneWithGoogle(@PathVariable double lat, @PathVariable double lon) {
        return timeZoneService.getTimeZoneWithGoogle(lat, lon);
    }
}
