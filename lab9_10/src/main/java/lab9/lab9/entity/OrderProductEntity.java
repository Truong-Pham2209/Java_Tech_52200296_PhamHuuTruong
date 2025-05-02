package lab9.lab9.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "order_product")
public class OrderProductEntity {
	@EmbeddedId
	OrderProductKey id;

	@ManyToOne
	@MapsId(value = "productID")
	@JoinColumn(name = "product_id")
	ProductEntity product;
	
	@ManyToOne
	@MapsId(value = "orderID")
	@JoinColumn(name = "order_id")
	OrderEntity order;

	@FieldDefaults(level = AccessLevel.PRIVATE)
	@Embeddable
	public class OrderProductKey implements Serializable {
		@Column(name = "product_id")
		long productID;
		@Column(name = "order_id")
		long orderID;
	}
}
