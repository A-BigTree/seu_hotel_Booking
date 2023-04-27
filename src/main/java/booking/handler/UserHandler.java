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
import booking.service.api.BookingService;
import booking.service.api.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

@Controller
public class UserHandler {
    private final UserService userService;
    private final BookingService bookingService;

    public UserHandler(UserService userService,
                       BookingService bookingService) {
        this.userService = userService;
        this.bookingService = bookingService;
    }

    private void removeSessionUser(HttpSession session){
        if (session.getAttribute("user") != null) {
            session.removeAttribute("user");
        }
        if (session.getAttribute("bookNum")!=null){
            session.removeAttribute("bookNum");
        }
    }

    private void setSessionUser(HttpSession session, User user) {
        removeSessionUser(session);
        session.setAttribute("user", user);
        session.setAttribute("bookNum",
                bookingService.getUserBooking(user.getUserId()).size());
    }

    /**
     * 用户登陆功能实现
     *
     * @param account 登陆账户邮箱
     * @param passwd  登陆密码
     * @param session 会话域对象
     * @return `Message` 对象，正确code为200，出现错误为201
     */
    @RequestMapping("/user/login")
    public @ResponseBody Message loginUser(@RequestParam("account") String account,
                                           @RequestParam("passwd") String passwd,
                                           HttpSession session) {
        // 用户不存在
        if (userService.findUser(account) == 0) {
            return new Message(account + "@Login", 202);
        }
        User user = userService.login(account, passwd);
        int code = 201;
        // 密码正确
        if (user != null) {
            setSessionUser(session, user);
            code = 200;
        }
        return new Message(session.getServletContext().getContextPath() + "/", code);
    }

    /**
     * 用户注册功能实现
     *
     * @param account 邮箱账户
     * @param passwd  账户密码
     * @param name    姓名
     * @param phone   电话号码
     * @param session 会话域对象
     * @return Message对象
     */
    @RequestMapping("/user/sign/in")
    public @ResponseBody Message signInUser(@RequestParam("account") String account,
                                            @RequestParam("passwd") String passwd,
                                            @RequestParam("name") String name,
                                            @RequestParam("phone") String phone,
                                            HttpSession session) {
        // 用户已存在
        if (userService.findUser(account) != 0) {
            return new Message("账户邮箱已存在!请更换邮箱或登陆!", 201);
        }
        User user = new User(0, account, passwd, name, account, phone, BigDecimal.valueOf(0));
        //添加用户失败
        if (userService.signUp(user) == -1) {
            return new Message("注册失败!服务器错误!", 201);
        }
        // 注册成功
        setSessionUser(session, user);
        return new Message(session.getServletContext().getContextPath() + "/", 200);
    }

    @RequestMapping("/user/logout")
    public String logoutUser(HttpSession session){
        removeSessionUser(session);
        return "redirect:/";
    }

    @RequestMapping("/user/passwd/forget")
    public @ResponseBody Message findUser(HttpServletRequest request,
                                          @RequestParam("account") String account){
        if(userService.findUser(account)==0){
            return new Message("用户不存在!请重试!", 201);
        }
        return new Message(request.getContextPath() + "/user/password?account=" + account, 200);
    }

    @RequestMapping("/user/password")
    public String mappingToPasswdPage(@RequestParam("account") String account,
                                      Model model){
        model.addAttribute("account", account);
        return "password";
    }

    @RequestMapping("/user/password/change")
    public @ResponseBody Message changePasswd(@RequestParam("account") String account,
                                              @RequestParam("passwd") String newPasswd,
                                              HttpSession session){
        User user = new User();
        user.setAccountNumber(account);
        user.setPasswd(newPasswd);
        try{
            Integer result = userService.modifyInfo(user);
            if(result==-1){
                return new Message("用户错误!请联系管理员!", 201);
            }
        }catch (Exception e){
            return new Message("服务器错误!请联系管理员!", 201);
        }
        removeSessionUser(session);
        return new Message(session.getServletContext().getContextPath() + "/user", 200);
    }
}
