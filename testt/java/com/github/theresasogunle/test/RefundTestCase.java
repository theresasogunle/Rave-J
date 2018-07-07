/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.theresasogunle.test;

import com.github.theresasogunle.Environment;
import com.github.theresasogunle.RaveConstant;
import com.github.theresasogunle.Refund;
import org.json.JSONException;
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Theresa
 */
public class RefundTestCase {

    @Test
    public void test() throws JSONException {
        RaveConstant.PUBLIC_KEY = "FLWPUBK-d8369e6826011f8a1f9f6c7c14a09b80-X";
        RaveConstant.SECRET_KEY = "FLWSECK-8abf446c71a58aaa858323f3a9ed156b-X";
        RaveConstant.ENVIRONMENT = Environment.STAGING;

        Refund rf = new Refund();

        rf.setRef("FLW-MOCK-dcd2cd407f37649b04eb1342247e0bf6");

        JSONObject response = rf.refund();

        if (response.get("status").equals("success")) {
            assertEquals(response.get("status"), "success");
            System.out.println(response);
        } else {

            assertEquals(response.get("status"), "error");
            System.out.println("Refund not successful");
            System.out.println(response);
        }

    }
}
