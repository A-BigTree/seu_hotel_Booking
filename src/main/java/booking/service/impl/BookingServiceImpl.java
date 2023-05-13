/**
 * ==================================================
 * Project: seu_hotel_Booking
 * Package: booking.service.impl
 * =====================================================
 * Title: BookingServiceImpl.java
 * Created: [2023/4/20 15:15] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/4/20, created by Shuxin-Wang.
 * 2.
 */

package booking.service.impl;

import booking.entity.BookingManager;
import booking.mapper.BookingMapper;
import booking.service.api.BookingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingMapper bookingMapper;

    public BookingServiceImpl(BookingMapper bookingMapper){
        this.bookingMapper = bookingMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public List<BookingManager> getUserBooking(Integer userId) {
        return bookingMapper.selectBookingByUser(userId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<BookingManager> getHotelBooking(Integer hotelId, Integer roomIndex, Date bookDate) {
        return bookingMapper.selectBookingByHotel(hotelId, roomIndex, bookDate);
    }

    @Transactional(readOnly = true)
    @Override
    public BookingManager getBooking(Integer bookId) {
        return bookingMapper.selectBooking(bookId);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public Integer toBooking(BookingManager bookingManager) {
        return bookingMapper.addBooking(bookingManager);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public Integer cancelBooking(Integer bookId) {
        return bookingMapper.removeBooking(bookId);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public Integer changeBooking(BookingManager bookingManager) {
        return bookingMapper.modifyBooking(bookingManager);
    }
}
