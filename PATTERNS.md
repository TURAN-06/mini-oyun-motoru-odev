# Uygulanan Tasarım Örüntüleri - Faz 1

## 1. Factory Method (Yaratımsal Örüntü)

**Sorun:** Nesnelerin (Player, Enemy) doğrudan `Main` veya `GameObject` sınıfı içinde `new` anahtar kelimesiyle ve if-else kontrolüyle oluşturulması, kodun esnekliğini azaltıyordu.

**Çözüm:** `GameObjectFactory` sınıfı oluşturularak nesne yaratma sorumluluğu bu sınıfa devredildi. Artık sisteme yeni bir nesne türü (örneğin "Boss") eklendiğinde, istemci kodun (`Main`) değişmesine gerek kalmadan sadece fabrika üzerinden üretim yapılabiliyor.

**Sonuç:** Nesne yaratma mantığı merkezileşti ve "Gelişime Açık, Değişime Kapalı" (OCP) prensibine uygun bir yapı kuruldu.

---
## 2. Decorator (Yapısal Örüntü) - Faz 2

**Sorun:** Karakterlere (Player, Enemy) yeni özellikler (Zırh, Hız vb.) eklemek istediğimizde her kombinasyon için ayrı bir alt sınıf oluşturmak kod kalabalığına ve karmaşıklığa yol açıyordu.

**Çözüm:** `Decorator` örüntüsü kullanılarak nesnelerin yapısı bozulmadan onlara dinamik olarak yeni özellikler "giydirildi". `ArmorDecorator` ve `SpeedDecorator` gibi sınıflar oluşturularak bu özelliklerin birbirleriyle kombine edilmesi sağlandı.

**Sonuç:** Nesnelere çalışma zamanında (runtime) yeni yetenekler kazandırılabiliyor ve "Single Responsibility" (Tek Sorumluluk) prensibine uyum sağlanmış oldu.
