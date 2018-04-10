package com.twilio.test.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



/**
 * Boot strap class for spring boot
 * 
 * @author ndurgadathan
 *
 */
@SpringBootApplication
@ComponentScan({"com.ripple"})
@EnableAutoConfiguration
public class TwilioTechChallangeApplication {


  private static Logger logger = LoggerFactory.getLogger(TwilioTechChallangeApplication.class);

  public static void main(String... args) {
    SpringApplication.run(TwilioTechChallangeApplication.class, args);

  }
}

