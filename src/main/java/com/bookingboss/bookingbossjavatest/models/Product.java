package com.bookingboss.bookingbossjavatest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "products")
@Data
@DynamicUpdate
@NoArgsConstructor
public class Product implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Min(0)
	private long id;

	@Column(unique = true)
	@NotNull
	private String name;

	@Min(0)
	private int quantity;

	@JsonProperty("sale_amount")
	@Column(name = "sale_amount")
	@Min(0)
	private int saleAmount;

}
