package exercise5.main;

import exercise5.players.PlayerSoccer;
import exercise5.players.PlayerBasketball;

public class Exercise1 {

    public static void main(String[] args) {
        PlayerSoccer playerSoccer = new PlayerSoccer("Martin", "Simarra", "12-06-2001", 12345, 70, 1.80, 20, "Pierna izquierda", 80, false, 90);
        
        playerSoccer.score();
        playerSoccer.infoPlayer();
        
        PlayerBasketball playerBasket = new PlayerBasketball("Martin", "Simarra", "12-06-2001", 12345, 70, 1.80, 20, 5500, 7000, "Salto alto", 200, 10000);
        
        playerBasket.score();
        playerBasket.infoPlayer();
        
    }
}
