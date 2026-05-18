# Uygulanan Yazılım Tasarım Örüntüleri Raporu

Bu dosyada, "Mini Oyun Motoru" projesinin "if-else" yığınlarından arındırılarak nesne yönelimli programlama (OOP) ve SOLID prensiplerine uygun hale getirilmesi sürecinde uygulanan tasarım örüntüleri detaylandırılmıştır.

---

## 1. Creational Patterns (Nesne Yaratma Örüntüleri)

### Factory Method Pattern (Faz 1)
* **Nerede Kullanıldı:** Oyun nesnelerinin (`Player`, `Enemy`) üretim süreçlerinde uygulandı. `GameObjectFactory` soyut sınıfından türeyen `PlayerFactory` ve `EnemyFactory` sınıfları oluşturuldu.
* **Neden Kullanıldı:** Başlangıç kodunda nesneler String bazlı parametrelerle (`type.equals("Player")`) doğrudan kontrol ediliyor ve nesne yaratma mantığı istemciye bağımlı kalıyordu. Nesne üretimini tek bir merkeze çekmek için bu örüntü tercih edilmiştir.
* **Ne Kazandırdı:** Ana sistemin (`GameObject`) yeni bir karakter tipi eklendiğinde (örneğin `Boss`) modifiye edilme zorunluluğu ortadan kalktı. İstemci kod, nesnelerin somut sınıflarından izole edildi.

---

## 2. Structural Patterns (Yapısal Örüntüler)

### Decorator Pattern (Faz 2)
* **Nerede Kullanıldı:** `GameObject` yapısına dinamik olarak büyü kalkanı (`ShieldDecorator`) özelliği eklemek için kullanıldı. `GameObjectDecorator` soyut sınıfı temel alınarak genişletildi.
* **Neden Kullanıldı:** Karakterlere alt sınıflar (inheritance) yoluyla kalıcı özellikler vermek, ileride kombinasyon patlamasına (örneğin hem zırhlı hem kalkanlı hem hızlı düşman gibi onlarca sınıf türetilmesi) yol açacaktı. Sınıf hiyerarşisini şişirmeden özellik eklemek amacıyla seçildi.
* **Ne Kazandırdı:** Mevcut oyun nesnesi kodlarına hiç dokunmadan, çalışma zamanında (runtime) nesnelere Lego parçası gibi dinamik yetenekler takıp çıkarabilme esnekliği kazanıldı.

### Facade Pattern (Faz 2)
* **Nerede Kullanıldı:** Projenin en tepesinde, tüm oyun motoru alt sistemlerini (Fabrikaları, Nesne Listelerini ve Observer kayıtlarını) tek bir merkezden yöneten `GameEngineFacade` sınıfında kullanıldı.
* **Neden Kullanıldı:** İstemcinin (Main sınıfının) oyun nesnesi üretmek, strateji atamak, event tetiklemek gibi karmaşık alt sistem adımlarıyla doğrudan muhatap olmasını engellemek için seçildi.
* **Ne Kazandırdı:** Karmaşık kod blokları tek bir arayüzün arkasına gizlendi. İstemci kod sadece `initializeGame()` ve `updateGame()` metodlarını çağırarak tüm motoru yönetebilir hale geldi (Low Coupling).

---

## 3. Behavioral Patterns (Davranışsal Örüntüler)

### Strategy Pattern (Faz 3)
* **Nerede Kullanıldı:** Karakterlerin yapay zeka hareket kararlarını (`IMovementStrategy`) soyutlaştırmak amacıyla uygulandı. `AggressiveMovement` ve `CowardlyMovement` somut stratejileri yazıldı.
* **Neden Kullanıldı:** Başlangıç kodunda yapay zeka davranışları `if (type.equals("Enemy"))` gibi kontrol bloklarının içine gömülmüştü ve runtime'da bir düşmanın kaçma moduna geçmesi imkansızdı. Davranışları dinamik kılmak için seçildi.
* **Ne Kazandırdı:** Karakterlerin hareket algoritmaları bağımsız birer sınıf haline geldi. Artık bir düşman nesnesi canı azaldığında çalışma zamanında `CowardlyMovement` stratejisine esnekçe geçiş yapabilmektedir.

### Observer Pattern (Faz 3)
* **Nerede Kullanıldı:** Oyun içindeki küresel olayları (örneğin oyunun durması, gecenin başlaması vb.) tüm oyun nesnelerine duyurmak için uygulandı. `IGameObserver` arayüzü oluşturuldu ve `GameObject` bu arayüzü implement etti.
* **Neden Kullanıldı:** **Açık/Kapalı Prensibini (Open/Closed Principle - OCP)** tam anlamıyla simüle etmek; oyun motoruna yeni bir nesne türü katıldığında, global duyuru mekanizmasını bozmadan otomatik olarak sisteme dahil olabilmesini sağlamak için seçildi.
* **Ne Kazandırdı:** Oyun motoru ile oyun nesneleri arasında gevşek bağlı (loosely coupled) bir haberleşme köprüsü kuruldu. Ana motor, hangi nesneye bildirim gönderdiğini detaylıca bilmek zorunda kalmadan tek bir döngüyle tüm aboneleri uyarabilir hale geldi.
