package cl.bgautier.tabletsamsung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String LOG = "New Activity Hackick";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when the user taps the Send button
     */
    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, hackActivity.class);
        startActivity(intent);
    }

    public void colorize(View view) {
        Intent intent = new Intent(this, colorActivity.class);
        startActivity(intent);
    }

    public void relative(View view) {
        Intent intent = new Intent(this, relativeActivity.class);
        startActivity(intent);
    }

    public void countries(View view) {
        Intent intent = new Intent(this, countriesActivity.class);
        startActivity(intent);
    }

}
