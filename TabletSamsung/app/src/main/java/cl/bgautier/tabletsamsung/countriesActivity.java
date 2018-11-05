package cl.bgautier.tabletsamsung;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class countriesActivity extends AppCompatActivity {

    private ListView lv;
    ArrayList<HashMap<String, String>> countriesList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);
        countriesList = new ArrayList<>();
        get_data();

        lv = findViewById(R.id.lv);
        //lv.setAdapter(new ArrayAdapter<String>(countriesActivity.this,R.layout.activity_countries, countriesList));

        ListAdapter adapter = new SimpleAdapter(
                countriesActivity.this, countriesList,
                R.layout.activity_list_item, new String[]{"country", "population",
                "density"}, new int[]{R.id.name,
                R.id.population, R.id.density});

        lv.setAdapter(adapter);

    }

    private void get_data() {
        String json;
        try {
            //para country population
            InputStream is = getAssets().open("country-by-population.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(json);

            // to population density
            InputStream as = getAssets().open("country-by-population-density.json");
            size = as.available();
            buffer = new byte[size];
            as.read(buffer);
            as.close();

            String json_a = new String(buffer, "UTF-8");
            JSONArray jsonArray_density = new JSONArray(json_a);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                JSONObject object_density = jsonArray_density.getJSONObject(i);

                HashMap<String, String> countri = new HashMap<String, String>();
                countri.put("country", object.get("country").toString());
                countri.put("population", object.get("population").toString());
                countri.put("density", object_density.get("density").toString());
                countriesList.add(countri);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
