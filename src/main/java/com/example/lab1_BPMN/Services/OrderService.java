package com.example.lab1_BPMN.Services;

import com.example.lab1_BPMN.Entities.CartItem;
import com.example.lab1_BPMN.Entities.OrderStatus;
import com.example.lab1_BPMN.Entities.OrderTable;
import com.example.lab1_BPMN.Entities.Product;
import com.example.lab1_BPMN.Ex.ResourceNotFoundException;
import com.example.lab1_BPMN.Repositories.CartItemRepository;
import com.example.lab1_BPMN.Repositories.OrderRepository;
import com.example.lab1_BPMN.Repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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

    @Transactional
    public CartItem addProductToCart(Long productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        return cartItemRepository.save(cartItem);
    }

    public OrderTable createOrder(List<CartItem> cartItems, String address) {
        OrderTable order = new OrderTable(cartItems , address , OrderStatus.NEW);

        return orderRepository.save(order);
    }

    public OrderTable updateOrderStatus(Long orderId, OrderStatus newStatus) {
        OrderTable order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + orderId));

        order.setStatus(newStatus);
        return orderRepository.save(order);
    }

    public OrderTable getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + orderId));
    }

    public OrderStatus getStatus(Long id) {
        return getOrderById(id).getStatus();
    }

    public Page<OrderTable> getAll(int offset, int limit) {
        return orderRepository.findAll(PageRequest.of(offset, limit));
    }

    public List<OrderTable> getAllOrders() {
        return orderRepository.findAll();
    }
}

