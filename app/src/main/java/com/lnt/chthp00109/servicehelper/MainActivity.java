package com.lnt.chthp00109.servicehelper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView Batterymode,Batterylevel;
    String Batterystatus="";
    int batterypercentage;
    IntentFilter intentFilter;
    int deviceStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Batterymode=findViewById(R.id.StateofCharging);
        intentFilter=new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Batterylevel=findViewById(R.id.percentage);
        MainActivity.this.registerReceiver(broadcastReceiver,intentFilter);
    }


    public void ScdulerTask(View view) {

    }

    public void BluetoothActivity(View view) {

    }

    public void RingerVolume(View view) {

    }

    public void WifiActivity(View view) {

    }
    private BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            deviceStatus = intent.getIntExtra(BatteryManager.EXTRA_STATUS,-1);
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
            int batteryLevel=(int)(((float)level / (float)scale) * 100.0f);
            if(deviceStatus == BatteryManager.BATTERY_STATUS_CHARGING){
                Batterystatus="Charging";
                Batterymode.setText(Batterystatus.toString());
                Batterylevel.setText(String.valueOf(batteryLevel));

            }

            if(deviceStatus == BatteryManager.BATTERY_STATUS_DISCHARGING){

                Batterystatus="Discharging";
                Batterymode.setText(Batterystatus.toString());
                Batterylevel.setText(String.valueOf(batteryLevel));

            }

            if (deviceStatus == BatteryManager.BATTERY_STATUS_FULL){

                Batterystatus="Battery Full";
                Batterymode.setText(Batterystatus.toString());
                Batterylevel.setText(String.valueOf(batteryLevel));

            }

            if(deviceStatus == BatteryManager.BATTERY_STATUS_UNKNOWN){

                Batterystatus="---";
                Batterymode.setText(Batterystatus.toString());
                Batterylevel.setText(String.valueOf(batteryLevel));
            }


            if (deviceStatus == BatteryManager.BATTERY_STATUS_NOT_CHARGING){

                Batterystatus="Not Charging at";
                Batterymode.setText(Batterystatus.toString());
                Batterylevel.setText(String.valueOf(batteryLevel));
            }

        }
    };
}
