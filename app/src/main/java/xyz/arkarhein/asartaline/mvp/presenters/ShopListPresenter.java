package xyz.arkarhein.asartaline.mvp.presenters;

import android.arch.lifecycle.MutableLiveData;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import xyz.arkarhein.asartaline.data.model.ASarTaLineModel;
import xyz.arkarhein.asartaline.data.vo.MealShopVO;
import xyz.arkarhein.asartaline.delegates.MealShopItemDelegate;
import xyz.arkarhein.asartaline.events.RestApiEvent;
import xyz.arkarhein.asartaline.mvp.views.ShopListView;

public class ShopListPresenter extends BasePresenter<ShopListView> implements MealShopItemDelegate {

    private MutableLiveData<List<MealShopVO>> mMealShopListLD;

    @Override
    public void initPresenter(ShopListView mView) {
        super.initPresenter(mView);
        mMealShopListLD = new MutableLiveData<>();
        ASarTaLineModel.getObjInstance().startLoadingASarTaLine(mMealShopListLD, mErrorLD);
    }

    public MutableLiveData<List<MealShopVO>> getmMealShopListLD() {
        return mMealShopListLD;
    }

    @Override
    public void onTapMealShop(MealShopVO mealShopVO) {
        mView.launchMealShopDetail(mealShopVO.getShopId());
    }
}
