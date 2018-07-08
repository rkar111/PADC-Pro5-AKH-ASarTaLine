package xyz.arkarhein.asartaline.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.arkarhein.asartaline.R;
import xyz.arkarhein.asartaline.data.vo.MealShopVO;
import xyz.arkarhein.asartaline.delegates.MealShopItemDelegate;
import xyz.arkarhein.asartaline.viewholders.ShopListViewHolder;

public class ShopListAdapter extends BaseRecyclerAdapter<ShopListViewHolder, MealShopVO> {

    private MealShopItemDelegate mDelegate;

    public ShopListAdapter(Context context, MealShopItemDelegate mealShopItemDelegate) {
        super(context);
        mDelegate = mealShopItemDelegate;
    }

    @NonNull
    @Override
    public ShopListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View shopListItemView = mLayoutInflator.inflate(R.layout.item_shops, parent, false);
        return new ShopListViewHolder(shopListItemView, mDelegate);
    }
}
