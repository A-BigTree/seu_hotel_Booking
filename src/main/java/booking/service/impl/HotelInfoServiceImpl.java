/**
 * ==================================================
 * Project: seu_hotel_Booking
 * Package: booking.service.impl
 * =====================================================
 * Title: HotelInfoServiceImpl.java
 * Created: [2023/4/20 15:11] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/4/20, created by Shuxin-Wang.
 * 2.
 */

package booking.service.impl;

import booking.mapper.HotelInfoMapper;
import booking.service.api.HotelInfoService;
import org.springframework.stereotype.Service;

@Service
public class HotelInfoServiceImpl implements HotelInfoService {
    private HotelInfoMapper hotelInfoMapper;

    public HotelInfoServiceImpl(HotelInfoMapper hotelInfoMapper){
        this.hotelInfoMapper = hotelInfoMapper;
    }
}
