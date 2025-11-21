package com.fractal.domain.order.usecase;

import com.fractal.domain.order.Order;

import java.util.Map;

public interface OrderUseCaseService {

     Map getHeader(Order order);
     Map getFooter();
}
