package com.masjid.alhikmah.managementmasjid.models;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.masjid.alhikmah.managementmasjid.enums.MGenderEnum;
import com.masjid.alhikmah.managementmasjid.enums.MPositionEnum;
import com.masjid.alhikmah.managementmasjid.enums.MStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "administrator")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "administrator_id")
public class MAdministratorModels {

    @Id
    @GeneratedValue(generator = "uuid" )
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "administrator_id", nullable = false, length = 64)
    private String administratorId;

    @Column(name = "name_administrator", nullable = false, length = 150)
    private String nameAdministrator;

    @Column(name = "type_gender_administrator", nullable = false)
    @Enumerated(EnumType.STRING)
    private MGenderEnum typeGender;

    @Column(name = "profession_administrator", nullable = false, length = 150)
    private String profession;

    @Column(name = "address_administrator",nullable = false, length = 1000)
    private String address;

    @Column(name = "telephone_administrator",nullable = false, length = 15)
    private BigInteger telephone;

    @Column(name = "position_administrator", nullable = false)
    @Enumerated(EnumType.STRING)
    private MPositionEnum position;

    @Column(name = "status_administrator", nullable = false)
    @Enumerated(EnumType.STRING)
    private MStatusEnum status;

    @Column(columnDefinition = "DATE", name = "date_entry_administrator", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateEntry;

    @OneToMany(mappedBy = "administrator")
    private List<MListBilalModels> mListBilalModelsList = new ArrayList<>();

    @OneToMany(mappedBy = "administrator")
    private List<MListImamModels> mListImamModelsList = new ArrayList<>();

    @OneToMany(mappedBy = "administrator")
    private List<MListKhotibModels> mListKhotibModelsList = new ArrayList<>();

    @OneToMany(mappedBy = "administrator")
    private List<MListMarbotModels> mListMarbotModelsList = new ArrayList<>();

    @OneToMany(mappedBy = "administrator")
    private List<MListMuazinModels> mListMuazinModelsList = new ArrayList<>();

    @OneToMany(mappedBy = "administrator")
    private List<MListOrphansAndElderlyModels> mListOrphansAndElderlyModelsList = new ArrayList<>();

    @OneToMany(mappedBy = "administrator")
    private List<MListTeenagerModels> mListTeenagerModelsList = new ArrayList<>();
}
