package com.marufh.geolocation2timezone.service;


import com.marufh.geolocation2timezone.controller.dto.TimeZoneDto;
import com.marufh.geolocation2timezone.service.ServiceType;
import com.marufh.geolocation2timezone.service.TimeZoneService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TimeZoneServiceTest {

    @Autowired
    private TimeZoneService timeZoneService;

    @Test
    public void testTimeShape() {
        TimeZoneDto timeZoneDto1 = timeZoneService.getTimeZone(23.8103, 90.4125, ServiceType.TIME_SHAPE);
        Assertions.assertEquals(timeZoneDto1.getZone().getId(), "Asia/Dhaka");

        TimeZoneDto timeZoneDto2 = timeZoneService.getTimeZone(52.520008, 13.404954, ServiceType.TIME_SHAPE);
        Assertions.assertEquals(timeZoneDto2.getZone().getId(), "Europe/Berlin");

        TimeZoneDto timeZoneDto3 = timeZoneService.getTimeZone(13.736717, 100.523186, ServiceType.TIME_SHAPE);
        Assertions.assertEquals(timeZoneDto3.getZone().getId(), "Asia/Bangkok");

        TimeZoneDto timeZoneDto4 = timeZoneService.getTimeZone(40.730610, -73.935242, ServiceType.TIME_SHAPE);
        Assertions.assertEquals(timeZoneDto4.getZone().getId(), "America/New_York");

        TimeZoneDto timeZoneDto5 = timeZoneService.getTimeZone(48.864716, 2.349014, ServiceType.TIME_SHAPE);
        Assertions.assertEquals(timeZoneDto5.getZone().getId(), "Europe/Paris");

        TimeZoneDto timeZoneDto6 = timeZoneService.getTimeZone(53.551086, 9.993682, ServiceType.TIME_SHAPE);
        Assertions.assertEquals(timeZoneDto6.getZone().getId(), "Europe/Berlin");
    }


    @Test
    public void testTimeZone() {
        TimeZoneDto timeZoneDto1 = timeZoneService.getTimeZone(23.8103, 90.4125, ServiceType.TIME_ZONE);
        Assertions.assertEquals(timeZoneDto1.getZone().getId(), "Asia/Dhaka");

        TimeZoneDto timeZoneDto2 = timeZoneService.getTimeZone(52.520008, 13.404954, ServiceType.TIME_ZONE);
        Assertions.assertEquals(timeZoneDto2.getZone().getId(), "Europe/Berlin");

        TimeZoneDto timeZoneDto3 = timeZoneService.getTimeZone(13.736717, 100.523186, ServiceType.TIME_ZONE);
        Assertions.assertEquals(timeZoneDto3.getZone().getId(), "Asia/Bangkok");

        TimeZoneDto timeZoneDto4 = timeZoneService.getTimeZone(40.730610, -73.935242, ServiceType.TIME_ZONE);
        Assertions.assertEquals(timeZoneDto4.getZone().getId(), "America/New_York");

        TimeZoneDto timeZoneDto5 = timeZoneService.getTimeZone(48.864716, 2.349014, ServiceType.TIME_ZONE);
        Assertions.assertEquals(timeZoneDto5.getZone().getId(), "Europe/Paris");

        TimeZoneDto timeZoneDto6 = timeZoneService.getTimeZone(53.551086, 9.993682, ServiceType.TIME_ZONE);
        Assertions.assertEquals(timeZoneDto6.getZone().getId(), "Europe/Berlin");
    }
}
