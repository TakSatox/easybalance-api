package com.easybalance.easybalanceapi.transaction.model;

import java.time.LocalDate;

import org.hibernate.annotations.DynamicUpdate;

import com.easybalance.easybalanceapi.category.model.Category;
import com.easybalance.easybalanceapi.user.model.User;

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
@Table(name = "EB_T3_TRANSACTION")
@NoArgsConstructor
@DynamicUpdate
public class Transaction {
    
    @Id
    @Column(name = "T3_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T3_TRANSACTION_ID_SEQ_GEN")
    @SequenceGenerator(name = "T3_TRANSACTION_ID_SEQ_GEN", sequenceName = "T3_TRANSACTION_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "T3_TITLE")
    private String title;

    @Column(name = "T3_DESCRIPTION")
    private String description;

    @Column(name = "T3_PAYMENT_METHOD")
    private String paymentMethod;

    @Column(name = "T3_TYPE")
    private String type;

    @Column(name = "T3_INITIAL_DATE")
    private LocalDate initialDate;

    @Column(name = "T3_END_DATE")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "T3_T2_CATEGORY_ID")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "T3_T1_USER_ID")
    private User user;

    
    // @OneToMany(mappedBy = "transaction", cascade = CascadeType.REMOVE)
    // private List<TransactionDetail> transactionItems;
    
}
