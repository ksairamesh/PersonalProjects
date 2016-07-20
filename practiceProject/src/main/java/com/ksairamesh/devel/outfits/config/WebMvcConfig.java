package com.ksairamesh.devel.outfits.config;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.annotation.JsonInclude;

import com.ksairamesh.devel.outfits.controller.ControllerPackageMarker;



@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses={ControllerPackageMarker.class })
public class WebMvcConfig extends WebMvcConfigurerAdapter{

	@Override
	public void configureMessageConverters(
			List<HttpMessageConverter<?>> converters) {
		
		converters.add(jacksonMessageConverter());
		super.configureMessageConverters(converters);
	}
	
	private MappingJackson2HttpMessageConverter jacksonMessageConverter()
	{
		MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();

		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		messageConverter.setObjectMapper(mapper);
		return messageConverter;
	}

	@Override
	public void configureContentNegotiation(
			ContentNegotiationConfigurer configurer) {
		configurer.defaultContentType(MediaType.APPLICATION_JSON);
	}
	
}
