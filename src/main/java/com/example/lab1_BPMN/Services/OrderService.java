package com.example.lab1_BPMN.Services;

import com.example.lab1_BPMN.Entities.CartItem;
import com.example.lab1_BPMN.Entities.OrderTable;
import com.example.lab1_BPMN.Entities.Product;
import com.example.lab1_BPMN.Ex.ResourceNotFoundException;
import com.example.lab1_BPMN.Repositories.CartItemRepository;
import com.example.lab1_BPMN.Repositories.OrderRepository;
import com.example.lab1_BPMN.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, CartItemRepository cartItemRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
    }

    public CartItem addProductToCart(Long productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        return cartItemRepository.save(cartItem);
    }

    public OrderTable createOrder(List<CartItem> cartItems, String address) {
        OrderTable order = new OrderTable(cartItems , address , "В обработке");

        return orderRepository.save(order);
    }

    public OrderTable updateOrderStatus(Long orderId, String newStatus) {
        OrderTable order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + orderId));

        order.setStatus(newStatus);
        return orderRepository.save(order);
    }

    public OrderTable getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + orderId));
    }

    public List<OrderTable> getAllOrders() {
        return orderRepository.findAll();
    }
}

