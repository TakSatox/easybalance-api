package com.easybalance.easybalanceapi.category.model.entity;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "EB_T2_CATEGORY")
@NoArgsConstructor
@DynamicUpdate
public class Category {

    @Id
    @Column(name = "T2_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T2_CATEGORY_ID_SEQ_GEN")
    @SequenceGenerator(name = "T2_CATEGORY_ID_SEQ_GEN", sequenceName = "T2_CATEGORY_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "T2_TITLE")
    private String title;

}
