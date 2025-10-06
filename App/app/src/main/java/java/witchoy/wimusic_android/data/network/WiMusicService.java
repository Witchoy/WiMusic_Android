package java.witchoy.wimusic_android.data.network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface WiMusicService {
    @GET("Tracks")
    Call<ResponseBody> getTracks();
}
