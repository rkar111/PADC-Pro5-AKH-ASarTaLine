package xyz.arkarhein.asartaline.data.vo;

import com.google.gson.annotations.SerializedName;

public class ShopByDistanceVO {

    @SerializedName("shopByDistanceId")
    private String shopByDistanceId;

    @SerializedName("mealShop")
    private MealShopVO mealShop;

    @SerializedName("distanceInFeet")
    private String distanceInFeet;

    public String getShopByDistanceId() {
        return shopByDistanceId;
    }

    public MealShopVO getMealShop() {
        return mealShop;
    }

    public String getDistanceInFeet() {
        return distanceInFeet;
    }
}
