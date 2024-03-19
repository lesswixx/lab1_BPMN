package com.example.lab1_BPMN.Controllers;

import com.example.lab1_BPMN.Controllers.dto.NewStatus;
import com.example.lab1_BPMN.Entities.CartItem;
import com.example.lab1_BPMN.Entities.OrderStatus;
import com.example.lab1_BPMN.Entities.OrderTable;
import com.example.lab1_BPMN.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/cart/add")
    public CartItem addProductToCart(@RequestBody Map<String, Object> request) {
        Long productId = ((Number) request.get("productId")).longValue();
        int quantity = (int) request.get("quantity");
        return orderService.addProductToCart(productId, quantity);
    }

    @PostMapping("/create")
    public OrderTable createOrder(@RequestBody Map<String, Object> request) {
        List<CartItem> cartItems = (List<CartItem>) request.get("cartItems");
        String address = (String) request.get("address");
        
        return orderService.createOrder(cartItems, address);
    }


    @PutMapping("/{id}/status")
    public OrderTable updateOrderStatus(@PathVariable Long id, @RequestBody NewStatus status) {
        return orderService.updateOrderStatus(id, status.getNewStatus());
    }


    @GetMapping("/{id}")
    public OrderTable getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/{id}/status")
    public OrderStatus getStatus(@PathVariable Long id) {
        return orderService.getStatus(id);
    }

    @GetMapping("/paginated")
    public Page<OrderTable> getAll(@RequestParam int offset, @RequestParam int limit) {
        return orderService.getAll(offset, limit);
    }


    @GetMapping("/allOrders")
    public List<OrderTable> getAllOrders() {
        return orderService.getAllOrders();
    }

}
