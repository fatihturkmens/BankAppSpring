package com.bankauygulamas.BankaHesapYonetimi.Service;

import com.bankauygulamas.BankaHesapYonetimi.Model.Hesap;
import com.bankauygulamas.BankaHesapYonetimi.Repository.HesapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HesapServiceİmpl implements HesapService{

    @Autowired
    HesapRepository repository;
    @Override
    public Hesap hesapOlustur(Hesap hesap) {
       Hesap hesap1= repository.save(hesap);
        return hesap1;
    }

    @Override
    public Hesap hesapNumarasınaGoreBul(Long hesapnumarasi) {
        Optional<Hesap> hesap1 = repository.findById(hesapnumarasi);
        if (hesap1.isEmpty()) {
            throw new RuntimeException("Bu hesap mevcut değildir");
        } Hesap hesapbulundu=hesap1.get();
        return hesapbulundu;
    }

    @Override
    public List<Hesap> tumHesapBilgileri() {
        List<Hesap>tumhesaplar=repository.findAll();
        return tumhesaplar;
    }

    @Override
    public Hesap paraYatirma(Long hesapnumarasi, Double money) {
        Optional<Hesap> hesap=repository.findById(hesapnumarasi);
        if(hesap.isEmpty()){
            throw new RuntimeException("Hesap bulunamadı");
        }
        Hesap hesap2=hesap.get();
        Double toplampara=hesap2.getHesap_bakiyesi()+money;
        hesap2.setHesap_bakiyesi(toplampara);
        repository.save(hesap2);
        return hesap2;
    }

    @Override
    public Hesap paraCekme(Long hesapnumarasi, Double money) {
        Optional<Hesap> hesap=repository.findById(hesapnumarasi);
        if(hesap.isEmpty()){
            throw new RuntimeException("Hesap bulunamadı");
        }
        Hesap hesap2=hesap.get();
        double hesap3= hesap2.getHesap_bakiyesi()-money;
        hesap2.setHesap_bakiyesi(hesap3);
        repository.save(hesap2);
        return hesap2;
    }

    @Override
    public void hesapKapatma(Long hesapnumarasi) {

    }
}
