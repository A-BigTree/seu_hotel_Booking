/**
 * ==================================================
 * Project: seu_hotel_Booking
 * Package: booking.handler
 * =====================================================
 * Title: ExampleHandler.java
 * Created: [2023/4/9 18:09] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/4/9, created by Shuxin-Wang.
 * 2.
 */

package booking.handler;

import booking.entity.Example;
import booking.entity.HotelInfo;
import booking.service.api.ExampleService;
import booking.utils.PrefixUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ExampleHandler {
    private final ExampleService exampleService;

    public ExampleHandler(ExampleService exampleService){
        this.exampleService = exampleService;
    }

    @RequestMapping("/show/list")
    public String showList(Model model){
        List<Example> exampleList = exampleService.getAll();
        model.addAttribute("examList", exampleList);
        HotelInfo hotelInfo = new HotelInfo();
        hotelInfo.setHotelId(2222);
        PrefixUtils.initPageImage(hotelInfo);
        model.addAttribute("hotelInfo", hotelInfo);
        return "example";
    }

}
