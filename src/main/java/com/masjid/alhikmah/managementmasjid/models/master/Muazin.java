package com.masjid.alhikmah.managementmasjid.models.master;

import com.masjid.alhikmah.managementmasjid.enums.StatusData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "muazin", schema = "master")
@Data
public class Muazin {

    @Id
    @GenericGenerator(name = "uuid_muazin", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_muazin")
    @Column(name = "id", nullable = false, unique = true, length = 64)
    private String id;

    @Column(name = "nama_muazin", nullable = false, length = 150)
    private String nama;

    @Column(name = "alamat_muazin", nullable = false, length = 1000)
    private String alamat;

    @Column(name = "status_muazin", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusData status;

    @Column(name = "telephone_muazin", nullable = false, length = 15)
    private BigInteger telephone;

    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;

    @Column(name = "created_by", length = 20)
    private String createdBy;

    @ManyToOne
    @JoinColumn(name = "pengurus_id", nullable = false)
    private Pengurus pengurus;

}
