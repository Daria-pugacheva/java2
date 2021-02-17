package ru.gb.pugacheva.trybetterless1j2;

public class Human implements SportActivity{
    private String name;
    private int maxDistance;
    private int maxHeight;
    private boolean ableToDoThisSport;

    public Human(String name){
        this.name=name;
        this.maxDistance=3000;
        this.maxHeight=2;
        this.ableToDoThisSport=true;
    }
    @Override
    public boolean isAbleToDoThisSport() {
        return ableToDoThisSport;
    }

    @Override
    public void run(SportTrack type) {
        if(type.getDistance()<=maxDistance) {
            System.out.println(name + " пробежал " + type.getDistance() + " метров.");
        }else{
            System.out.println(name + " не может пробежать дистанцию " + type.getDistance()
                    + " метров. Прекращает участие в соревнованиях.");
            ableToDoThisSport=false;
        }

    }

    @Override
    public void jump(Wall type) {
        if(type.getHeight()<=maxHeight) {
            System.out.println(name + " перепрыгнул " + type.getHeight() + " метров.");
        }else {
            System.out.println(name + " не может перепрыгнуть " + type.getHeight()
                    + " метров. Прекращает участие в соревнованиях.");
            ableToDoThisSport=false;
        }

    }
}
