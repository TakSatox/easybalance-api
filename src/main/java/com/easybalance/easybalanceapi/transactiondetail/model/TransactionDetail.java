package com.easybalance.easybalanceapi.transactiondetail.model;

import org.hibernate.annotations.DynamicUpdate;

import com.easybalance.easybalanceapi.transaction.model.Transaction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "transaction_detail")
@NoArgsConstructor
@DynamicUpdate
public class TransactionDetail {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_detail_id_seq_gen")
    @SequenceGenerator(name = "transaction_detail_id_seq_gen", sequenceName = "transaction_detail_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "t_month")
    private Integer month;

    @Column(name = "t_year")
    private Integer year;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "installment")
    private Integer installment;

    @Column(name = "value")
    private Float value;

    @Column(name = "paid")
    private Boolean paid;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

}
