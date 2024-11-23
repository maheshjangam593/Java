package org.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service

public class ServiceClass {


    private String privateMethod()
    {
        return  "returning from private method";
    }

   public String getServiceTrace()
    {
        return privateMethod();
    }
    public String methodWithParameters(String string)
    {
        return  "returning from methodWithParameters method :"+string;
    }
    public void methodWithNoResponse(){
        System.out.println("Hello World");
        return;
    }



}
