package com.masjid.alhikmah.managementmasjid.models;


import com.masjid.alhikmah.managementmasjid.enums.MGenderEnum;
import com.masjid.alhikmah.managementmasjid.enums.MStatusEnum;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "teenager")
public class MListTeenagerModels {


    @Id
    @GeneratedValue(generator = "uuid" )
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "teenager_id", nullable = false, length = 64)
    private String teenagerId;

    @Column(name = "name_teenager", nullable = false, length = 150)
    private String name;

    @Column(name = "address_teenager", nullable = false, length = 1000)
    private String address;

    @Column(name = "status_teenager", nullable = false)
    @Enumerated(EnumType.STRING)
    private MStatusEnum status;

    @Column(name = "type_gender_teenager", nullable = false)
    @Enumerated(EnumType.STRING)
    private MGenderEnum typeGender;


    @Column(name = "no_telephone", nullable = false, length = 15)
    private BigInteger noTelephone;


    @Column(columnDefinition = "DATE", name = "year_entry_teenager", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate yearEntry;

    @ManyToOne
    @JoinColumn(name = "administrator_id", nullable = false)
    private MAdministratorModels administrator;
}
