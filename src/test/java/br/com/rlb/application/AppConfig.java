package br.com.rlb.application;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"br.com.rlb.application", "br.com.rlb.controller", "br.com.rlb.service"," br.com.rlb.repository", "br.com.rlb.entity" })
public class AppConfig {

}
