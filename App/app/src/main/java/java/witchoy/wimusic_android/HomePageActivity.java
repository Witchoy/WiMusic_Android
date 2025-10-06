package java.witchoy.wimusic_android;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.witchoy.wimusic_android.ui.TrackAdapter;
import java.witchoy.wimusic_android.ui.TrackViewModel;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        TrackViewModel tracks = new ViewModelProvider(this).get(TrackViewModel.class);

        RecyclerView recycler = findViewById(R.id.trackList);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        TrackAdapter adapter = new TrackAdapter(new ArrayList<>());
        recycler.setAdapter(adapter);

        tracks.getAllTracks().observe(this, data -> {
            adapter.setData(data);
        });

    }
}