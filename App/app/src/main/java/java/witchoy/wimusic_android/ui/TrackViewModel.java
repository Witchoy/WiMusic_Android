package java.witchoy.wimusic_android;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TrackViewModel extends AndroidViewModel {

    private final MutableLiveData<JSONArray> tracks;

    public TrackViewModel(android.app.Application application) {
        super(application);
        tracks = new MutableLiveData<>(new JSONArray());
        loadData(application);
    }

    public LiveData<JSONArray> getAllTracks() {
        return tracks;
    }

    private void loadData(Application context) {
        try {
            InputStream inputStream = context.getResources().openRawResource(R.raw.tracks);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append('\n');
            }
            org.json.JSONObject jsonObject = new org.json.JSONObject(sb.toString());
            JSONArray json = jsonObject.getJSONArray("tracks");
            tracks.setValue(json);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}
