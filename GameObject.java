interface IGameObject {
    void update();
}

class Player implements IGameObject {
    @Override
    public void update() {
        System.out.print("Oyuncu hareket ediyor");
    }
}

class Enemy implements IGameObject {
    @Override
    public void update() {
        System.out.print("Düşman devriye geziyor");
    }
}

abstract class GameObjectDecorator implements IGameObject {
    protected IGameObject decoratedObject;

    public GameObjectDecorator(IGameObject decoratedObject) {
        this.decoratedObject = decoratedObject;
    }

    public void update() {
        decoratedObject.update();
    }
}

class ArmorDecorator extends GameObjectDecorator {
    public ArmorDecorator(IGameObject decoratedObject) {
        super(decoratedObject);
    }

    @Override
    public void update() {
        super.update();
        System.out.print(" + [Zırh Aktif: Defans arttı]");
    }
}

class SpeedDecorator extends GameObjectDecorator {
    public SpeedDecorator(IGameObject decoratedObject) {
        super(decoratedObject);
    }

    @Override
    public void update() {
        super.update();
        System.out.print(" + [Hız İksiri: Daha hızlı hareket ediyor]");
    }
}
