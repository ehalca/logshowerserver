/**
 * 
 */
package com.ehalca.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Hulk
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.ehalca.controllers")
public class MVCConfig extends WebMvcConfigurerAdapter {

}
