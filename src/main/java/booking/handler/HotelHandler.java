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

import booking.service.api.HotelInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HotelHandler {
    private final HotelInfoService hotelInfoService;

    public HotelHandler(HotelInfoService hotelInfoService){
        this.hotelInfoService = hotelInfoService;
    }

    @RequestMapping("/hotel/search")
    public String searchHotels(@RequestParam("city") String city,
                               @RequestParam("dest") Integer dest,
                               @RequestParam("date") String dateInOut,
                               @RequestParam("people") Integer peopleNum,
                               @RequestParam("rooms") Integer roomsNum,
                               @RequestParam("page") Integer page,
                               Model model){
        model.addAttribute("city", city);
        model.addAttribute("dest", dest);
        model.addAttribute("dateInOut", dateInOut);
        model.addAttribute("peopleNum", peopleNum);
        model.addAttribute("roomsNum", roomsNum);


        return "search";
    }
}
