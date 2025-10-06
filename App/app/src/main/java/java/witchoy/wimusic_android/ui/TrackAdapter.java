package java.witchoy.wimusic_android.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.witchoy.wimusic_android.R;
import java.witchoy.wimusic_android.model.Track;

public class TrackAdapter extends RecyclerView.Adapter<TrackViewHolder> {

    private final ArrayList<Track> _tracks;

    public TrackAdapter(ArrayList<Track> data) {
        this._tracks = data;
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
        Track track = _tracks.get(position);
        holder.setTrackTitle(track.getTitle());
    }

    @Override
    public int getItemCount() {
        return _tracks.size();
    }

    public void setData(ArrayList<Track> data) {
        _tracks.clear();
        _tracks.addAll(data);
        notifyDataSetChanged(); // Notify RecyclerView that data has changed
    }
}
