package lab9.lab9.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lab9.lab9.Entity.OrderEntity;
import lab9.lab9.repo.OrderRepo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class OrderService {
	OrderRepo orderRepo;
	OrderProductRepository orderProductRepository;

	public List<OrderEntity> getAll() {
		return orderRepo.findAll();
	}

	public OrderEntity create(OrderEntity orderEntity) {
		return orderRepo.save(orderEntity);
	}

	public OrderEntity getDetail(long id) {
		return orderRepo.findById(id).orElseThrow(() -> new RuntimeException("Order is not exist"));
	}
}
