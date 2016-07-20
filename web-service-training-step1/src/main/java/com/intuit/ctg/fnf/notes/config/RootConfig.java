package com.intuit.ctg.fnf.notes.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.intuit.ctg.fnf.notes.service.ServicePackageMarker;

@Configuration
@ComponentScan(basePackageClasses = { ServicePackageMarker.class, PersistenceContext.class })
@PropertySources({
    @PropertySource("classpath:config/env/private/base.properties"),
    @PropertySource("classpath:config/env/private/${environment}.properties")
})
public class RootConfig
{

}