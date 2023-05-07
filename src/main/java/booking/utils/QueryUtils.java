/**
 * ==================================================
 * Project: seu_hotel_Booking
 * Package: booking.utils
 * =====================================================
 * Title: HotelUtils.java
 * Created: [2023/5/7 17:58] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/5/7, created by Shuxin-Wang.
 * 2.
 */

package booking.utils;

import booking.entity.QueryOptions;

public class QueryUtils {
    /**
     * 将目的地ID规范为6为并得到范围Id
     *
     * @param queryDestId 查询目的地Id
     * @return 目的地Id与范围Id的HotelInfo对象
     */
    public static QueryOptions getSearchDestId(Integer queryDestId){
        QueryOptions options = new QueryOptions();
        int destId, destParentId;
        if(queryDestId < 100){
            destId = queryDestId * 10000;
            destParentId = (queryDestId + 1) *10000;
        } else if (queryDestId < 10000) {
            destId = queryDestId * 100;
            destParentId = (queryDestId + 1) * 100;
        }else{
            destId = queryDestId;
            destParentId = queryDestId + 1;
        }
        options.setStartDest(destId);
        options.setEndDest(destParentId);
        return options;
    }
}
