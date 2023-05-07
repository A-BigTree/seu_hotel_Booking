/**
 * ==================================================
 * Project: seu_hotel_Booking
 * Package: booking.entity
 * =====================================================
 * Title: QueryOptions.java
 * Created: [2023/5/7 21:48] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/5/7, created by Shuxin-Wang.
 * 2.
 */

package booking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryOptions {
    //目的地范围
    private Integer startDest;
    private Integer endDest;
    // 星级范围
    private List<Integer> stars;
    // 评分范围
    private Double startPoint;
    private Double endPoint;
    // 可选目的地范围
    private List<Integer> destList;
    // 是否查询订单记录
    private boolean isQueryRecord;
    // 时间范围
    private Date dateIn;
    private Date dateOut;
    //是否查询房间表
    private boolean isQueryRoom;
    // 房间选择
    private Integer peopleNum;
    private Integer roomNum;
    // 价格范围
    private BigDecimal startPrice;
    private BigDecimal endPrice;
}
