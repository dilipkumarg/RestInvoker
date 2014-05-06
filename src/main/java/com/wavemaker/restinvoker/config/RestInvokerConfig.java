package com.wavemaker.restinvoker.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Dilip Kumar.
 * @since 5/5/14
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.wavemaker.restinvoker"})
public class RestInvokerConfig {
}
