package xyz.arkarhein.asartaline.data.model;

import android.arch.lifecycle.MutableLiveData;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import xyz.arkarhein.asartaline.ASarTaLineApp;
import xyz.arkarhein.asartaline.data.vo.MealShopVO;
import xyz.arkarhein.asartaline.events.RestApiEvent;
import xyz.arkarhein.asartaline.network.responses.GetMealShopResponse;

public class ASarTaLineModel extends BaseModel {

    private static ASarTaLineModel objInstance;

    private Map<String, MealShopVO> mMealShopMap;

    private ASarTaLineModel() {
        super();
        mMealShopMap = new HashMap<>();
    }

    public static ASarTaLineModel getObjInstance() {
        if (objInstance == null) {
            objInstance = new ASarTaLineModel();
        }
        return objInstance;
    }

    public void startLoadingASarTaLine(final MutableLiveData<List<MealShopVO>> mealShopLD, final MutableLiveData<String> errorLD) {
        theApi.loadMealShop(ASarTaLineApp.ACCESS_TOKEN)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetMealShopResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetMealShopResponse getMealShopResponse) {
                        if (getMealShopResponse != null
                                && getMealShopResponse.getAstlMealShop().size() > 0) {

                            mealShopLD.setValue(getMealShopResponse.getAstlMealShop());
                            for (MealShopVO mealShopVO : getMealShopResponse.getAstlMealShop()) {
                                mMealShopMap.put(mealShopVO.getShopId(), mealShopVO);
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorLD.setValue(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public MealShopVO getmMealShopMap(String id) {
        return mMealShopMap.get(id);
    }
}
