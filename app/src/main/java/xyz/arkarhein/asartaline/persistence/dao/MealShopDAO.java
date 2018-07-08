package xyz.arkarhein.asartaline.persistence.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import xyz.arkarhein.asartaline.data.vo.MealShopVO;

@Dao
public interface MealShopDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertMealShop(MealShopVO... mealShopVO);

}
