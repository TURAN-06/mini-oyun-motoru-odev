# Mevcut Kodun Tasarım Sorunları

Bu dosya, projenin başlangıç aşamasındaki (Faz 0) tasarım hatalarını listeler.

1. **Açık/Kapalı Prensibi (OCP) İhlali:** Yeni bir oyun nesnesi türü (örneğin "Boss") eklemek için mevcut `update` metodunun içine girip kodu değiştirmemiz gerekiyor. Kod gelişime kapalı, değişime açık durumda.
2. **Spagetti Kod ve Karmaşıklık:** Tüm karakterlerin davranışları tek bir sınıf (`GameObject`) ve tek bir metod (`update`) içinde toplanmış. Bu durum ileride binlerce satırlık yönetilemez bir koda yol açar.
3. **Esneklik Eksikliği:** Nesne tipleri `String` (Player, Enemy vb.) ile kontrol ediliyor. Yazım hataları sistemin bozulmasına neden olabilir ve çalışma anında davranış değiştirmek imkansızdır.
4. **Tek Sorumluluk Prensibi (SRP) İhlali:** `GameObject` sınıfı hem oyuncuyu, hem düşmanı, hem de diğer nesneleri yönetmeye çalışıyor. Her sınıfın tek bir görevi olmalıydı.
5. **Düşük Bakım Yapılabilirliği:** Bir davranışı değiştirmek (örneğin düşmanın saldırı hızını artırmak) tüm sistemi etkileyebilir ve hata ayıklamayı zorlaştırır.



## AI Analizi ve Karşılaştırma

**AI Ne Gördü?:** AI, özellikle OCP (Açık/Kapalı) ve SRP (Tek Sorumluluk) gibi SOLID prensiplerinin ihlal edildiğini ve nesne tiplerinin String ile kontrol edilmesinin riskli olduğunu belirtti. Çözüm olarak Factory ve Strategy gibi örüntüleri önerdi.

**Ben Ne Gördüm?:** Ben daha çok if-else kalabalığına, yeni karakter türü eklemenin yaratacağı karmaşıklığa ve kodun okunabilirliğinin düşmesine odaklanmıştım.

**Farklar/Benzerlikler:** Benim tespitlerim daha çok pratik kullanım zorlukları üzerineyken, AI bu sorunları akademik yazılım prensipleriyle (SOLID) ilişkilendirdi. Sonuç olarak her iki analiz de mevcut yapının ölçeklenemez olduğu konusunda hemfikir.
