package com.unt.sell.sensor_spy.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.unt.sell.sensor_spy.R;
import com.unt.sell.sensor_spy.models.SensorItem;

import java.util.List;

/**
 * Created by davidadamojr on 6/29/15.
 */
public class SensorListAdapter extends ArrayAdapter<SensorItem> {
    private List<SensorItem> mSensorList;
    private Activity mContext;

    public SensorListAdapter(Activity context, List<SensorItem> sensorList) {
        super(context, R.layout.list_main, sensorList);
        this.mContext = context;
        this.mSensorList = sensorList;
    }

    static class ViewHolder {
        protected TextView text;
        protected CheckBox checkbox;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if (convertView == null) {
            LayoutInflater inflater = mContext.getLayoutInflater();
            view = inflater.inflate(R.layout.list_main, null);
            final ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) view.findViewById(R.id.txt_sensor);
            viewHolder.checkbox = (CheckBox) view.findViewById(R.id.chk_sensor);
            viewHolder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    SensorItem element = (SensorItem) viewHolder.checkbox.getTag();
                    element.setSelected(buttonView.isChecked());
                }
            });
            view.setTag(viewHolder);
            viewHolder.checkbox.setTag(mSensorList.get(position));
        } else {
            view = convertView;
            ((ViewHolder) view.getTag()).checkbox.setTag(mSensorList.get(position));
        }
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.text.setText(mSensorList.get(position).getName());
        holder.checkbox.setChecked(mSensorList.get(position).isSelected());
        return view;
    }
}
