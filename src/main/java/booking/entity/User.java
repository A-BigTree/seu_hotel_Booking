/**
 * ==================================================
 * Project: seu_hotel_Booking
 * Package: booking.entity
 * =====================================================
 * Title: User.java
 * Created: [2023/4/17 21:21] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/4/17, created by Shuxin-Wang.
 * 2.
 */

package booking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    // 用户ID
    private Integer userId;
    // 登陆账号
    private String accountNumber;
    // 登陆密码
    private String passwd;
    // 真实姓名
    private String userName;
    // 电子邮箱
    private String email;
    // 电话号码
    private String phoneNumber;
    // 账户余额
    private BigDecimal balance;
}
