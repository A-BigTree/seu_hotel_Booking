/**
 * ==================================================
 * Project: seu_hotel_Booking
 * Package: booking.mapper
 * =====================================================
 * Title: HotelInfoMapper.java
 * Created: [2023/4/20 15:07] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/4/20, created by Shuxin-Wang.
 * 2.
 */


package booking.mapper;

import booking.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HotelInfoMapper {

    List<HotelInfo> selectHotelByParams(QueryOptions options);

    Integer selectHotelSumByParams(QueryOptions options);

    HotelInfo selectHotelById(Integer hotelId);

    List<Description> selectDesById(Integer hotelId);

    List<Room> selectRoomById(Integer hotelId);

    List<Policy> selectPoliesById(Integer hotelId);

}
