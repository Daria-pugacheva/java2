package ru.gb.pugacheva.trybetterless1j2;

public class Robot implements SportActivity{
    private String model;
    private int maxDistance;
    private int maxHeight;
    private boolean ableToDoThisSport;

    public Robot(String model){
        this.model=model;
        this.maxDistance=2000;
        this.maxHeight=1;
        this.ableToDoThisSport=true;
    }

    @Override
    public boolean isAbleToDoThisSport() {
        return ableToDoThisSport;
    }

    @Override
    public void run(SportTrack type) {
        if(type.getDistance()<=maxDistance) {
            System.out.println("Робот " + model + " пробежал " + type.getDistance() + " метров.");
        }else {
            System.out.println("Робот " + model + " не может пробежать дистанцию " + type.getDistance()
                    + " метров. Прекращает участие в соревнованиях.");
            ableToDoThisSport=false;
        }

    }

    @Override
    public void jump(Wall type) {
        if(type.getHeight()<=maxHeight) {
            System.out.println("Робот " + model + " перепрыгнул " + type.getHeight());
        }else {
            System.out.println("Робот " + model + " не может перепрыгнуть " + type.getHeight()
                    + " метров. Прекращает участие в соревнованиях.");
            ableToDoThisSport=false;
        }
    }
}
