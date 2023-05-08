/**
 * ==================================================
 * Project: seu_hotel_Booking
 * Package: booking.handler
 * =====================================================
 * Title: HotelHandler.java
 * Created: [2023/5/7 16:35] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/5/7, created by Shuxin-Wang.
 * 2.
 */

package booking.handler;

import booking.entity.City;
import booking.entity.HotelInfo;
import booking.entity.QueryOptions;
import booking.service.api.HotelInfoService;
import booking.utils.PrefixUtils;
import booking.utils.QueryUtils;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@Slf4j
public class HotelHandler {
    private final HotelInfoService hotelInfoService;

    public HotelHandler(HotelInfoService hotelInfoService) {
        this.hotelInfoService = hotelInfoService;
    }

    private Map<String, List<City>> setLevelCities(City city, Integer dest) {
        ArrayList<City> parentCities = new ArrayList<>();
        ArrayList<City> levelCities = null;
        if (dest < 100) {
            levelCities = (ArrayList<City>) hotelInfoService.getLevelCity(city.getCityId());
        } else if (dest < 10000) {
            parentCities.add(hotelInfoService.getCity(city.getLevelId()));
            levelCities = (ArrayList<City>) hotelInfoService.getLevelCity(city.getCityId());
        } else {
            City city1 = hotelInfoService.getCity(city.getLevelId());
            parentCities.add(hotelInfoService.getCity(city1.getLevelId()));
            parentCities.add(city1);
        }
        HashMap<String, List<City>> resultMap = new HashMap<>();
        resultMap.put("parentCities", parentCities);
        resultMap.put("levelCities", levelCities);
        return resultMap;
    }

    @RequestMapping("/hotel/search")
    public String searchHotels(@RequestParam("dest") Integer dest,
                               @RequestParam("date") String dateInOut,
                               @RequestParam("people") Integer peopleNum,
                               @RequestParam("rooms") Integer roomsNum,
                               @RequestParam("page") Integer page,
                               Model model) {
        QueryOptions options = QueryUtils.getSearchDestId(dest);
        City city = hotelInfoService.getCity(dest);
        model.addAttribute("city", city);
        model.addAllAttributes(this.setLevelCities(city, dest));
        try {
            QueryUtils.initDateInOut(options, dateInOut);
        } catch (RuntimeException e) {
            log.error(e.toString());
        }
        options.setPeopleNum(peopleNum);
        options.setRoomNum(roomsNum);
        options.setPageNum(page);
        PageInfo<HotelInfo> hotelInfoPageInfo = hotelInfoService.queryHotels(options, page);
        PrefixUtils.initHotelsPageImage(hotelInfoPageInfo.getList());
        model.addAttribute("options", options);
        model.addAttribute("hotelResult", hotelInfoPageInfo);
        return "search";
    }
}
