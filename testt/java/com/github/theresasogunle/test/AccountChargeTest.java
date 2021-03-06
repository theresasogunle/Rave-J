/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.theresasogunle.test;

import com.github.theresasogunle.AccountCharge;
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
public class AccountChargeTest {

    JSONObject json = new JSONObject();
    AccountCharge ch = new AccountCharge();
    Encryption e = new Encryption();

    @Test
    public void testAccountCharge() throws JSONException {
        RaveConstant.PUBLIC_KEY = "FLWPUBK-d8369e6826011f8a1f9f6c7c14a09b80-X";
        RaveConstant.SECRET_KEY = "FLWSECK-8abf446c71a58aaa858323f3a9ed156b-X";
        RaveConstant.ENVIRONMENT = Environment.STAGING;

        ch.setAccountnumber("0690000031")
                .setAccountbank("044")
                .setAmount("1000")
                .setCountry("NG")
                .setCurrency("NGN")
                .setLastname("Theresa")
                .setIP("1.3.4.4")
                .setTxRef("MX-678DH")
                .setEmail("sogunledolapo@gmail.com");

        JSONObject result = ch.chargeAccount();

       // JSONObject poll = ch.chargeAccount(true);
        //assertEquals(poll.get("status"), "success");

        if (result.get("status").equals("success")) {
            assertEquals(result.get("status"), "success");
            System.out.println(result);
        } else {

            assertEquals(result.get("status"), "error");
            System.out.println(result);
        }

    }

    @Test
    public void verifyAccountValidation() throws JSONException {
        RaveConstant.PUBLIC_KEY = "FLWPUBK-d8369e6826011f8a1f9f6c7c14a09b80-X";
        RaveConstant.SECRET_KEY = "FLWSECK-8abf446c71a58aaa858323f3a9ed156b-X";
        RaveConstant.ENVIRONMENT = Environment.STAGING;

        ch.setTransaction_reference("ACHG-1520028650995")
                .setOtp("12345");
        //for polling JSONObject val = ch.validateAccountCharge(true);
        JSONObject validate = ch.validateAccountCharge();

        
         if(validate.get("status").equals("success")){
         assertEquals(validate.get("status"),"success");
      
         }else{
         assertEquals(validate.get("status"),"error");
         }
       
         
    }

}
