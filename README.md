# Mini Oyun Motoru - Yazılım Tasarım Örüntüleri Ödevi

**Seçilen Konu:** C - Mini Oyun Motoru

**Gerekçe:** Çok oyun oynayan biri olarak, oyunlardaki karakterlerin ve nesnelerin arka planda nasıl bir sistemle çalıştığını her zaman merak etmişimdir. Bu projeyi; oyun mekaniklerinin "if-else" yığınlarına ve kod karmaşıklığına düşmeden nasıl profesyonelce yönetilebileceğini tasarım örüntüleri üzerinden öğrenmek için seçtim. Amacım, severek vakit geçirdiğim oyun dünyasının yazılım mutfağındaki çözümlerini bizzat uygulayarak deneyimlemektir.

# C - Mini Oyun Motoru Modülü (Faz 3 Son Durum)

**Seçim Gerekçesi:** Başlangıç kodunda tüm oyun nesneleri tek bir God Class içerisindeki if-else bloklarıyla yönetiliyordu. Bu durumun genişletilebilirliği engellediğini gördüğüm için C konusunu seçtim.

### Kullanılan Tasarım Örüntüleri:
* **Factory Method (Creational):** Nesne üretimini esnekleştirmek için uygulandı.
* **Decorator (Structural):** Karakterlere dinamik özellikler kazandırmak için uygulandı.
* **Strategy (Behavioral):** Karakterlerin yapay zeka hareket kararlarını if-else olmadan runtime'da değiştirmek için uygulandı.

### Nasıl Çalıştırılır?
Proje standart bir Java projesidir. `src/` klasöründeki ana sınıf çalıştırılarak test edilebilir.
