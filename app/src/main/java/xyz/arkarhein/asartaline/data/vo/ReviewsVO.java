package xyz.arkarhein.asartaline.data.vo;

import com.google.gson.annotations.SerializedName;

public class ReviewsVO {

    @SerializedName("reviewId")
    private String reviewId;

    @SerializedName("review")
    private String review;

    @SerializedName("userId")
    private String userId;

    @SerializedName("userName")
    private String userName;

    @SerializedName("userImage")
    private String userImage;

    @SerializedName("timestamp")
    private String timeStamp;

    public String getReviewId() {
        return reviewId;
    }

    public String getReview() {
        return review;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserImage() {
        return userImage;
    }

    public String getTimeStamp() {
        return timeStamp;
    }
}
