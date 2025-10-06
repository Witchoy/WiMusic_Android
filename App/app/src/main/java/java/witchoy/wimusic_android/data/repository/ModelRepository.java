package java.witchoy.wimusic_android.data.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.witchoy.wimusic_android.data.network.WiMusicService;
import java.witchoy.wimusic_android.model.Track;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ModelRepository {
    private final WiMusicService _service;
    private final String API_URL = "http://192.168.1.202:3000/"; // My machine URL

    public ModelRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .build();
        _service = retrofit.create(WiMusicService.class);
    }

    // ****** //
    // Tracks //
    // ****** //

    // Get all tracks
    public void findTracks(MutableLiveData<ArrayList<Track>> data) {
        _service.getTracks().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        JSONObject responseJson = new JSONObject(response.body().string());
                        JSONArray tracksJsonArray = responseJson.getJSONArray("tracks");
                        ArrayList<Track> tracks = new ArrayList<>();
                        for (int i = 0; i < tracksJsonArray.length(); i++) {
                            JSONObject trackJson = tracksJsonArray.getJSONObject(i);
                            
                            // Extract artist name from artists array
                            String artistName = "";
                            JSONArray artistsArray = trackJson.getJSONArray("artists");
                            if (artistsArray.length() > 0) {
                                JSONObject firstArtist = artistsArray.getJSONObject(0);
                                artistName = firstArtist.getString("name");
                            }
                            
                            // Extract album title from albums array
                            String albumTitle = "";
                            JSONArray albumsArray = trackJson.getJSONArray("albums");
                            if (albumsArray.length() > 0) {
                                JSONObject firstAlbum = albumsArray.getJSONObject(0);
                                albumTitle = firstAlbum.getString("title");
                            }
                            
                            // Create track with extracted data
                            Track track = new Track(
                                    trackJson.getInt("id"),
                                    trackJson.getString("title"),
                                    artistName,
                                    albumTitle,
                                    "Unknown", // Genre not available in API response
                                    trackJson.getInt("duration")
                            );
                            tracks.add(track);
                        }
                        Log.d("TrackRepository", "Successfully parsed " + tracks.size() + " tracks");
                        data.postValue(tracks);
                    } catch (JSONException | IOException e) {
                        Log.d("TrackRepository", "Error parsing tracks: " + e.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("TrackRepository", "Error fetching tracks: " + t.getMessage());
            }
        });
    }
}
