package xyz.arkarhein.asartaline.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.mmtextview.components.MMTextView;

import java.util.List;

import butterknife.BindView;
import xyz.arkarhein.asartaline.R;
import xyz.arkarhein.asartaline.data.vo.MealShopVO;
import xyz.arkarhein.asartaline.delegates.MealShopItemDelegate;

public class ShopListViewHolder extends BaseViewHolder<MealShopVO> {

    @BindView(R.id.iv_shop)
    ImageView ivShop;

    @BindView(R.id.tv_shop_name)
    MMTextView tvShopName;

    @BindView(R.id.tv_shop_address_township)
    MMTextView tvAddress;

    @BindView(R.id.tv_shop_address_location)
    MMTextView tvLocation;

    private MealShopItemDelegate mDelegate;

    private MealShopVO mealShopVO;

    public ShopListViewHolder(View itemView, MealShopItemDelegate mealShopItemDelegate) {
        super(itemView);
        mDelegate = mealShopItemDelegate;
    }

    @Override
    public void setData(MealShopVO data) {
        mealShopVO = data;
        tvShopName.setText(data.getName());
        tvAddress.setText(data.getTownship());
        tvLocation.setText(data.getAddress());
        Glide.with(ivShop.getContext())
                .load(data.getShopImages().get(0))
                .into(ivShop);
    }

    @Override
    public void onClick(View v) {
        mDelegate.onTapMealShop(mealShopVO);
    }
}
