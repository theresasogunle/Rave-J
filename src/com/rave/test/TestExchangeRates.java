/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.test;

import com.rave.ApiQuery;
import com.rave.ExchangeRates;

/**
 *
 * @author Theresa
 */
public class TestExchangeRates {
    public static void main(String [] args){

      
        ExchangeRates e=new ExchangeRates();
        e.setAmount("500");
        e.setDestination_currency("USD");
        e.setOrigin_currency("NGN");
        System.out.println( e.forex());

    
    }
}
