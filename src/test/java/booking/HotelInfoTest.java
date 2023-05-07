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
import booking.entity.QueryOptions;
import booking.service.api.HotelInfoService;
import booking.utils.QueryUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
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
        QueryOptions options = QueryUtils.getSearchDestId(11);
        options.setQueryRoom(true);
        options.setPeopleNum(2);
        options.setRoomNum(1);
        ArrayList<Integer> stars = new ArrayList<>();
        stars.add(4);
        stars.add(2);
        options.setStars(stars);
        log.info(hotelInfoService.queryHotelsSum(options).toString());
        List<HotelInfo> hotelInfos = hotelInfoService.queryHotels(options, 1);
        log.info(String.valueOf(hotelInfos.size()));
        log.info(hotelInfos.toString());
    }
}
