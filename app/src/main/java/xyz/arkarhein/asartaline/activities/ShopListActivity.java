package xyz.arkarhein.asartaline.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.arkarhein.asartaline.R;
import xyz.arkarhein.asartaline.adapters.ShopListAdapter;
import xyz.arkarhein.asartaline.components.EmptyViewPod;
import xyz.arkarhein.asartaline.components.SmartRecyclerView;
import xyz.arkarhein.asartaline.components.SmartScrollListener;
import xyz.arkarhein.asartaline.data.vo.MealShopVO;
import xyz.arkarhein.asartaline.mvp.presenters.ShopListPresenter;
import xyz.arkarhein.asartaline.mvp.views.ShopListView;

public class ShopListActivity extends BaseActivity implements ShopListView {


    @BindView(R.id.rv_shop_list)
    SmartRecyclerView rvShopList;

    @BindView(R.id.vp_empty_news)
    EmptyViewPod vpEmpty;

    private ShopListAdapter mAdapter;

    private SmartScrollListener mSmartScrollListener;

    private ShopListPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list);
        ButterKnife.bind(this, this);

        mPresenter = ViewModelProviders.of(this).get(ShopListPresenter.class);
        mPresenter.initPresenter(this);

        mAdapter = new ShopListAdapter(getApplicationContext(), mPresenter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false);
        rvShopList.setEmptyView(vpEmpty);
        rvShopList.setAdapter(mAdapter);
        rvShopList.setLayoutManager(linearLayoutManager);

        mSmartScrollListener = new SmartScrollListener(new SmartScrollListener.OnSmartScrollListener() {
            @Override
            public void onListEndReach() {
                Snackbar.make(rvShopList, "This is all the data for NOW.", Snackbar.LENGTH_LONG).show();
                //TODO load more data.
            }
        });
        rvShopList.addOnScrollListener(mSmartScrollListener);

        mPresenter.getmMealShopListLD().observe(this, new Observer<List<MealShopVO>>() {
            @Override
            public void onChanged(@Nullable List<MealShopVO> mealShopVOList) {
                displayShopList(mealShopVOList);
            }
        });

    }

    public void displayShopList(List<MealShopVO> mealShopVOList) {
        mAdapter.appendNewData(mealShopVOList);
    }

    @Override
    public void launchMealShopDetail(String id) {
        Intent intent = ShopDetailActivity.newIntent(getApplicationContext(), id);
        startActivity(intent);
    }
}
