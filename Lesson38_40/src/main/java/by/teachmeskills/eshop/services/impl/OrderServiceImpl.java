package by.teachmeskills.eshop.services.impl;

import by.teachmeskills.eshop.entities.Order;
import by.teachmeskills.eshop.repositories.impl.OrderRepositoryImpl;
import by.teachmeskills.eshop.services.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepositoryImpl orderRepository;

    public OrderServiceImpl(OrderRepositoryImpl orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order create(Order entity) {
        return orderRepository.create(entity);
    }

    @Override
    public List<Order> read() {
        return orderRepository.read();
    }

    @Override
    public Order update(Order entity) {
        return orderRepository.update(entity);
    }

    @Override
    public void delete(int id) {
        orderRepository.delete(id);
    }
}
