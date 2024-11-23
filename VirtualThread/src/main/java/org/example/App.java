package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class App extends SpringBootServletInitializer
{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder)
    {
        return builder.sources(App.class);
    }

    @Autowired
    ServiceClass serviceClass;

    @RequestMapping(value = "/trace", method = RequestMethod.GET)

    public ResponseEntity<String> getTrace()
    {
        String str=serviceClass.getServiceTrace();
        return ResponseEntity.ok("Hello find Trace " +str);
    }

    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
        System.out.println("Ohm Namah Shivaiahh");
       //Thread.ofPlatform().start(()->System.out.println("platform Thread "+ Thread.currentThread()));
       //Thread.ofVirtual().start(()-> System.out.println("Virtual Thread "+ Thread.currentThread()));
    }
}
