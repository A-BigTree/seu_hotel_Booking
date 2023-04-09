/**
 * ==================================================
 * Project: seu_hotel_Booking
 * Package: booking.service.impl
 * =====================================================
 * Title: ExampleServiceImpl.java
 * Created: [2023/4/9 18:11] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/4/9, created by Shuxin-Wang.
 * 2.
 */

package booking.service.impl;

import booking.entity.Example;
import booking.mapper.ExampleMapper;
import booking.service.api.ExampleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExampleServiceImpl implements ExampleService {
    private final ExampleMapper exampleMapper;

    public ExampleServiceImpl(ExampleMapper exampleMapper){
        this.exampleMapper = exampleMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Example> getAll() {
        return exampleMapper.selectAll();
    }
}
