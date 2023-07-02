package com.practice;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

class ItemTest {

    private  Item item;

    @BeforeAll
    static  void beforeAll(){
        System.out.println("Before All Method Is Called");

    }



    @BeforeEach
    public void setUp(){
        item = new Item("Iphone",50000.0);
        System.out.println("Before Each Method Is Called");
    }

    @AfterEach
    public void tearDown(){
        item=null;
        System.out.println("After Each Method Is Called");
    }


    @AfterAll
    static  void afterAll(){
        System.out.println("After All Method Is Called");

    }

    @Test
    public  void initItems(){
        assertNotNull(item);
        String itemName = item.getName();
        double price= item.getPrice();

        assertEquals("Iphone", itemName,"Name does not match");
        assertEquals(50000.0,price,"Item price does not match");
    }

    @Test
    public  void initItems2(){
        assertNotNull(item);
        String itemName = item.getName();
        double price= item.getPrice();

        assertEquals("Iphone", itemName,"Name does not match");
        assertEquals(50000.0,price,"Item price does not match");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv" , numLinesToSkip = 1)
    public  void shouldPriceAffordable(double budget, boolean expected){

         boolean affordableOrNot=item.isAffordable(budget);
         assertEquals(expected,affordableOrNot);



//        assertTrue( item.isAffordable(70000.0));
//        assertFalse( item.isAffordable(20000.0));

    }

}