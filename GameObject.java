interface IGameObject {
    void update();
}

class Player implements IGameObject {
    @Override
    public void update() {
        System.out.println("Oyuncu hareketleri güncelleniyor...");
    }
}

class Enemy implements IGameObject {
    @Override
    public void update() {
        System.out.println("Düşman yapay zekası hesaplanıyor...");
    }
}

class GameObjectFactory {
    public static IGameObject createObject(String type) {
        if (type.equalsIgnoreCase("Player")) {
            return new Player();
        } else if (type.equalsIgnoreCase("Enemy")) {
            return new Enemy();
        }
        return null;
    }
}
