package com.customLogging.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "worklog")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Worklog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "summary")
    private String summary;

    @Column(name = "details")
    private String details;
}
