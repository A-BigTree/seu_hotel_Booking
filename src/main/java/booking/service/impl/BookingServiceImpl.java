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

import booking.mapper.BookingMapper;
import booking.service.api.BookingService;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {
    private BookingMapper bookingMapper;

    public BookingServiceImpl(BookingMapper bookingMapper){
        this.bookingMapper = bookingMapper;
    }
}
