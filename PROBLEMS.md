# Mevcut Kodun Tasarım Sorunları

Bu dosya, projenin başlangıç aşamasındaki (Faz 0) tasarım hatalarını listeler.

1. **Açık/Kapalı Prensibi (OCP) İhlali:** Yeni bir oyun nesnesi türü (örneğin "Boss") eklemek için mevcut `update` metodunun içine girip kodu değiştirmemiz gerekiyor. Kod gelişime kapalı, değişime açık durumda.
2. **Spagetti Kod ve Karmaşıklık:** Tüm karakterlerin davranışları tek bir sınıf (`GameObject`) ve tek bir metod (`update`) içinde toplanmış. Bu durum ileride binlerce satırlık yönetilemez bir koda yol açar.
3. **Esneklik Eksikliği:** Nesne tipleri `String` (Player, Enemy vb.) ile kontrol ediliyor. Yazım hataları sistemin bozulmasına neden olabilir ve çalışma anında davranış değiştirmek imkansızdır.
4. **Tek Sorumluluk Prensibi (SRP) İhlali:** `GameObject` sınıfı hem oyuncuyu, hem düşmanı, hem de diğer nesneleri yönetmeye çalışıyor. Her sınıfın tek bir görevi olmalıydı.
5. **Düşük Bakım Yapılabilirliği:** Bir davranışı değiştirmek (örneğin düşmanın saldırı hızını artırmak) tüm sistemi etkileyebilir ve hata ayıklamayı zorlaştırır.****
