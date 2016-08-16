package com.mycompany

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter   
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry   
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry  

@Configuration
open class WebMvcAutoConfigurationAdapter : WebMvcAutoConfigurationAdapter() {
	override fun addViewControllers(registry:ViewControllerRegistry) {
		registry.addViewController("/").setViewName("forward:/main.html")	
		registry.addViewController("/login").setViewName("forward:/login.html")	
	}
	override fun addResourceHandlers(registry:ResourceHandlerRegistry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/", "classpath:/resources/",
        "classpath:/static/", "classpath:/public/")
	} 
}
