package toan.bui.assignment;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyAdapter adapter = new MyAdapter();
        RecyclerView r = findViewById(R.id.temperature);
        r.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false));
        r.setAdapter(adapter);

        Retrofit retrofit = RetrofitClient.getClient();
        APIInterface api = retrofit.create(APIInterface.class);

        Call<List<AccuDatum>> call = api.getWeather("93Qg780lHwYM4SO58n7DFPLqHg4oKADn", "vi-vn", "true");
        call.enqueue(new Callback<List<AccuDatum>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<AccuDatum>> call, Response<List<AccuDatum>> response) {
                if (response.body() == null) {
                    Log.d("response success/", "null body");
                    return;
                }

                dummyData.dummyDataList.clear(); //clear test data

                List<AccuDatum> list = response.body();
                list.forEach(accu -> { //populate dummydata.dataList with fields needed
                    String time = dummyData.convertTime(accu.getDateTime());
                    int icon =  R.drawable.icon; //only 1 image
                    double degree = accu.getTemperature().getValue();
                    dummyData.dummyDataList.add(new dummyData(time, icon, degree));
                });
            adapter.notifyDataSetChanged(); //notify data set changed (dummydata.dataList)
            }
            @Override
            public void onFailure(Call<List<AccuDatum>> call, Throwable t) {
                Log.d("FAIL","faIL");
            }
        });

        /*Call<Void> c = api.get();
        c.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.d("yay", "yay");
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.d("gag", "gagag");
                t.printStackTrace();
            }
        });*/



    }
}