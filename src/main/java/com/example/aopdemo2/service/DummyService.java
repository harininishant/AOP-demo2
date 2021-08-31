package com.example.aopdemo2.service;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
public class DummyService {

    public Map<String,String> getName(String key){
        return Collections.singletonMap(key,"John Doe");
    }

   public void doSomething(String str,int a){
    System.out.println("enjoying life");
}
/*
its printing for all methods pointcut says any method on service class it will call.
 */

}
