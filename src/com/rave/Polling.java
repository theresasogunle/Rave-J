/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave;

import static com.rave.Encryption.encryptData;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Theresa
 */
public class Polling {
          ApiConnection apiConnection;
      final private Endpoints ed=new Endpoints();
          Encryption e=new Encryption();
          Keys key=new Keys();
  
  
    //if timeout, start polling
     /**
     * 
     *@param json
     * @throws JSONException
     * @return JSONObject
     */
    public JSONObject handleTimeoutCharge(JSONObject json)throws JSONException{
      this.apiConnection = new ApiConnection(ed.getChargeTimeoutEndpoint());
      
        String message= json.toString();
        
        String encrypt_secret_key=Encryption.getKey(key.getSecretKey());
        String client= encryptData(message,encrypt_secret_key);
      
        String alg="3DES-24";
     
        ApiQuery api=new ApiQuery();
        
        api.putParams("PBFPubKey", key.getPublicKey());

        api.putParams("client", client);

        api.putParams("alg", alg);
      
        
        return this.apiConnection.connectAndQuery(api);
    }
     /**
     * 
     * @param transaction_reference
     * @param otp 
     * @return String
     */
    public JSONObject validateChargeTimeout(String transaction_reference,String otp){
       

       Charge vc= new Charge();

        return vc.validateCharge(transaction_reference, otp);
    }
    

  
    
}
