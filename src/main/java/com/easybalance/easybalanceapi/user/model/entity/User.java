package com.easybalance.easybalanceapi.user.model.entity;

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
@Table(name = "EB_T1_USER")
@NoArgsConstructor
@DynamicUpdate
public class User {
    
    @Id
    @Column(name = "T1_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T1_USER_ID_SEQ_GEN")
    @SequenceGenerator(name = "T1_USER_ID_SEQ_GEN", sequenceName = "T1_USER_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "T1_EMAIL")
    private String email;

    @Column(name = "T1_NAME")
    private String name;


    // @OneToMany(mappedBy = "user")
    // private List<Transaction> transactions;


}
