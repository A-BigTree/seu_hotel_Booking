/**
 * ==================================================
 * Project: seu_hotel_Booking
 * Package: booking.handler
 * =====================================================
 * Title: UserHandler.java
 * Created: [2023/4/20 17:31] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/4/20, created by Shuxin-Wang.
 * 2.
 */

package booking.handler;

import booking.entity.Message;
import booking.service.api.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserHandler {
    private final UserService userService;

    public UserHandler(UserService userService){
        this.userService = userService;
    }

    @RequestMapping("/user/login")
    public @ResponseBody Message loginUser(Model model){


        return null;
    }
}
