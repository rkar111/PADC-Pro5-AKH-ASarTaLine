package xyz.arkarhein.asartaline.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import org.mmtextview.components.MMTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.arkarhein.asartaline.R;
import xyz.arkarhein.asartaline.data.vo.MealShopVO;
import xyz.arkarhein.asartaline.mvp.presenters.ShopDetailPresenter;
import xyz.arkarhein.asartaline.mvp.views.ShopDetailView;

public class ShopDetailActivity extends BaseActivity implements ShopDetailView {

    @BindView(R.id.iv_shop_detail)
    ImageView ivShopDetail;

    @BindView(R.id.tv_shop_detail_name)
    MMTextView tvShopDetailName;

    @BindView(R.id.tv_shop_detail_address_township)
    MMTextView tvTownship;

    @BindView(R.id.tv_shop_detail_address_location)
    MMTextView tvAddress;

    private static final String ID = "id";

    public static Intent newIntent(Context context, String id) {
        Intent intent = new Intent(context, ShopDetailActivity.class);
        intent.putExtra(ID, id);
        return intent;
    }

    private ShopDetailPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);
        ButterKnife.bind(this, this);
        mPresenter = ViewModelProviders.of(this).get(ShopDetailPresenter.class);
        mPresenter.initPresenter(this);
        String id = getIntent().getStringExtra(ID);
        mPresenter.getMealShopLD(id).observe(this, new Observer<MealShopVO>() {
            @Override
            public void onChanged(@Nullable MealShopVO mealShopVO) {
                setData(mealShopVO);
            }
        });
    }

    public void setData(MealShopVO data) {
        Glide.with(ivShopDetail.getContext())
                .load(data.getShopImages().get(1))
                .into(ivShopDetail);
        tvShopDetailName.setText(data.getName());
        tvTownship.setText(data.getTownship());
        tvAddress.setText(data.getAddress());
    }


}
