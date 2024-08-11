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
@Table(name = "EB_T4_TRANSACTION_DETAIL")
@NoArgsConstructor
@DynamicUpdate
public class TransactionDetail {
    
    @Id
    @Column(name = "T4_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T4_TRANSACTION_DETAIL_ID_SEQ_GEN")
    @SequenceGenerator(name = "T4_TRANSACTION_DETAIL_ID_SEQ_GEN", sequenceName = "T4_TRANSACTION_DETAIL_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "T4_MONTH")
    private Integer month;

    @Column(name = "T4_YEAR")
    private Integer year;

    @Column(name = "T4_INSTALLMENT")
    private Integer installment;

    @Column(name = "T4_VALUE")
    private Float value;

    @Column(name = "T4_PAID")
    private Boolean isPaid;

    @ManyToOne
    @JoinColumn(name = "T4_T3_TRANSACTION_ID")
    private Transaction transaction;

}
