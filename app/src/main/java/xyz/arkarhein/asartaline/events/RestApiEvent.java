package xyz.arkarhein.asartaline.events;

import java.util.List;

import xyz.arkarhein.asartaline.data.vo.MealShopVO;

public class RestApiEvent {

    public static class EmptyResponseEvent {

    }

    public static class ErrorInvokingAPIEvent {
        private String errorMsg;

        public ErrorInvokingAPIEvent(String errorMsg) {
            this.errorMsg = errorMsg;
        }

        public String getErrorMsg() {
            return errorMsg;
        }

    }

    public static class MealShopDataLoadedEvent {
        private List<MealShopVO> loadMealShop;

        public MealShopDataLoadedEvent(List<MealShopVO> loadMealShop) {
            this.loadMealShop = loadMealShop;
        }

        public List<MealShopVO> getLoadMealShop() {
            return loadMealShop;
        }
    }
}
