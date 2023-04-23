/**
 * ==================================================
 * Project: seu_hotel_Booking
 * Package: booking.service.api
 * =====================================================
 * Title: UserService.java
 * Created: [2023/4/20 15:18] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/4/20, created by Shuxin-Wang.
 * 2.
 */


package booking.service.api;

import booking.entity.User;

public interface UserService {
    User getUser(Integer userId);

    User login(String userAccount, String passwd);

    Integer findUser(String userAccount);

    Integer signUp(User user);

    Integer removeUser(Integer userId);

    Integer modifyInfo(User user);
}
