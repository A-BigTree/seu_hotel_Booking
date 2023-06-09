/**
 * ==================================================
 * Project: seu_hotel_Booking
 * Package: booking.entity
 * =====================================================
 * Title: Room.java
 * Created: [2023/4/17 21:05] by Shuxin-Wang
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
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    //酒店ID
    private Integer hotelId;
    //索引
    private Integer roomIndex;
    //名称
    private String roomName;
    //描述
    private String description;
    //描述列表
    private List<Description> descriptions;
    //容量
    private String capacity;
    //价格
    private BigDecimal price;
    // 数量
    private Integer roomNum;
    // 人数
    private Integer peopleNum;
}
