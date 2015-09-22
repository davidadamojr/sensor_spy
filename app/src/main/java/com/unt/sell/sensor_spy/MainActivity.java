package com.unt.sell.sensor_spy;

import android.app.ListActivity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.unt.sell.sensor_spy.adapters.SensorListAdapter;
import com.unt.sell.sensor_spy.models.SensorItem;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ListActivity {
    private SensorManager mSensorManager;
    private LocationManager mLocationManager;
    private int[] sensorTypes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = new TextView(this);
        textView.setText("Please select sensors to monitor.");
        textView.setPadding(10, 10, 10, 10);

        getListView().addHeaderView(textView);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        ArrayAdapter<SensorItem> adapter = new SensorListAdapter(this, getModel());
        setListAdapter(adapter);

    }

    private List<SensorItem> getModel() {
        List<SensorItem> sensorList = new ArrayList<SensorItem>();

        // check for availability of each sensor. If it is available, add it to the sensorList.
        // location will be checked in a different way by seeing if the Google thingy is available
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
            sensorList.add(get("Accelerometer"));
        }

        if (mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) != null) {
            sensorList.add(get("Temperature"));
        }

        if (mSensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY) != null) {
            sensorList.add(get("Gravity"));
        }

        if (mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE) != null) {
            sensorList.add(get("Gyroscope"));
        }

        if (mSensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY) != null) {
            sensorList.add(get("Humidity"));
        }

        if (mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT) != null) {
            sensorList.add(get("Light"));
        }

        if (mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY) != null) {
            sensorList.add(get("Proximity"));
        }

        if (mSensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION) != null) {
            sensorList.add(get("Linear Acceleration"));
        }

        if (mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null) {
            sensorList.add(get("Magnetic Field"));
        }

        if (mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE) != null) {
            sensorList.add(get("Pressure"));
        }

        if (mLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            sensorList.add(get("GPS/Location"));
        }

        return sensorList;
    }

    private SensorItem get(String sensor) {
        SensorItem sensorItem = new SensorItem(sensor);
        sensorItem.setSelected(true);
        return sensorItem;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();
        TextView statusText = (TextView) findViewById(R.id.status_text);

        switch (id) {
            case R.id.menuExport:
                break;

            case R.id.menuDelete:
                break;

            case R.id.menuStop:
                getListView().setVisibility(View.VISIBLE);
                statusText.setVisibility(View.INVISIBLE);
                break;

            case R.id.menuStart:
                getListView().setVisibility(View.INVISIBLE);
                statusText.setVisibility(View.VISIBLE);

                // check which items are checked
                // start the appropriate service for each checked item
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
