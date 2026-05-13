interface IMovementStrategy {
    void move();
}

class AggressiveMovement implements IMovementStrategy {
    public void move() {
        System.out.println(" -> Davranış: Agresif! Doğrudan hedefe saldırıyor.");
    }
}

class CowardlyMovement implements IMovementStrategy {
    public void move() {
        System.out.println(" -> Davranış: Korkak! Canı azaldı, uzağa kaçıyor.");
    }
}

class SmartEnemy extends Enemy {
    private IMovementStrategy strategy;

    public void setStrategy(IMovementStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void update() {
        super.update(); 
        if (strategy != null) {
            strategy.move();
        }
    }
}
