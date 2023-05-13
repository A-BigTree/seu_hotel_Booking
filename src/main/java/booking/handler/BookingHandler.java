/**
 * ==================================================
 * Project: seu_hotel_Booking
 * Package: booking.handler
 * =====================================================
 * Title: BookingHandler.java
 * Created: [2023/5/13 18:58] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/5/13, created by Shuxin-Wang.
 * 2.
 */

package booking.handler;

import booking.entity.*;
import booking.service.api.BookingService;
import booking.service.api.HotelInfoService;
import booking.service.api.UserService;
import booking.utils.PrefixUtils;
import booking.utils.QueryUtils;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Controller
public class BookingHandler {
    private final BookingService bookingService;
    private final UserService userService;
    private final HotelInfoService hotelInfoService;

    public BookingHandler(BookingService bookingService,
                          UserService userService,
                          HotelInfoService hotelInfoService){
        this.bookingService = bookingService;
        this.userService = userService;
        this.hotelInfoService = hotelInfoService;
    }

    @RequestMapping("/booking/add")
    public @ResponseBody Message bookHotel(@RequestBody BookingManager bookingManager,
                                           HttpSession session){
        QueryUtils.initBookingDate(bookingManager);
        // 获取用户
        User user = (User)session.getAttribute("user");
        if(user==null){
            return new Message("用户断开连接!请重新登陆!", 202);
        }
        // 检查账户余额
        if(user.getBalance().compareTo(bookingManager.getPrice())<0){
            // 余额不足
            return new Message("账户余额不足请充值!", 203);
        }
        // 扣除余额
        User newUser = new User();
        newUser.setUserId(user.getUserId());
        newUser.setBalance(user.getBalance().subtract(bookingManager.getPrice()));
        Integer userResult = userService.modifyInfo(newUser);
        if (userResult < 0){
            return new Message("服务器错误!请联系管理员重试!", 201);
        }
        // 添加预定信息
        bookingManager.setUserId(user.getUserId());
        Integer result = bookingService.toBooking(bookingManager);
        // 添加信息失败
        if(result < 0){
            return new Message("服务器错误!请联系管理员重试!", 201);
        }
        // 重新获取User
        User afterUser = userService.getUser(user.getUserId());
        if(afterUser==null){
            return new Message("服务器错误!请联系管理员重试!", 201);
        }
        // 刷新Session域用户信息
        resetSession(session, afterUser);
        return new Message("预定成功!", 200);
    }

    private void initBookingInfo(List<BookingManager> bookingManagers, Model model){
        ArrayList<HotelInfo> hotelInfos = new ArrayList<>();
        ArrayList<Room> rooms = new ArrayList<>();
        for(BookingManager bookingManager:bookingManagers){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"),
                    sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            bookingManager.setDateInOut(sdf.format(bookingManager.getCheckInDate()) +
                    " - " + sdf.format(bookingManager.getCheckOutDate()));
            rooms.add(hotelInfoService.getRoom(bookingManager.getHotelId(),
                    bookingManager.getRoomIndex()));
            HotelInfo hotelInfo = hotelInfoService.getHotel(bookingManager.getHotelId());
            PrefixUtils.initPageImage(hotelInfo);
            hotelInfo.setSimpleDesc(sdfTime.format(bookingManager.getBookTime()));
            hotelInfo.setCanBook(!bookingManager.getCheckInDate().before(new Date(System.currentTimeMillis())));
            hotelInfos.add(hotelInfo);
        }
        model.addAttribute("hotels", hotelInfos);
        model.addAttribute("rooms", rooms);
    }

    @RequestMapping("/user/booking")
    public String getBookingPage(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        if(user==null){
            return "booking-user";
        }
        List<BookingManager> bookingManagers = bookingService.getUserBooking(user.getUserId());
        model.addAttribute("bookings", bookingManagers);
        initBookingInfo(bookingManagers, model);
        return "booking-user";
    }

    @RequestMapping("/booking/cancel")
    public String cancelBooking(@RequestParam("bookId") Integer bookId,
                                HttpSession session){
        BookingManager bookingManager = bookingService.getBooking(bookId);
        User user = (User) session.getAttribute("user");
        if(user==null){
            return "redirect:/user";
        }
        user.setBalance(user.getBalance().add(bookingManager.getPrice()));
        // 退款
        User newUser = new User();
        newUser.setUserId(user.getUserId());
        newUser.setBalance(user.getBalance());
        userService.modifyInfo(newUser);
        // 删除订单
        bookingService.cancelBooking(bookId);
        // 重新获取User
        User afterUser = userService.getUser(user.getUserId());
        if(afterUser==null){
            return "redirect:/user";
        }
        // 刷新Session域用户信息
        resetSession(session, afterUser);
        return "redirect:/user/booking";
    }

    @RequestMapping("/booking/delete")
    public String deleteBooking(@RequestParam("bookId") Integer bookId,
                                HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user==null){
            return "redirect:/user";
        }
        // 删除订单
        bookingService.cancelBooking(bookId);
        // 重新获取User
        User afterUser = userService.getUser(user.getUserId());
        if(afterUser==null){
            return "redirect:/user";
        }
        // 刷新Session域用户信息
        resetSession(session, afterUser);
        return "redirect:/user/booking";
    }

    private void resetSession(HttpSession session, User afterUser) {
        if (session.getAttribute("user") != null) {
            session.removeAttribute("user");
        }
        if (session.getAttribute("bookNum")!=null){
            session.removeAttribute("bookNum");
        }
        session.setAttribute("user", afterUser);
        session.setAttribute("bookNum",
                bookingService.getUserBooking(afterUser.getUserId()).size());
    }
}
