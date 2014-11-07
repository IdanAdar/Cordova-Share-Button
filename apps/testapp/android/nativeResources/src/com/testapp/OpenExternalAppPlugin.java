package com.testapp;

import android.content.Intent;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class OpenExternalAppPlugin extends CordovaPlugin {

	@Override 
	public boolean execute (String action, JSONArray args, CallbackContext callbackContext)
		throws JSONException {
			if (action.equals("openApp")) {				
				Intent sendIntent = new Intent(Intent.ACTION_SEND);
				sendIntent.setType("message/rfc822");
				sendIntent.putExtra(Intent.EXTRA_EMAIL, "toaddress@gmail.com");   
				sendIntent.putExtra(Intent.EXTRA_SUBJECT, "StackOverflow Question");
				sendIntent.putExtra(Intent.EXTRA_TEXT, "Hey!\nTake a look at this StackOverflow question:\n\n" + args.getString(0));
				webView.getContext().startActivity(Intent.createChooser(sendIntent, "Send question using:"));
				return true;
			} else {
				return false;
			}		
		}
}