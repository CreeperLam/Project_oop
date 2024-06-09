public class HighZombie extends Zombie {
    public HighZombie(GamePanel parent,int lane){
        super(parent,lane);
        setAttack(10);
        setHealth(1500);
        setSpeed(2);
    }

}
