# C - Mini Oyun Motoru Modülü (Faz 3 Son Durum)

### 🎯 Seçim Gerekçesi
Çok oyun oynayan biri olarak, oyunlardaki karakterlerin ve nesnelerin arka planda nasıl bir sistemle çalıştığını her zaman merak etmişimdir. Bu projeyi; oyun mekaniklerinin "if-else" yığınlarına ve kod karmaşıklığına düşmeden nasıl profesyonelce yönetilebileceğini tasarım örüntüleri üzerinden öğrenmek için seçtim. Başlangıç kodunda tüm oyun nesneleri tek bir God Class içerisindeki if-else bloklarıyla yönetiliyordu. Bu durumun genişletilebilirliği engellediğini gördüğüm için C konusunu seçtim. Amacım, severek vakit geçirdiğim oyun dünyasının yazılım mutfağındaki çözümlerini bizzat uygulayarak deneyimlemektir.

### 🏗 Kullanılan Tasarım Örüntüleri

* **Factory Method (Creational - Faz 1):** Nesne üretim sorumluluğunu merkezi ve esnek bir yapıya taşıyarak nesne yaratma süreçlerini standartlaştırmak amacıyla uygulandı.
* **Decorator (Structural - Faz 2):** Nesnelerin mevcut kod yapısını kırmadan, karakterlere ve oyun nesnelerine dinamik özellikler (büyü kalkanı vb.) kazandırmak amacıyla uygulandı.
* **Facade (Structural - Faz 2):** Karmaşık alt sistemleri, fabrikaları ve oyun döngüsü yönetimini tek bir çatı altında toplayarak istemci bağımlılığını en aza indirmek için uygulandı.
* **Strategy (Behavioral - Faz 3):** Karakterlerin yapay zeka hareket kararlarını ve davranışlarını if-else kullanmadan, çalışma zamanında (runtime) esnekçe değiştirebilmek amacıyla uygulandı.
* **Observer (Behavioral - Faz 3):** Oyun içindeki global etkinlikleri ve durum değişikliklerini, nesnelere gevşek bağlı (loosely coupled) bir mimariyle duyurarak Açık/Kapalı Prensibini (OCP) tam anlamıyla sağlamak için uygulandı.

### 📊 Mimari Diyagram (UML)

```mermaid
classDiagram
    class GameEngineFacade {
        -List~GameObject~ gameObjects
        -List~IGameObserver~ observers
        +initializeGame()
        +updateGame()
        +triggerGlobalEvent(String event)
    }
    class GameObject {
        +String type
        +IMovementStrategy movementStrategy
        +update()
        +onGameEvent(String event)
    }
    class IGameObserver {
        <<interface>>
        +onGameEvent(String event)
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
    class GameObjectDecorator {
        <<abstract>>
        #GameObject decoratedObject
        +update()
    }
    class ShieldDecorator {
        +update()
    }

    GameEngineFacade --> GameObject
    GameEngineFacade --> IGameObserver
    IGameObserver <|.. GameObject
    GameObject --> IMovementStrategy
    IMovementStrategy <|.. AggressiveMovement
    IMovementStrategy <|.. CowardlyMovement
    GameObject <|-- GameObjectDecorator
    GameObjectDecorator <|-- ShieldDecorator
