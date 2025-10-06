package java.witchoy.wimusic_android.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.witchoy.wimusic_android.data.repository.ModelRepository;
import java.witchoy.wimusic_android.model.Track;

public class TrackViewModel extends AndroidViewModel {

    private final MutableLiveData<ArrayList<Track>> _tracks = new MutableLiveData<>();
    private final ModelRepository _repository;

    public TrackViewModel(@NonNull Application application) {
        super(application);
        _repository = new ModelRepository();
        loadData(application);
    }

    private void loadData(Application context) {
        _repository.findTracks(_tracks);
    }

    public LiveData<ArrayList<Track>> getAllTracks() {
        return _tracks;
    }

}
