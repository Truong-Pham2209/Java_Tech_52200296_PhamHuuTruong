package lab9.lab9.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lab9.lab9.entity.OrderEntity;

@Repository
public interface OrderRepo extends JpaRepository<OrderEntity, Long> {

}
