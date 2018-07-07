/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.theresasogunle.test;

import com.github.theresasogunle.CardCharge;
import com.github.theresasogunle.Encryption;
import com.github.theresasogunle.Environment;
import com.github.theresasogunle.RaveConstant;
import org.json.JSONException;
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.Test;



/**
 *
 * @author Theresa
 */
public class CardChargeTestCase {
    
     JSONObject api=new JSONObject();
       Encryption encryption=new Encryption();
       CardCharge ch=new CardCharge();
       
       
    @Test
    /**
     * 
     * @throws JSONException
     */
    public void testCardCharge() throws JSONException{
        RaveConstant.PUBLIC_KEY = "FLWPUBK-d8369e6826011f8a1f9f6c7c14a09b80-X";
        RaveConstant.SECRET_KEY = "FLWSECK-8abf446c71a58aaa858323f3a9ed156b-X";
        RaveConstant.ENVIRONMENT = Environment.STAGING;
    
        CardCharge ch = new CardCharge();
        ch.setCardno("4556052704172643")
                .setCvv("899")
                .setCurrency("NGN")
                .setCountry("NG")
                .setAmount("9000")
                .setExpiryyear("19")
                .setExpirymonth("01")
                .setEmail("sogunledolapo@gmail.com")
                .setIP("103.238.105.185")
                .setTxRef("MXX-ASC-4578");

        JSONObject charge = ch.chargeCard();
        System.out.println(charge);
        JSONObject data = charge.getJSONObject("data");
        if (data.has("suggested_auth")) {
            String string = data.get("suggested_auth").toString();
        

            ch.setPin("3310");
            ch.setBillingaddress("New York");
            ch.setBillingcity("New Y");
            ch.setBillingzip("11002");
            ch.setBillingstate("Neww");
            ch.setBillingcountry("NG");

            JSONObject charr = ch.rechargeCard(string);

            System.out.println(charr);
        }
        
         if(charge.get("status").equals("success")){
                assertEquals(charge.get("status"),"success");
                System.out.println("Validation successful");
                System.out.println(charge);
        }else
        {
                assertEquals(charge.get("status"),"error");
                System.out.println(charge);
                System.out.println("Validation not successful!");
        }
  

    }
    /**
     * @return JSONObject
     * @throws Exception
     */
    
     @Test
    public void verifyCardValidation()throws Exception{
      
          //validate
            ch.setOtp("12345");
            ch.setTransactionreference("FLW-MOCK-XXXXXXXXXXXXXXXXXXXXXXX");
            JSONObject validateCharge=ch.validateCardCharge();
            //if timeout, poll JSONObject validatepoll=ch.validateCardCharge(true);
     
         
        if(validateCharge.get("status").equals("success")){
                assertEquals(validateCharge.get("status"),"success");
                System.out.println("Validation successful");
                System.out.println(validateCharge);
        }else
        {
                assertEquals(validateCharge.get("status"),"error");
                System.out.println(validateCharge);
                System.out.println("Validation not successful!");
        }
  
          
     


}
    
      
    }
    
    
   

