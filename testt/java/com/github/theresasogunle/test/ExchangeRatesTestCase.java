/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.theresasogunle.test;

import com.github.theresasogunle.Environment;
import com.github.theresasogunle.ExchangeRates;
import com.github.theresasogunle.RaveConstant;
import org.json.JSONException;
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Theresa
 */
public class ExchangeRatesTestCase {

    @Test
    public void test() throws JSONException {

        RaveConstant.PUBLIC_KEY = "FLWPUBK-d8369e6826011f8a1f9f6c7c14a09b80-X";
        RaveConstant.SECRET_KEY = "FLWSECK-8abf446c71a58aaa858323f3a9ed156b-X";
        RaveConstant.ENVIRONMENT = Environment.STAGING;

        ExchangeRates e = new ExchangeRates();
        e.setAmount("500")
                .setDestination_currency("USD")
                .setOrigin_currency("NGN");

        JSONObject response = e.forex();

        assertEquals(response.get("status"), "success");

    }
}
