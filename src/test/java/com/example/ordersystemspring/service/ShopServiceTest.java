package com.example.ordersystemspring.service;

import com.example.ordersystemspring.model.Order;
import com.example.ordersystemspring.model.Product;
import com.example.ordersystemspring.repo.OrderRepo;
import com.example.ordersystemspring.repo.ProductRepo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ShopServiceTest {

    ProductRepo productrepo = mock(ProductRepo.class);
    OrderRepo orderRepo = mock(OrderRepo.class);

    ShopService shopService = new ShopService(productrepo, orderRepo);

    @Test
    void getOrder_ShouldReturnCorrectOrder(){
        //given
        String orderId1 = "2";
        Order expectedOrder = new Order ();
        //when
        when(orderRepo.getOrder(Integer.parseInt(orderId1))).thenReturn(expectedOrder);
        Order result = shopService.getOrder(Integer.parseInt(orderId1));
        //then
        assertEquals(expectedOrder,result);
        //verify(orderRepo).getOrder(any());
    }


}