/**
 * ==================================================
 * Project: seu_hotel_Booking
 * Package: booking
 * =====================================================
 * Title: HotelInfoTest.java
 * Created: [2023/4/20 16:07] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/4/20, created by Shuxin-Wang.
 * 2.
 */

package booking;

import booking.entity.HotelInfo;
import booking.service.api.HotelInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@Slf4j
@ContextConfiguration(value = {"classpath:spring-persist.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class HotelInfoTest {
    @Autowired
    private HotelInfoService hotelInfoService;

    @Test
    public void testApp(){
        log.debug("Testing...");
    }

    @Test
    public void testSearchHotel(){
        HotelInfo hotelInfo = new HotelInfo();
        hotelInfo.setDestId(110118);
        hotelInfo.setDestParentId(110119);
        List<HotelInfo> hotelInfos = hotelInfoService.queryHotels(hotelInfo, 1);
        log.info(String.valueOf(hotelInfos.size()));
        log.info(hotelInfos.toString());
    }
}
