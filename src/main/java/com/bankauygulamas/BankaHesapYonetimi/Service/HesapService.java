package com.bankauygulamas.BankaHesapYonetimi.Service;

import com.bankauygulamas.BankaHesapYonetimi.Model.Hesap;

import java.util.List;

public interface HesapService {
    public Hesap hesapOlustur(Hesap hesap);         // yeni hesap oluşturma
    public Hesap hesapNumarasınaGoreBul(Long hesapnumarasi);          // hesap numarasına göre getirir
    public List<Hesap> tumHesapBilgileri();            // tüm hesapları getirir
    public Hesap paraYatirma(Long hesapnumarasi,Double money);   /// başka hesaba para yatirma ve miktarı
    public Hesap paraCekme(Long hesapnumarasi,Double money); /// hesaptan para çekme
    public void hesapKapatma(Long hesapnumarasi);

}
