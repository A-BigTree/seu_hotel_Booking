/**
 * ==================================================
 * Project: seu_hotel_Booking
 * Package: booking.service.api
 * =====================================================
 * Title: HotelInfoService.java
 * Created: [2023/4/20 15:11] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/4/20, created by Shuxin-Wang.
 * 2.
 */


package booking.service.api;

import booking.entity.*;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface HotelInfoService {

    PageInfo<HotelInfo> queryHotels(QueryOptions options, Integer page);

    City getCity(Integer cityId);

    List<City> getLevelCity(Integer cityId);

    HotelInfo getHotel(Integer hotelId);

    List<Description> getDescriptions(Integer hotelId);

    List<Room> getRooms(Integer hotelId);

    Room getRoom(Integer hotelId, Integer roomIndex);

    List<Room> getRoomsByOptions(QueryOptions options);

    List<Policy> getPolicies(Integer hotelId);
}
