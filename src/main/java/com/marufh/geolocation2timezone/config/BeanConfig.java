package com.marufh.geolocation2timezone.config;

import com.squareup.okhttp.OkHttpClient;
import net.iakovlev.timeshape.TimeZoneEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public OkHttpClient okHttpClient() {
        return new  OkHttpClient();
    }

    @Bean
    public TimeZoneEngine timeZoneEngine() {
        return TimeZoneEngine.initialize();
    }

}
