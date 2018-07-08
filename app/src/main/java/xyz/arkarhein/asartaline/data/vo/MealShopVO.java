package xyz.arkarhein.asartaline.data.vo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "mealShop")
public class MealShopVO {

    @NonNull
    @PrimaryKey
    @SerializedName("shopId")
    private String shopId;

    @ColumnInfo(name = "name")
    @SerializedName("name")
    private String name;

    @ColumnInfo(name = "address")
    @SerializedName("address")
    private String address;

    @ColumnInfo(name = "lat")
    @SerializedName("lat")
    private double lat;

    @ColumnInfo(name = "lng")
    @SerializedName("lng")
    private double lng;

    @ColumnInfo(name = "township")
    @SerializedName("township")
    private String township;

    @ColumnInfo(name = "popularity")
    @SerializedName("popularity")
    private double popularity;

    @ColumnInfo(name = "shopImages")
    @SerializedName("shopImages")
    private List<String> shopImages;

    @SerializedName("reviews")
    @Ignore
    private List<ReviewsVO> reviews;

    public String getShopId() {
        return shopId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public String getTownship() {
        return township;
    }

    public double getPopularity() {
        return popularity;
    }

    public List<String> getShopImages() {
        return shopImages;
    }

    public List<ReviewsVO> getReviews() {
        return reviews;
    }

    public void setShopId(@NonNull String shopId) {
        this.shopId = shopId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public void setTownship(String township) {
        this.township = township;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public void setShopImages(List<String> shopImages) {
        this.shopImages = shopImages;
    }

    public void setReviews(List<ReviewsVO> reviews) {
        this.reviews = reviews;
    }
}
