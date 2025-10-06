package java.witchoy.wimusic_android.ui;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.witchoy.wimusic_android.R;

public class TrackViewHolder extends RecyclerView.ViewHolder {
    private int _trackId;
    private TextView _trackTitle;

    public TrackViewHolder(@NonNull View itemView) {
        super(itemView);
        _trackTitle = itemView.findViewById(R.id.trackTitle);
    }

    public void setTrackTitle(String title) {
        _trackTitle.setText(title);
    }
}