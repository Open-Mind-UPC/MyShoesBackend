package com.acme.myshoes.platform.orders.domain.model;

import com.acme.myshoes.platform.shared.domain.model.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

>>>>>>> fbe6dee96d46a5abab471d3bf4d77dfc2657b340
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@With
@Entity
@Table(name = "orderitems")
public class OrderItem extends AuditModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name="order_id", nullable = false)
    @JsonIgnore
    private Order order;

    @NotNull
    @NotBlank
    @Column
    private Long id_shoes;


}
