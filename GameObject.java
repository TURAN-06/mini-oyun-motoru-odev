public class GameObject {
    String type; // "Player", "Enemy", "Npc"
    
    public GameObject(String type) {
        this.type = type;
    }

    public void update() {
        if (type.equals("Player")) {
            System.out.println("Oyuncu klavyeden girdi bekliyor...");
        } else if (type.equals("Enemy")) {
            System.out.println("Düşman oyuncuya doğru saldırıyor!");
        } else if (type.equals("Npc")) {
            System.out.println("Npc etrafta boş boş dolaşıyor.");
        }
    }
}
