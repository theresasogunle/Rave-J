/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.theresasogunle.test;

import com.github.theresasogunle.Environment;
import com.github.theresasogunle.IntegrityChecksum;
import com.github.theresasogunle.RaveConstant;
import org.json.JSONException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Theresa
 */
public class IntegrityChecksumTestCase {

    @Test
    public void testIntegrityChecksum() throws JSONException {
        RaveConstant.PUBLIC_KEY = "FLWPUBK-d8369e6826011f8a1f9f6c7c14a09b80-X";
        RaveConstant.SECRET_KEY = "FLWSECK-8abf446c71a58aaa858323f3a9ed156b-X";
        RaveConstant.ENVIRONMENT = Environment.STAGING;

        IntegrityChecksum ch = new IntegrityChecksum();

        ch.setAmount("20")
                .setPayment_method("both")
                .setCustom_description("Pay Internet")
                .setCustom_logo("http://localhost/payporte-3/skin/frontend/ultimo/shoppy/custom/images/logo.svg")
                .setCountry("NG")
                .setCurrency("NGN")
                .setCustomer_email("user@example.com")
                .setCustomer_firstname("Temi")
                .setCustomer_lastname("Adelewa")
                .setCustomer_phone("234099940409")
                .setTxref("MG-CKSKKHH");

        String hash = ch.integrityChecksum();

        assertEquals(hash, ch.integrityChecksum());
        

    }
}
