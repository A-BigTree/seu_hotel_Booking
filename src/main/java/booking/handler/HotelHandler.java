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
import booking.entity.Room;
import booking.service.api.HotelInfoService;
import booking.utils.PrefixUtils;
import booking.utils.QueryUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
                               HttpSession session,
                               Model model) throws JsonProcessingException {
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
        session.setAttribute("options", options);
        model.addAttribute("optionsO", options);
        model.addAttribute("options", new ObjectMapper().writeValueAsString(options));
        return "search";
    }

    @RequestMapping("/hotel/search/options")
    public @ResponseBody PageInfo<HotelInfo> searchHotel(@RequestBody QueryOptions options) {
        PageInfo<HotelInfo> hotelInfoPageInfo = hotelInfoService.queryHotels(options, options.getPageNum());
        PrefixUtils.initHotelsPageImage(hotelInfoPageInfo.getList());
        return hotelInfoPageInfo;
    }

    @RequestMapping("/hotel/info")
    public String getHotel(@RequestParam("hotelId") Integer hotelId,
                           HttpSession session,
                           Model model) throws JsonProcessingException {
        QueryOptions options = (QueryOptions) session.getAttribute("options");
        // 获取酒店基本信息
        HotelInfo hotelInfo = hotelInfoService.getHotel(hotelId);
        if(options==null){
            options = QueryUtils.getSearchDestId(hotelInfo.getDestId());
            options.setDateInOut("");
            options.setPeopleNum(2);
            options.setRoomNum(1);
            options.setPageNum(1);
            session.setAttribute("options", options);
        }
        options.setHotelId(hotelId);
        // 初始化时间
        QueryUtils.initDateInOut(options, options.getDateInOut());
        // 获取酒店图片
        PrefixUtils.initHotelImages(hotelInfo);
        // 获取酒店城市层次
        ArrayList<City> parentCities = new ArrayList<>();
        City city1 = hotelInfoService.getCity(hotelInfo.getDestId());
        City city2 = hotelInfoService.getCity(city1.getLevelId());
        City city3 = hotelInfoService.getCity(city2.getLevelId());
        parentCities.add(city3);
        parentCities.add(city2);
        parentCities.add(city1);
        model.addAttribute("parentCities", parentCities);
        // 获取酒店详细描述
        hotelInfo.setDescriptions(hotelInfoService.getDescriptions(hotelInfo.getHotelId()));
        // 获取酒店政策
        hotelInfo.setPolicies(hotelInfoService.getPolicies(hotelInfo.getHotelId()));
        model.addAttribute("options", new ObjectMapper().writeValueAsString(options));
        model.addAttribute("hotel", hotelInfo);
        return "hotel-info";
    }

    @RequestMapping("/hotel/rooms")
    public @ResponseBody List<Room> getRooms(@RequestBody QueryOptions options){
        if(options.getDateInOut().equals("")){
            return hotelInfoService.getRooms(options.getHotelId());
        }
        return null;
    }
}
