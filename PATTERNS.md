# Uygulanan Tasarım Örüntüleri - Faz 1

## 1. Factory Method (Yaratımsal Örüntü)

**Sorun:** Nesnelerin (Player, Enemy) doğrudan `Main` veya `GameObject` sınıfı içinde `new` anahtar kelimesiyle ve if-else kontrolüyle oluşturulması, kodun esnekliğini azaltıyordu.

**Çözüm:** `GameObjectFactory` sınıfı oluşturularak nesne yaratma sorumluluğu bu sınıfa devredildi. Artık sisteme yeni bir nesne türü (örneğin "Boss") eklendiğinde, istemci kodun (`Main`) değişmesine gerek kalmadan sadece fabrika üzerinden üretim yapılabiliyor.

**Sonuç:** Nesne yaratma mantığı merkezileşti ve "Gelişime Açık, Değişime Kapalı" (OCP) prensibine uygun bir yapı kuruldu.
