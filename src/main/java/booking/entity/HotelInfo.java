/**
 * ==================================================
 * Project: seu_hotel_Booking
 * Package: booking.entity
 * =====================================================
 * Title: HotelInfo.java
 * Created: [2023/4/17 21:04] by Shuxin-Wang
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

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelInfo {
    // 酒店ID
    private Integer hotelId;
    // 名称
    private String hotelName;
    // 地区编码
    private Integer destId;
    //具体地址
    private String address;
    // 星级
    private Integer star;
    // 图片数量
    private Integer imageNum;
    // 简要描述
    private String simpleDesc;
    // 详细描述
    private List<Description> descriptions;
    // 政策
    private List<Policy> policies;
    // 展示图片路径
    private ImagePath pageImage;
    // 详细页面图片路径
    private List<ImagePath> hotelImages;
}
