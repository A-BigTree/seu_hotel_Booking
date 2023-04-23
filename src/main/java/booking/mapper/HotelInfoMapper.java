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

import booking.entity.Description;
import booking.entity.HotelInfo;
import booking.entity.Policy;
import booking.entity.Room;

import java.util.List;

public interface HotelInfoMapper {

    List<HotelInfo> selectHotelByParams(HotelInfo hotelInfo, Integer page);

    HotelInfo selectHotelById(Integer hotelId);

    List<Description> selectDesById(Integer hotelId);

    List<Room> selectRoomById(Integer hotelId);

    List<Policy> selectPoliesById(Integer hotelId);

}
