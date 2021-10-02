package com.marufh.geolocation2timezone.service;

import com.marufh.geolocation2timezone.controller.dto.TimeZoneDto;

public interface TimeZoneService {
    TimeZoneDto getTimeZone(double lat, double log, ServiceType serviceType);
}
