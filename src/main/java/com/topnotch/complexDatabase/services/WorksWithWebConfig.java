/*package com.topnotch.complexDatabase.services;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.topnotch.complexDatabase.models.WorksWithKey;

@Configuration
//@EnableWebMvc
public class WorksWithWebConfig implements WebMvcConfigurer {

  @Override
  public void addFormatters(FormatterRegistry registry) {
    // do not replace with lambda as spring cannot determine source type <S> and target type <T>
    registry.addConverter( new WorksWithIdConverter());
  }
}*/