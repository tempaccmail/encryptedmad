package com.example.alertmessage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import java.util.Objects;

public class SmsReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (Objects.equals(intent.getAction(), "android.provider.Telephony.SMS_RECEIVED")) {
                Bundle bundle = intent.getExtras();           //---get the SMS message passed in---
                SmsMessage[] msgs = null;
                String msg_from = "";
                if (bundle != null) {
                    //---retrieve the SMS message received---
                    try {
                        Object[] pdus = (Object[]) bundle.get("pdus");
                        assert pdus != null;
                        msgs = new SmsMessage[pdus.length];
                        for (int i = 0; i < msgs.length; i++) {
                            msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                            msg_from = msgs[i].getOriginatingAddress();
                            //String msgBody = msgs[i].getMessageBody();
                            //                            Stream_link = "https://lms.ssn.edu.in/login/index.php";
                        }

                        Toast.makeText(context, "SMS Received from" + msg_from +"!", Toast.LENGTH_SHORT).show();

                    } catch (Exception e) {
                        Log.d("Exception caught", Objects.requireNonNull(e.getMessage()));
                    }

                }
            }
        }
    }
}

