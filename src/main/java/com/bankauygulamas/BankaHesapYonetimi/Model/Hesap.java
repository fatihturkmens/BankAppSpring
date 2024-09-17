package com.bankauygulamas.BankaHesapYonetimi.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hesap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long hesap_numarasi;
    private String hesap_sahibi;
    private double hesap_bakiyesi;


    public Hesap(String hesap_sahibi,double hesap_bakiyesi) {
        this.hesap_sahibi = hesap_sahibi;
        this.hesap_bakiyesi=hesap_bakiyesi;
    }
}
