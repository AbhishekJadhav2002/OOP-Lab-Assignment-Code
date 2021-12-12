/*
============================================================================
 Name : ShoppingCartTest.java
 Author : 23232_Abhishek Jadhav
 Version : 1.0
 Copyright : Your copyright notice
 Description : OOP Lab Assignment No. 10
============================================================================
*/

import strategyclass.*;
public class ShoppingCartTest
{
    public static void main(String[] args)
    {
        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item("1234",60);
        Item item2 = new Item("5678",40);
        cart.addItem(item1);
        cart.addItem(item2);
        //pay by paypal​
        cart.pay(new PaypalStrategy("myemail@example.com", "pwd"));
        //pay by credit card​
        cart.pay(new CreditCardStrategy("Aparna Bindage", "1234567890123456", "786", "12/15"));
    }
}