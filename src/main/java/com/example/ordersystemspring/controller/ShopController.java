package com.example.ordersystemspring.controller;

import com.example.ordersystemspring.model.Order;
import com.example.ordersystemspring.model.Product;
import com.example.ordersystemspring.repo.ProductRepo;
import com.example.ordersystemspring.service.ShopService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api")
public class ShopController {

    private final ShopService shopService;

  @GetMapping("api/products")
    public List<Product> listProducts()  {
      return shopService.listProducts();
    }

    @GetMapping("api/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id){
    Product product = shopService.getProduct(id);
    if (product == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("api/orders")
    public List<Order> listOrders(){
      return shopService.listOrders();
    }
    @GetMapping("api/orders/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable int id){
    Order order = shopService.getOrder(id);
    if (order == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(order, HttpStatus.OK);
    }



   /* @PostMapping("api/orders/{id}(int-array als Body")
    public ResponseEntity<String> addOrder(@PathVariable int id, @RequestBody List<Integer> productIds){
    try {
      shopService.addOrder(id, productIds);
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(HttpStatus.OK);
    }*/


}
