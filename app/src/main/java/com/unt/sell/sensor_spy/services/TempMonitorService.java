package com.unt.sell.sensor_spy.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class TempMonitorService extends Service {
    public TempMonitorService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
