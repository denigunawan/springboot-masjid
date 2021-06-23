package com.masjid.alhikmah.managementmasjid.models;

import com.masjid.alhikmah.managementmasjid.enums.MStatusEnum;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "marbot")
public class MListMarbotModels {

    @Id
    @GeneratedValue(generator = "uuid" )
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "marbot_id", nullable = false, length = 64)
    private String marbotId;

    @Column(name = "name_marbot", nullable = false, length = 150)
    private String name;

    @Column(name = "address_marbot", nullable = false, length = 1000)
    private String address;

    @Column(name = "status_marbot", nullable = false)
    @Enumerated(EnumType.STRING)
    private MStatusEnum status;

    @Column(name = "telephone_marbot", nullable = false, length = 15)
    private BigInteger telephone;


    @Column(columnDefinition = "DATE", name = "year_entry_marbot", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate yearEntry;

    @ManyToOne
    @JoinColumn(name = "administrator_id", nullable = false)
    private MAdministratorModels administrator;

}