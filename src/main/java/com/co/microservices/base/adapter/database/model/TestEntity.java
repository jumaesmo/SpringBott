package com.co.microservices.base.adapter.database.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes_autorizados")
public class TestEntity implements Serializable {

	private static final long serialVersionUID = -2463354084291480284L;

	@Id
	private Integer id;

	@Column(nullable = true , name = "nombre")
	private String nombre;
	
	@Column(nullable = true , name = "aliado")
	private String aliado;
	
}
