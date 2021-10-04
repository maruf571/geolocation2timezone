package com.marufh.geolocation2timezone.service;


import com.marufh.geolocation2timezone.controller.dto.TimeZoneDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TimeZoneDtoServiceTest {

    @Autowired
    private TimeZoneService timeZoneService;

    @Test
    public void testTimeShape() {
        TimeZoneDto timeZoneDtoDto1 = timeZoneService.getTimeZone(23.8103, 90.4125, ServiceType.TIME_SHAPE);
        Assertions.assertEquals(timeZoneDtoDto1.getTimeZoneId(), "Asia/Dhaka");
        Assertions.assertEquals(timeZoneDtoDto1.getDstOffset(), 0);

        TimeZoneDto timeZoneDtoDto2 = timeZoneService.getTimeZone(52.520008, 13.404954, ServiceType.TIME_SHAPE);
        Assertions.assertEquals(timeZoneDtoDto2.getTimeZoneId(), "Europe/Berlin");

        TimeZoneDto timeZoneDtoDto3 = timeZoneService.getTimeZone(13.736717, 100.523186, ServiceType.TIME_SHAPE);
        Assertions.assertEquals(timeZoneDtoDto3.getTimeZoneId(), "Asia/Bangkok");

        TimeZoneDto timeZoneDtoDto4 = timeZoneService.getTimeZone(40.730610, -73.935242, ServiceType.TIME_SHAPE);
        Assertions.assertEquals(timeZoneDtoDto4.getTimeZoneId(), "America/New_York");

        TimeZoneDto timeZoneDtoDto5 = timeZoneService.getTimeZone(48.864716, 2.349014, ServiceType.TIME_SHAPE);
        Assertions.assertEquals(timeZoneDtoDto5.getTimeZoneId(), "Europe/Paris");

        TimeZoneDto timeZoneDtoDto6 = timeZoneService.getTimeZone(53.551086, 9.993682, ServiceType.TIME_SHAPE);
        Assertions.assertEquals(timeZoneDtoDto6.getTimeZoneId(), "Europe/Berlin");
    }


    @Test
    public void testTimeZone() {
        TimeZoneDto timeZoneDtoDto1 = timeZoneService.getTimeZone(23.8103, 90.4125, ServiceType.TIME_ZONE);
        Assertions.assertEquals(timeZoneDtoDto1.getTimeZoneId(), "Asia/Dhaka");
        Assertions.assertEquals(timeZoneDtoDto1.getDstOffset(), 0);

        TimeZoneDto timeZoneDtoDto2 = timeZoneService.getTimeZone(52.520008, 13.404954, ServiceType.TIME_ZONE);
        Assertions.assertEquals(timeZoneDtoDto2.getTimeZoneId(), "Europe/Berlin");

        TimeZoneDto timeZoneDtoDto3 = timeZoneService.getTimeZone(13.736717, 100.523186, ServiceType.TIME_ZONE);
        Assertions.assertEquals(timeZoneDtoDto3.getTimeZoneId(), "Asia/Bangkok");

        TimeZoneDto timeZoneDtoDto4 = timeZoneService.getTimeZone(40.730610, -73.935242, ServiceType.TIME_ZONE);
        Assertions.assertEquals(timeZoneDtoDto4.getTimeZoneId(), "America/New_York");

        TimeZoneDto timeZoneDtoDto5 = timeZoneService.getTimeZone(48.864716, 2.349014, ServiceType.TIME_ZONE);
        Assertions.assertEquals(timeZoneDtoDto5.getTimeZoneId(), "Europe/Paris");

        TimeZoneDto timeZoneDtoDto6 = timeZoneService.getTimeZone(53.551086, 9.993682, ServiceType.TIME_ZONE);
        Assertions.assertEquals(timeZoneDtoDto6.getTimeZoneId(), "Europe/Berlin");
    }
}
