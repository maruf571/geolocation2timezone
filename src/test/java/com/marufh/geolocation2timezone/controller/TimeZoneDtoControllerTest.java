package com.marufh.geolocation2timezone.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class TimeZoneDtoControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testTimeShape() throws Exception {
        RequestBuilder requestBuilder = get("/timeshape/lat/23.8103/lon/90.4125");
        this.mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.timeZoneId").value("Asia/Dhaka"));
    }

    @Test
    public void testTimeZone() throws Exception {
        RequestBuilder requestBuilder = get("/timezone/lat/23.8103/lon/90.4125");
        this.mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.timeZoneId").value("Asia/Dhaka"));
    }
}
