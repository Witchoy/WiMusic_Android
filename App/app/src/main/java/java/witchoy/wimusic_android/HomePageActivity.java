package java.witchoy.wimusic_android;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomePageActivity extends AppCompatActivity {

    public HomePageActivity() {
        super(R.layout.activity_home_page);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TrackViewModel tracks = new ViewModelProvider(this).get(TrackViewModel.class);

        RecyclerView recycler = findViewById(R.id.trackList);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        tracks.getAllTracks().observe(this, data -> {
            TrackAdapter adapter = new TrackAdapter(data);
            recycler.setAdapter(adapter);
        });
    }
}