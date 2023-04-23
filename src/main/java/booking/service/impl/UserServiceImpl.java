/**
 * ==================================================
 * Project: seu_hotel_Booking
 * Package: booking.service.impl
 * =====================================================
 * Title: UserServiceImpl.java
 * Created: [2023/4/20 15:19] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/4/20, created by Shuxin-Wang.
 * 2.
 */

package booking.service.impl;

import booking.entity.User;
import booking.mapper.UserMapper;
import booking.service.api.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public User getUser(Integer userId) {
        return userMapper.selectUserById(userId);
    }

    @Override
    public User login(String userAccount, String passwd) {
        return userMapper.selectUserByAccount(userAccount, passwd);
    }

    @Transactional(readOnly = true)
    @Override
    public Integer findUser(String userAccount) {
        return null;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public Integer signUp(User user) {
        return userMapper.addUser(user);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public Integer removeUser(Integer userId) {
        return userMapper.removeUser(userId);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public Integer modifyInfo(User user) {
        return userMapper.modifyUser(user);
    }
}
