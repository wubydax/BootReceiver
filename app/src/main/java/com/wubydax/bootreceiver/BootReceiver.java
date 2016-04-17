package com.wubydax.bootreceiver;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.widget.Toast;

/**
 * Created by Dax on 15/09/2015.
 */
public class BootReceiver extends BroadcastReceiver {



    @Override
    public void onReceive(Context context, Intent intent) {
        ContentResolver cr = context.getContentResolver();
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor ed = sp.edit();
        boolean isFirstBoot = sp.getBoolean("isFirst", true);
        if (isFirstBoot) {
            Toast.makeText(context, "Boot Completed", Toast.LENGTH_SHORT).show();
            //Adopted for working on Settings.Secure
            /*
            You can use this method to make changes to the settings storage
            upon first boot. This application will only run once. You can apply any changes you wish, like so:

                        Settings.Secure.putInt(cr, "rom_test_bootreceiver", 1);

                        or

                        Settings.Secure.putString(cr, "your_key_name", "some string");

                        or

                        Settings.Secure.putFloat(cr, "your_key_name", 1.0F);

              Those are just small examples. You can perform various functions at the first boot of your rom.
              This is just a tool to get you started on catching that boot complete action

             */
            ed.putBoolean("isFirst", false).apply();
        }

    }
}
