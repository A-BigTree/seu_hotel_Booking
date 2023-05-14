/**
 * ==================================================
 * Project: seu_hotel_Booking
 * Package: booking
 * =====================================================
 * Title: BookingTest.java
 * Created: [2023/4/20 16:08] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/4/20, created by Shuxin-Wang.
 * 2.
 */

package booking;

import booking.entity.BookingManager;
import booking.entity.QueryOptions;
import booking.service.api.BookingService;
import booking.utils.QueryUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@Slf4j
@ContextConfiguration(value = {"classpath:spring-persist.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class BookingTest {
    @Autowired
    private BookingService bookingService;

    @Test
    public void testApp(){
        log.debug("Testing...");
    }

    /*
    @Test
    public void testAddBooking(){
        BookingManager bookingManager = new BookingManager();
        bookingManager.setUserId(1);
        bookingManager.setHotelId(1);
        bookingManager.setRoomIndex(1);
        QueryOptions options = new QueryOptions();
        QueryUtils.initDateInOut(options, "05/16/2023-05/17/2023");
        bookingManager.setCheckInDate(options.getDateIn());
        bookingManager.setCheckOutDate(options.getDateOut());
        bookingManager.setPrice(BigDecimal.valueOf(300));
        bookingManager.setBookNum(1);
        Integer res = bookingService.toBooking(bookingManager);
        log.info(res.toString());
    }*/
}
