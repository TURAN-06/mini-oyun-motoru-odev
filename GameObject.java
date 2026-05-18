import java.util.ArrayList;
import java.util.List;

interface IGameObserver {
    void onGameEvent(String event);
}

interface IMovementStrategy {
    void move();
}

class AggressiveMovement implements IMovementStrategy {
    @Override
    public void move() {
        System.out.println("Düşman oyuncuya doğru agresif bir şekilde saldırıyor!");
    }
}

class CowardlyMovement implements IMovementStrategy {
    @Override
    public void move() {
        System.out.println("Düşman canı az olduğu için arkasına bakmadan kaçıyor!");
    }
}

public class GameObject implements IGameObserver {
    protected String type;
    protected IMovementStrategy movementStrategy;

    public GameObject() {
        // Boş constructor (Factory ve Yapılandırma için)
    }

    public GameObject(String type) {
        this.type = type;
    }

    public void setMovementStrategy(IMovementStrategy strategy) {
        this.movementStrategy = strategy;
    }

    public void update() {
        if (movementStrategy != null) {
            movementStrategy.move();
        } else {
            System.out.println(type + " güncelleniyor fakat aktif bir hareket stratejisi yok.");
        }
    }

    @Override
    public void onGameEvent(String event) {
        System.out.println(type + " oyun etkinliğini aldı: " + event);
    }
}

abstract class GameObjectDecorator extends GameObject {
    protected GameObject decoratedObject;

    public GameObjectDecorator(GameObject decoratedObject) {
        this.decoratedObject = decoratedObject;
        this.type = decoratedObject.type;
        this.movementStrategy = decoratedObject.movementStrategy;
    }

    @Override
    public void update() {
        decoratedObject.update();
    }
}

class ShieldDecorator extends GameObjectDecorator {
    public ShieldDecorator(GameObject decoratedObject) {
        super(decoratedObject);
    }

    @Override
    public void update() {
        super.update();
        System.out.println("-> [Dinamik Özellik] Nesnenin üzerinde aktif bir büyü kalkanı var!");
    }
}

abstract class GameObjectFactory {
    public abstract GameObject createGameObject();
}

class PlayerFactory extends GameObjectFactory {
    @Override
    public GameObject createGameObject() {
        return new GameObject("Player");
    }
}

class EnemyFactory extends GameObjectFactory {
    @Override
    public GameObject createGameObject() {
        GameObject enemy = new GameObject("Enemy");
        enemy.setMovementStrategy(new AggressiveMovement()); 
        return enemy;
    }
}

class GameEngineFacade {
    private List<GameObject> gameObjects = new ArrayList<>();
    private List<IGameObserver> observers = new ArrayList<>();

    public void initializeGame() {
        System.out.println("--- Oyun Motoru Facade Sistemi Başlatılıyor ---");
        
        GameObjectFactory playerFactory = new PlayerFactory();
        GameObjectFactory enemyFactory = new EnemyFactory();

        GameObject player = playerFactory.createGameObject();
        GameObject enemy = enemyFactory.createGameObject();

        GameObject armoredEnemy = new ShieldDecorator(enemy);

        gameObjects.add(player);
        gameObjects.add(armoredEnemy);

        observers.add(player);
        observers.add(enemy);
        
        System.out.println("Sistem Hazır: Nesneler üretildi, dekoratörler ve stratejiler bağlandı.\n");
    }

    public void updateGame() {
        System.out.println("--- Oyun Döngüsü Güncelleniyor (Update) ---");
        for (GameObject obj : gameObjects) {
            obj.update();
        }
        System.out.println();
    }

    public void triggerGlobalEvent(String event) {
        System.out.println("--- Global Olay Tetiklendi: " + event + " ---");
        for (IGameObserver observer : observers) {
            observer.onGameEvent(event);
        }
        System.out.println();
    }
}
