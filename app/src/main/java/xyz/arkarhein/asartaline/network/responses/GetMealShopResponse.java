package xyz.arkarhein.asartaline.network.responses;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import xyz.arkarhein.asartaline.data.vo.MealShopVO;

public class GetMealShopResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("astlMealShop")
    private List<MealShopVO> astlMealShop;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public List<MealShopVO> getAstlMealShop() {
        if (astlMealShop == null) {
            astlMealShop = new ArrayList<>();
        }
        return astlMealShop;
    }
}
