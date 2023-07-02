package com.practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    private ShoppingCart cart;

    private  Item item1;
    private  Item item2;

    @BeforeEach
    void setUp(){
        item1= new Item("Iphone",50000.0);
        item2= new Item("Mac",70000.0);
        cart = new ShoppingCart();
    }

    @Test
    @DisplayName("Adding Item To The Cart")
    void shouldAddItemToCart(){
        // given
        // items present in cart

        //when
        cart.addItem(item1);

        //then
        assertTrue(cart.containsItem(item1));

    }


    @Test
    @DisplayName("Removing Item From The Cart")
    void shouldRemoveItemFromCart(){
        // given
        cart.addItem(item1);
        cart.addItem(item2);

        //when
        cart.removeItem(item1);

        // then
        // item 2 is not removed
        assertTrue(cart.containsItem(item2));
        // item 1 removed from cart
        assertFalse(cart.containsItem(item1));
    }





    @Test
    @DisplayName("Calculation Of Total Item Price In Cart")
    void shouldCalculateTotalPrice() {
        // given
        cart.addItem(item1);
        cart.addItem(item2);

        double totalPrice = cart.calculateTotalPrice();
        double expectedPrice = 120000.0;
        assertEquals(expectedPrice, totalPrice, "Price Not Matching");

    }
}