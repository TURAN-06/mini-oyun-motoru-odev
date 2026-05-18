# C - Mini Oyun Motoru Modülü (Faz 3 Son Durum)

### 🎯 Seçim Gerekçesi
Çok oyun oynayan biri olarak, oyunlardaki karakterlerin ve nesnelerin arka planda nasıl bir sistemle çalıştığını her zaman merak etmişimdir. Bu projeyi; oyun mekaniklerinin "if-else" yığınlarına ve kod karmaşıklığına düşmeden nasıl profesyonelce yönetilebileceğini tasarım örüntüleri üzerinden öğrenmek için seçtim. Başlangıç kodunda tüm oyun nesneleri tek bir God Class içerisindeki if-else bloklarıyla yönetiliyordu. Bu durumun genişletilebilirliği engellediğini gördüğüm için C konusunu seçtim. Amacım, severek vakit geçirdiğim oyun dünyasının yazılım mutfağındaki çözümlerini bizzat uygulayarak deneyimlemektir.

### 🏗 Kullanılan Tasarım Örüntüleri

* **Factory Method (Creational - Faz 1):** Nesne üretim sorumluluğunu merkezi ve esnek bir yapıya taşıyarak nesne yaratma süreçlerini standartlaştırmak amacıyla uygulandı.
* **Decorator (Structural - Faz 2):** Nesnelerin mevcut kod yapısını kırmadan, karakterlere ve oyun nesnelerine dinamik özellikler kazandırmak amacıyla uygulandı.
* **Strategy (Behavioral - Faz 3):** Karakterlerin yapay zeka hareket kararlarını ve davranışlarını if-else kullanmadan, çalışma zamanında (runtime) esnekçe değiştirebilmek ve Açık/Kapalı Prensibini (OCP) sağlamak amacıyla uygulandı.

### 📊 Mimari Diyagram (UML)

```mermaid
classDiagram
    class GameObject {
        +String type
        +IMovementStrategy movementStrategy
        +update()
    }
    class IMovementStrategy {
        <<interface>>
        +move()
    }
    class AggressiveMovement {
        +move()
    }
    class CowardlyMovement {
        +move()
    }
    GameObject --> IMovementStrategy
    IMovementStrategy <|.. AggressiveMovement
    IMovementStrategy <|.. CowardlyMovement
