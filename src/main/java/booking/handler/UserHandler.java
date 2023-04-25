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
import booking.entity.User;
import booking.service.api.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserHandler {
    private final UserService userService;

    public UserHandler(UserService userService){
        this.userService = userService;
    }

    @RequestMapping("/user/login")
    public @ResponseBody Message loginUser(@RequestParam("account") String account,
                                           @RequestParam("passwd") String passwd,
                                           HttpSession session){
        // 用户不存在
        if(userService.findUser(account)==0){
            return new Message(account + "@Login", 202);
        }
        User user = userService.login(account, passwd);
        int code = 201;
        // 密码正确
        if (user!=null){
            session.setAttribute("user", user);
            code = 200;
        }
        return new Message(account + "@login", code);
    }

    @RequestMapping("/user/sign/in")
    public @ResponseBody Message signInUser(){


        return null;
    }
}
