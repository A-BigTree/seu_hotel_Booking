/**
 * ==================================================
 * Project: seu_hotel_Booking
 * Package: booking
 * =====================================================
 * Title: AppTest.java
 * Created: [2023/4/9 18:27] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/4/9, created by Shuxin-Wang.
 * 2.
 */

package booking;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Slf4j
@ContextConfiguration(value = {"classpath:spring-persist.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest {
    @Test
    public void testApp(){
        log.debug("Testing...");
    }
}
