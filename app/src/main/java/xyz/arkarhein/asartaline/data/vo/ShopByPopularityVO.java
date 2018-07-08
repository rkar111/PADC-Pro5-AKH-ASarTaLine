package xyz.arkarhein.asartaline.data.vo;

import com.google.gson.annotations.SerializedName;

public class ShopByPopularityVO {
    @SerializedName("shopByDistanceId")
    private String shopByPopularityId;

    @SerializedName("mealShop")
    private MealShopVO mealShop;

    public String getShopByPopularityId() {
        return shopByPopularityId;
    }

    public MealShopVO getMealShop() {
        return mealShop;
    }
}
