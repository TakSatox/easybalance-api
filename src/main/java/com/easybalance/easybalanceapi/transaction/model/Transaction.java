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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "transaction")
@NoArgsConstructor
@DynamicUpdate
public class Transaction {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_id_seq")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "initial_date")
    private LocalDate initialDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    
    // @OneToMany(mappedBy = "transaction", cascade = CascadeType.REMOVE)
    // private List<TransactionDetail> transactionItems;
    
}
