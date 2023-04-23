/**
 * ==================================================
 * Project: seu_hotel_Booking
 * Package: booking.service.api
 * =====================================================
 * Title: BookingService.java
 * Created: [2023/4/20 15:15] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/4/20, created by Shuxin-Wang.
 * 2.
 */


package booking.service.api;

import booking.entity.BookingManager;

import java.sql.Date;
import java.util.List;

public interface BookingService {
    List<BookingManager> getUserBooking(Integer userId);

    List<BookingManager> getHotelBooking(Integer hotelId, Integer roomIndex, Date bookDate);

    Integer toBooking(BookingManager bookingManager);

    Integer cancelBooking(Integer bookId);

    Integer changeBooking(BookingManager bookingManager);
}
