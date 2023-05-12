/**
 * ==================================================
 * Project: seu_hotel_Booking
 * Package: booking.entity
 * =====================================================
 * Title: BookingManager.java
 * Created: [2023/4/17 21:25] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/4/17, created by Shuxin-Wang.
 * 2.
 */

package booking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingManager {
    // 预定ID
    private Integer bookId;
    //用户ID
    private Integer userId;
    // 预定酒店ID
    private Integer hotelId;
    // 预定房间
    private Integer roomIndex;
    // 入住日期
    private Date checkInDate;
    // 离店日期
    private Date checkOutDate;
    // 下单时间
    private Timestamp bookTime;
    //购买价格
    private BigDecimal price;
    // 预定数量
    private Integer bookNum;
}
