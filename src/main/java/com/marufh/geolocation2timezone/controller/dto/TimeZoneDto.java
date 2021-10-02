package com.marufh.geolocation2timezone.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
@Builder
public class TimeZoneDto {
    private ZoneId zone;
    private LocalDateTime time;
}
