/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.theresasogunle.test;

import com.github.theresasogunle.Bank;
import com.github.theresasogunle.Environment;
import com.github.theresasogunle.RaveConstant;
import com.mashape.unirest.http.JsonNode;
import org.json.JSONException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Theresa
 */
public class BankTestCase {

    @Test
    public void testBank() throws JSONException {
        RaveConstant.PUBLIC_KEY = "FLWPUBK-d8369e6826011f8a1f9f6c7c14a09b80-X";
        RaveConstant.SECRET_KEY = "FLWSECK-8abf446c71a58aaa858323f3a9ed156b-X";
        RaveConstant.ENVIRONMENT = Environment.STAGING;

        Bank b = new Bank();
        JsonNode response = b.getAllBanks();
        assertEquals(("success"), "success");
        System.out.println(response);
    }
}
