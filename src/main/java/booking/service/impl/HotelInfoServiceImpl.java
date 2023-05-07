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

import booking.entity.*;
import booking.mapper.HotelInfoMapper;
import booking.service.api.HotelInfoService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HotelInfoServiceImpl implements HotelInfoService {
    private final HotelInfoMapper hotelInfoMapper;

    public HotelInfoServiceImpl(HotelInfoMapper hotelInfoMapper){
        this.hotelInfoMapper = hotelInfoMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public List<HotelInfo> queryHotels(QueryOptions options, Integer page) {
        PageHelper.startPage(page, 25);
        return hotelInfoMapper.selectHotelByParams(options);
    }

    @Transactional(readOnly = true)
    @Override
    public Integer queryHotelsSum(QueryOptions options) {
        return hotelInfoMapper.selectHotelSumByParams(options);
    }

    @Transactional(readOnly = true)
    @Override
    public HotelInfo getHotel(Integer hotelId) {
        return hotelInfoMapper.selectHotelById(hotelId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Description> getDescriptions(Integer hotelId) {
        return hotelInfoMapper.selectDesById(hotelId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Room> getRooms(Integer hotelId) {
        return hotelInfoMapper.selectRoomById(hotelId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Policy> getPolicies(Integer hotelId) {
        return hotelInfoMapper.selectPoliesById(hotelId);
    }
}
