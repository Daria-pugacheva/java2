package ru.gb.pugacheva.trybetterless1j2;

public interface SportActivity {
    void run(SportTrack type);
    void jump(Wall type);
    boolean isAbleToDoThisSport();
}
