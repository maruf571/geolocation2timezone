package com.marufh.geolocation2timezone.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.Instant;
import java.time.LocalTime;

@Data
@ToString
@Builder
public class TimeZoneDto {
    private Long dstOffset;
    private Long rawOffset;
    private String status;
    private String timeZoneId;
    private String timeZoneName;
    private LocalTime localTime;
    private LocalTime utcTime;
}
