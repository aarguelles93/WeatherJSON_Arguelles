package com.uninorte.andresarguelles.weatherjson_arguelles;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Andres Arguelles on 24/04/2015.
 */
public class Frag2 extends Fragment{
    private static final String ARG_SECTION_NUMBER = "section_number";
    private EditText mEditTextDay1;
    private EditText mEditTextDay2;
    private EditText mEditTextDay3;
    private EditText mEditTextDay4;
    private EditText mEditTextDay5;

    private Button mButton;
    private boolean mStarted;

    private String uriAPI;
    HandleJSON obj;

    public static Frag2 newInstance(int sectionNumber){
        Frag2 fragment = new Frag2();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_frag2, container, false);

        uriAPI="http://api.openweathermap.org/data/2.5/forecast/daily?q=Barranquilla,CO&units=mentric&cnt=5&mode=json";

        mEditTextDay1 = (EditText) rootView.findViewById(R.id.editTextMainWeather);
        mEditTextDay2 = (EditText) rootView.findViewById(R.id.editTextDescriptionWeather);
        mEditTextDay3 = (EditText) rootView.findViewById(R.id.editTextTemperature);
        mEditTextDay4 = (EditText) rootView.findViewById(R.id.editTextHumidity);
        mEditTextDay5 = (EditText) rootView.findViewById(R.id.editTextPressure);

        mButton = (Button) rootView.findViewById(R.id.buttonForecast);
        mButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String msg="Loading forecast";
                Toast toast = Toast.makeText(getActivity().getApplicationContext(), msg, Toast.LENGTH_LONG);
                toast.show();

                obj = new HandleJSON(uriAPI);
                obj.fetchJSON(2);

                String txt;
                while (!obj.parsingComplete);
                txt = "General desc: "+obj.listMainWeather.get(0)+"\n";
                txt += "Description: "+obj.listDescriptionWeather.get(0)+"\n";
                txt += "Day Temperature: "+obj.listTemperature.get(0)+"\n";
                txt += "Pressure: "+obj.listPressure.get(0)+"\n";
                txt += "Humidity: "+obj.listHumidity.get(0)+"\n";
                mEditTextDay1.setText(txt);
                txt = "General desc: "+obj.listMainWeather.get(1)+"\n";
                txt += "Description: "+obj.listDescriptionWeather.get(1)+"\n";
                txt += "Day Temperature: "+obj.listTemperature.get(1)+"\n";
                txt += "Pressure: "+obj.listPressure.get(1)+"\n";
                txt += "Humidity: "+obj.listHumidity.get(1)+"\n";
                mEditTextDay2.setText(txt);
                txt = "General desc: "+obj.listMainWeather.get(2)+"\n";
                txt += "Description: "+obj.listDescriptionWeather.get(2)+"\n";
                txt += "Day Temperature: "+obj.listTemperature.get(2)+"\n";
                txt += "Pressure: "+obj.listPressure.get(2)+"\n";
                txt += "Humidity: "+obj.listHumidity.get(2)+"\n";
                mEditTextDay3.setText(txt);
                txt = "General desc: "+obj.listMainWeather.get(3)+"\n";
                txt += "Description: "+obj.listDescriptionWeather.get(3)+"\n";
                txt += "Day Temperature: "+obj.listTemperature.get(3)+"\n";
                txt += "Pressure: "+obj.listPressure.get(3)+"\n";
                txt += "Humidity: "+obj.listHumidity.get(3)+"\n";
                mEditTextDay4.setText(txt);
                txt = "General desc: "+obj.listMainWeather.get(4)+"\n";
                txt += "Description: "+obj.listDescriptionWeather.get(4)+"\n";
                txt += "Day Temperature: "+obj.listTemperature.get(4)+"\n";
                txt += "Pressure: "+obj.listPressure.get(4)+"\n";
                txt += "Humidity: "+obj.listHumidity.get(4)+"\n";
                mEditTextDay5.setText(txt);
                /*
                mEditTextMainWeather.setText(obj.getMainWeather());
                mEditTextDescriptionWeather.setText(obj.getDescriptionWeather());
                mEditTextTemperature.setText(obj.getTemperature());
                mEditTextHumidity.setText(obj.getHumidity());
                mEditTextPressure.setText(obj.getPressure());
                */
            }
        });
        return rootView;
    }
}
