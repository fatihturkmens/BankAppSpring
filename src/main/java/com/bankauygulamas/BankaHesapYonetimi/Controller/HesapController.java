package com.bankauygulamas.BankaHesapYonetimi.Controller;

import com.bankauygulamas.BankaHesapYonetimi.Model.Hesap;
import com.bankauygulamas.BankaHesapYonetimi.Service.HesapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hesap")
public class HesapController {

    @Autowired
    HesapService service;

    @PostMapping
    public ResponseEntity<Hesap> hesapOlustur(@RequestBody Hesap hesap) {
        Hesap hesap1 = service.hesapOlustur(hesap);
        return ResponseEntity.status(HttpStatus.CREATED).body(hesap1);
    }

    @GetMapping("/{id}")
    public Hesap hesapNumarasınaGoreBul(@PathVariable Long id) {
        Hesap hesap1 = service.hesapNumarasınaGoreBul(id);
        return hesap1;
    }

    @GetMapping("/tumhesaplar")
    public List<Hesap> tumHesaplarıGoruntule() {
        List<Hesap> tumHesapBilgileri = service.tumHesapBilgileri();
        return tumHesapBilgileri;
    }

    @PutMapping("/parayatirma/{hesapnumarasi}/{money}")
    public Hesap parayatirma(@PathVariable Long hesapnumarasi, @PathVariable double money) {
        Hesap hesap1 = service.paraYatirma(hesapnumarasi, money);
        return hesap1;
    }

    @PutMapping("/paracekme/{hesapnumarasi}/{money}")
    public Hesap paracekme(@PathVariable Long hesapnumarasi, @PathVariable double money) {
        Hesap hesap1 = service.paraCekme(hesapnumarasi, money);
        return hesap1;

    }
}
