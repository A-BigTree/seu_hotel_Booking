/**
 * ==================================================
 * Project: seu_hotel_Booking
 * Package: booking.mapper
 * =====================================================
 * Title: BookingMapper.java
 * Created: [2023/4/20 15:13] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/4/20, created by Shuxin-Wang.
 * 2.
 */


package booking.mapper;

import booking.entity.BookingManager;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface BookingMapper {
    List<BookingManager> selectBookingByUser(Integer userId);

    BookingManager selectBooking(Integer bookId);

    List<BookingManager> selectBookingByHotel(@Param("hotelId") Integer hotelId,
                                              @Param("roomIndex") Integer roomIndex,
                                              @Param("bookDate") Date bookDate);

    Integer addBooking(BookingManager bookingManager);

    Integer removeBooking(Integer bookId);

    Integer modifyBooking(BookingManager bookingManager);
}
