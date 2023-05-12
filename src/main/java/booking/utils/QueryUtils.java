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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class QueryUtils {
    /**
     * 将目的地ID规范为6为并得到范围Id
     *
     * @param queryDestId 查询目的地Id
     * @return 目的地Id与范围Id的HotelInfo对象
     */
    public static QueryOptions getSearchDestId(Integer queryDestId){
        QueryOptions options = new QueryOptions();
        options.setDest(queryDestId);
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

    public static void initDateInOut(QueryOptions options, String dateInOut){
        options.setDateInOut(dateInOut);
        if (dateInOut.equals("")){
            options.setBookDays(1);
        }else{
            String[] dates = dateInOut.split("-");
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            try{
                Date parse1 = sdf.parse(dates[0]);
                Date parse2 = sdf.parse(dates[1]);
                options.setBookDays((int) ((parse2.getTime()-parse1.getTime())/(24*60*60*1000)));
                options.setDateIn(new java.sql.Date(parse1.getTime()));
                options.setDateOut(new java.sql.Date(parse2.getTime()));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static Map<String, Integer> setSearchPage(Integer totalPage, Integer page){
        HashMap<String, Integer> pageMap = new HashMap<>();
        int startPage = 1, endPage = totalPage;
        if(totalPage > 11){
            if(page >= 6){
                if(page + 5 >= totalPage){
                    startPage = totalPage - 10;
                }else {
                    startPage = page - 5;
                    endPage = page + 5;
                }
            }else{
                endPage = 11;
            }
        }
        pageMap.put("currentPage", page);
        pageMap.put("startPage", startPage);
        pageMap.put("endPage", endPage);
        return pageMap;
    }
}
