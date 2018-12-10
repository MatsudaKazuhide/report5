package jp.ac.uryukyu.ie.e185756;

public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    public LivingThing(String name, int hitPoint, int attack){
        this.dead = false;
        this.name = name;
        this.hitPoint = hitPoint;
        this.attack = attack;
    }

    public boolean isDead(){
        return this.dead;
    }

    public String getName(){
        return this.name;

    }

    public int getHitPoint(){
        return this.hitPoint;

    }

    /**
     * 攻撃処理をするメソッド。
     * @param opponent
     * 死亡判定を行う。
     * attackに応じて乱数でダメージを算出し、opponent.wounded(damage)によりダメージ処理を実行。
     */
    public void attack(LivingThing opponent){
        if(this.dead == false) {
            int damage = (int) (Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", this.name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint <= 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", this.name);
        }
    }

    public void setHitPoint(int hitPoint){
        this.hitPoint = hitPoint;

    }

    public void setDead(boolean dead){
        this.dead = dead;

    }
}
