/**
 * ==================================================
 * Project: seu_hotel_Booking
 * Package: booking
 * =====================================================
 * Title: UserTest.java
 * Created: [2023/4/20 16:07] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/4/20, created by Shuxin-Wang.
 * 2.
 */

package booking;

import booking.entity.User;
import booking.service.api.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@Slf4j
@ContextConfiguration(value = {"classpath:spring-persist.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {

    @Autowired
    private UserService userService;

    @Test
    public void testAddUser(){
        User user = new User();
        user.setAccountNumber("123@gmail.com");
        user.setPasswd("123456");
        user.setUserName("陈昊阳");
        user.setEmail("chy@123.com");
        user.setPhoneNumber("164137568");
        user.setBalance(BigDecimal.valueOf(3000));
        if(userService.findUser(user.getAccountNumber())==0){
            log.info(userService.signUp(user).toString());
        }else{
            log.info("User: " + user.getAccountNumber() + "has existed.");
        }
    }

    @Test
    public void testUserLogin(){
        Integer re = userService.findUser("1234@gmail.com");
        log.info(re.toString());
    }

}
