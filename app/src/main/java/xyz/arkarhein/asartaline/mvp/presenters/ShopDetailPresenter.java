package xyz.arkarhein.asartaline.mvp.presenters;

import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import xyz.arkarhein.asartaline.data.model.ASarTaLineModel;
import xyz.arkarhein.asartaline.data.vo.MealShopVO;
import xyz.arkarhein.asartaline.mvp.views.ShopDetailView;

public class ShopDetailPresenter extends BasePresenter<ShopDetailView> {

    private MutableLiveData<MealShopVO> mealShopLD;

    @Override
    public void initPresenter(ShopDetailView mView) {
        super.initPresenter(mView);
        mealShopLD = new MutableLiveData<>();
    }

    public MutableLiveData<MealShopVO> getMealShopLD(String id) {
        MealShopVO mealShopVO = ASarTaLineModel.getObjInstance().getmMealShopMap(id);
        mealShopLD.setValue(mealShopVO);
        return mealShopLD;
    }
}
