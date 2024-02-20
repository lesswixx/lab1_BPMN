//package com.example.lab1_BPMN;
//
//import com.example.lab1_BPMN.Entities.CartItem;
//import com.example.lab1_BPMN.Entities.OrderTable;
//import com.example.lab1_BPMN.Entities.Product;
//import com.example.lab1_BPMN.Repositories.CartItemRepository;
//import com.example.lab1_BPMN.Repositories.OrderRepository;
//import com.example.lab1_BPMN.Repositories.ProductRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import org.springframework.beans.factory.annotation.Autowired;
//import java.math.BigDecimal;
//import java.util.Arrays;
//
//@Component
//public class DataInitializer implements CommandLineRunner {
//
//    private final ProductRepository productRepository;
//    private final OrderRepository orderRepository;
//    private final CartItemRepository cartItemRepository;
//
//    @Autowired
//    public DataInitializer(ProductRepository productRepository, OrderRepository orderRepository, CartItemRepository cartItemRepository) {
//        this.productRepository = productRepository;
//        this.orderRepository = orderRepository;
//        this.cartItemRepository = cartItemRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        // Добавление продуктов
//        Product product1 = new Product("Coffee", new BigDecimal("1.99"));
//        Product product2 = new Product("Tea", new BigDecimal("0.99"));
//        productRepository.save(product1);
//        productRepository.save(product2);
//
//        // Создание заказа
//        OrderTable order = new OrderTable();
//        order.setAddress("123 Main St");
//        order.setStatus("В обработке");
//        order = orderRepository.save(order);
//
//        // Добавление товаров в корзину и привязка к заказу
//        CartItem cartItem1 = new CartItem();
//        cartItem1.setProduct(product1);
//        cartItem1.setQuantity(2);
//        cartItem1.setOrderTable(order);
//        CartItem cartItem2 = new CartItem();
//        cartItem2.setProduct(product2);
//        cartItem2.setQuantity(3);
//        cartItem2.setOrderTable(order);
//        cartItemRepository.saveAll(Arrays.asList(cartItem1, cartItem2));
//
//
//    }
//}
