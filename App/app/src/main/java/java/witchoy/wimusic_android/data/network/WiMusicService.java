package java.witchoy.wimusic_android.data.network;

public interface WiMusicService {
    // Get all tracks
    @GET("tracks")
    Call<ResponseBody> getTracks();
}
