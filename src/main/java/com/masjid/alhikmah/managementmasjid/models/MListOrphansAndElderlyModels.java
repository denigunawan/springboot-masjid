package com.masjid.alhikmah.managementmasjid.models;

import com.masjid.alhikmah.managementmasjid.enums.MGenderEnum;
import com.masjid.alhikmah.managementmasjid.enums.MStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "oae")
public class MListOrphansAndElderlyModels {

    @Id
    @GeneratedValue(generator = "uuid" )
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "oae_id", nullable = false, length = 64)
    private String oaeId;

    @Column(name = "name_oae", nullable = false, length = 150)
    private String name;

    @Column(name = "address_oae", nullable = false, length = 1000)
    private String address;

    @Column(name = "status_oae", nullable = false)
    @Enumerated(EnumType.STRING)
    private MStatusEnum status;

    @Column(name = "type_gender_pengurus", nullable = false)
    @Enumerated(EnumType.STRING)
    private MGenderEnum typeGender;

    @Column(name = "telephone_oae", nullable = false, length = 15)
    private BigInteger telephoneOae;


    @Column(columnDefinition = "DATE", name = "year_entry_oae", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate yearEntry;

    @ManyToOne
    @JoinColumn(name = "administrator_id", nullable = false)
    private MAdministratorModels administrator;

}
