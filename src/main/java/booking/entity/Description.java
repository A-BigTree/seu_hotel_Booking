/**
 * ==================================================
 * Project: seu_hotel_Booking
 * Package: booking.entity
 * =====================================================
 * Title: Description.java
 * Created: [2023/4/17 20:36] by Shuxin-Wang
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

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Description {
    //酒店ID
    private Integer hotelId;
    //描述索引
    private Integer index;
    //详细描述
    private String description;
}
