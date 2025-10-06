package java.witchoy.wimusic_android;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;

public class TrackAdapter extends RecyclerView.Adapter<TrackViewHolder> {

    private final JSONArray tracks;

    public TrackAdapter(JSONArray data) {
        this.tracks = data;
    }

    @NonNull
    @Override
    public TrackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.track_view_holder, parent, false);
        return new TrackViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrackViewHolder holder, int position) {
        try {
            holder.setTrackTitle(tracks.getJSONObject(position).getString("title"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return tracks.length();
    }
}
