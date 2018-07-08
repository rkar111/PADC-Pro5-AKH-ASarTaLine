package xyz.arkarhein.asartaline.data.vo;

import android.support.design.widget.Snackbar;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WarDeeVO {

    @SerializedName("warDeeId")
    private String warDeeId;

    @SerializedName("name")
    private String name;

    @SerializedName("images")
    private List<String> images;

    @SerializedName("generalTaste")
    private List<GeneralTasteVO> generalTaste;

    @SerializedName("suitedFor")
    private List<SuitedForVO> suitedFor;

    @SerializedName("priceRangeMin")
    private double priceRangeMin;

    @SerializedName("priceRangeMax")
    private double priceRangeMax;

    @SerializedName("matchWarDeeList")
    private List<WarDeeVO> matchWarDeeList;

    @SerializedName("shopByDistance")
    private List<ShopByDistanceVO> shopByDistance;

    @SerializedName("shopByPopularity")
    private List<ShopByPopularityVO> shopByPopularity;

    public String getWarDeeId() {
        return warDeeId;
    }

    public String getName() {
        return name;
    }

    public List<String> getImages() {
        return images;
    }

    public List<GeneralTasteVO> getGeneralTaste() {
        return generalTaste;
    }

    public List<SuitedForVO> getSuitedFor() {
        return suitedFor;
    }

    public double getPriceRangeMin() {
        return priceRangeMin;
    }

    public double getPriceRangeMax() {
        return priceRangeMax;
    }

    public List<WarDeeVO> getMatchWarDeeList() {
        return matchWarDeeList;
    }

    public List<ShopByDistanceVO> getShopByDistance() {
        return shopByDistance;
    }

    public List<ShopByPopularityVO> getShopByPopularity() {
        return shopByPopularity;
    }
}
