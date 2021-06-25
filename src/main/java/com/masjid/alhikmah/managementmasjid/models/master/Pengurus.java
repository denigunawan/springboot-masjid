package com.masjid.alhikmah.managementmasjid.models.master;

import com.masjid.alhikmah.managementmasjid.enums.JabatanMasjid;
import com.masjid.alhikmah.managementmasjid.enums.JenisKelamin;
import com.masjid.alhikmah.managementmasjid.enums.StatusData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pengurus", schema = "master")
@Data
public class Pengurus {

    @Id
    @GenericGenerator(name = "uuid_pengurus", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_pengurus")
    @Column(name = "id", nullable = false, unique = true, length = 64)
    private String id;

    @NotEmpty
    @NotNull
    @Size(min = 5, max = 49, message = "Jumlah karakter tidak boleh lebih dari 5 sampe 49 karakter")
    @Column(name = "nama_pengurus", nullable = false, length = 150)
    private String nama;

    @Column(name = "jk_pengurus", nullable = false)
    @Enumerated(EnumType.STRING)
    private JenisKelamin jenis;

    @NotEmpty
    @NotNull
    @Size(min = 5, max = 49, message = "Jumlah karakter tidak boleh lebih dari 5 sampe 49 karakter")
    @Column(name = "pekerjaan_pengurus", nullable = false, length = 150)
    private String pekerjaan;

    @NotEmpty
    @NotNull
    @Size(min = 50, max = 1000, message = "Jumlah karakter tidak boleh lebih dari 50 sampe 1000 karakter")
    @Column(name = "alamat_pengurus", nullable = false, length = 1000)
    private String alamat;

    @NotEmpty
    @NotNull
    @Size(min = 5, max = 49, message = "Jumlah karakter tidak boleh lebih dari 5 sampe 49 karakter")
    @Column(name = "telephone_pengurus", nullable = false, length = 15)
    private String telephone;

    @Column(name = "jabatan_pengurus", nullable = false)
    @Enumerated(EnumType.STRING)
    private JabatanMasjid jabatan;

    @Column(name = "status_pengurus", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusData status;

    @NotEmpty
    @NotNull
    @Size(min = 5, max = 49, message = "Jumlah karakter tidak boleh lebih dari 5 sampe 49 karakter")
    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;

    @NotEmpty
    @NotNull
    @Size(min = 5, max = 49, message = "Jumlah karakter tidak boleh lebih dari 5 sampe 49 karakter")
    @Column(name = "created_by", length = 20)
    private String createdBy;

    @OneToMany(mappedBy = "pengurus")
    private List<Bilal> listBilal = new ArrayList<>();

    @OneToMany(mappedBy = "pengurus")
    private List<Imam> listImam = new ArrayList<>();

    @OneToMany(mappedBy = "pengurus")
    private List<Khotib> listKhotib = new ArrayList<>();

    @OneToMany(mappedBy = "pengurus")
    private List<Marbot> listMarbot = new ArrayList<>();

    @OneToMany(mappedBy = "pengurus")
    private List<Muazin> listMuazin = new ArrayList<>();

    @OneToMany(mappedBy = "pengurus")
    private List<YatimDanDhuafa> listYatimdanDhuafa = new ArrayList<>();

    @OneToMany(mappedBy = "pengurus")
    private List<Remaja> listRemaja = new ArrayList<>();
}
