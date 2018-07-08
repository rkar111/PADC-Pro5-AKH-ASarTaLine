package xyz.arkarhein.asartaline.network;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import xyz.arkarhein.asartaline.network.responses.GetMealShopResponse;

public interface ASarTaLineApi {

    @FormUrlEncoded
    @POST("GetMealShop.php")
    Observable<GetMealShopResponse> loadMealShop(@Field("access_token") String accessToken);
}
