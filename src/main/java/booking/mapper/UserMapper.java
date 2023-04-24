/**
 * ==================================================
 * Project: seu_hotel_Booking
 * Package: booking.mapper
 * =====================================================
 * Title: UserMapper.java
 * Created: [2023/4/20 15:17] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/4/20, created by Shuxin-Wang.
 * 2.
 */


package booking.mapper;

import booking.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User selectUserById(Integer userId);

    User selectUserByAccount(@Param("userAccount") String userAccount, @Param("passwd") String passwd);

    Integer hasUser(String userAccount);

    Integer addUser(User user);

    Integer removeUser(Integer userId);

    Integer modifyUser(User user);
}
