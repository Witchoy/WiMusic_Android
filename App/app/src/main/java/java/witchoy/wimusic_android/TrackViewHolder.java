package java.witchoy.wimusic_android;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TrackViewHolder extends RecyclerView.ViewHolder {
    private final TextView textView;

    public TrackViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.trackTitle);
    }

    public void setTrackTitle(String title) {
        textView.setText(title);
    }
}