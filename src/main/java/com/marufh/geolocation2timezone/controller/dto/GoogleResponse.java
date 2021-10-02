package com.marufh.geolocation2timezone.controller.dto;

import lombok.Data;

@Data
public class GoogleResponse {
    private Double dstOffset;
    private Double rawOffset;
    private String status;
    private String timeZoneId;
    private String timeZoneName;
}
