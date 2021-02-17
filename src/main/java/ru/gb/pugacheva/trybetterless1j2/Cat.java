package ru.gb.pugacheva.trybetterless1j2;

public class Cat implements SportActivity {
    private String name;
    private int maxDistance;
    private int maxHeight;
    private boolean ableToDoThisSport;

    public Cat(String name) {
        this.name = name;
        this.maxDistance = 500;
        this.maxHeight = 2;
        this.ableToDoThisSport = true;
    }
    @Override
    public boolean isAbleToDoThisSport() {
        return ableToDoThisSport;
    }

    @Override
    public void run(SportTrack type) {
        if (type.getDistance() <= maxDistance) {
            System.out.println("Кот " + name + " пробежал " + type.getDistance());
        } else {
            System.out.println("Кот " + name + " не может пробежать дистанцию " + type.getDistance()
                    + " метров. Прекращает участие в соревнованиях.");
            ableToDoThisSport = false;
        }
    }

    @Override
    public void jump(Wall type) {
        if (type.getHeight() <= maxHeight) {
            System.out.println("Кот " + name + " перепрыгнул " + type.getHeight());
        } else {
            System.out.println("Кот " + name + " не может перепрыгнуть " + type.getHeight()
                    + " метров. Прекращает участие в соревнованиях.");
            ableToDoThisSport = false;
        }
    }
}
