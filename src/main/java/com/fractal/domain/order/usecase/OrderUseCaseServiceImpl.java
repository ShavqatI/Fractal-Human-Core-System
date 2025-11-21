package com.fractal.domain.order.usecase;

import com.fractal.domain.order.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
class OrderUseCaseServiceImpl implements OrderUseCaseService {
    @Override
    public Map getHeader(Order order) {
        Map<String,String> values = new HashMap<>();
        values.put("number",order.getNumber());
        values.put("docDate", order.getDate().toString());
        return values;
    }
    @Override
    public Map getFooter() {
        return null;
    }
}
