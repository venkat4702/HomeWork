package com.homework.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class HomeWorkControllerTest {

    private Map<Object, Object> map = new HashMap();

    @Test
    public void test_testMap() {
        Map<Object, Object> objectMap = testMap();

        assertEquals("values not matching", "test1", objectMap.get(1));

    }

    public Map<Object, Object> testMap(){

        Map<Object, Object> aMap = new HashMap();
        aMap.put(1, "test");
        aMap.put("two", "testString");

        return aMap;
    }
}