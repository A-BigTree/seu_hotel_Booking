/**
 * ==================================================
 * Project: seu_hotel_Booking
 * Package: booking.mapper
 * =====================================================
 * Title: ExampleMapper.java
 * Created: [2023/4/9 18:09] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/4/9, created by Shuxin-Wang.
 * 2.
 */


package booking.mapper;

import booking.entity.Example;

import java.util.List;

public interface ExampleMapper {
    List<Example> selectAll();
}
