package lab9.lab9.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lab9.lab9.Entity.ProductEntity;
import lab9.lab9.repo.ProductRepo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProductService {
	ProductRepo productRepo;

	public List<ProductEntity> getAll() {
		return productRepo.findAll();
	}

	public ProductEntity create(ProductEntity productEntity) {
		return productRepo.save(productEntity);
	}

	public ProductEntity update(long id, ProductEntity productEntity) {
		ProductEntity oldProductEntity = productRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Product is not exist"));
		if (productEntity.getName() != null)
			oldProductEntity.setName(productEntity.getName());
		if (productEntity.getPrice() != 0)
			oldProductEntity.setPrice(productEntity.getPrice());
		if (productEntity.getDescription() != null)
			oldProductEntity.setDescription(productEntity.getDescription());
		return productRepo.save(oldProductEntity);
	}

	public ProductEntity replace(long id, ProductEntity productEntity) {
		productEntity.setId(id);
		return productRepo.save(productEntity);
	}

	public ProductEntity delete(long id) {
		ProductEntity productEntity = productRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Product is not exist"));
		productRepo.delete(productEntity);
		return productEntity;
	}
}
