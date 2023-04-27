/**
 * ==================================================
 * Project: seu_hotel_Booking
 * Package: booking.entity
 * =====================================================
 * Title: BookingInfo.java
 * Created: [2023/4/27 13:57] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/4/27, created by Shuxin-Wang.
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
public class BookingInfo {
    // 预定ID
    private Integer bookId;
    //用户ID
    private Integer userId;
    // 预定酒店ID
    private HotelInfo hotelInfo;
    // 预定房间
    private Room room;
    // 入住日期
    private Date checkInDate;
    // 离店日期
    private Date checkOutDate;
    // 下单时间
    private Timestamp bookTime;
    //购买价格
    private BigDecimal price;
}
