package com.json.rest.sample.util;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Praneeth
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.json.rest.sample")

public class ApplicationConfiguration {

}