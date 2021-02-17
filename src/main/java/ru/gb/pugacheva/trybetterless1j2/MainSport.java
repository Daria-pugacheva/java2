package ru.gb.pugacheva.trybetterless1j2;



public class MainSport {
    public static void main(String[] args) {
        SportActivity[] participants = {
                new Cat("Рыжик"),
                new Human("Олег"),
                new Robot("Champion")
        };

        Object[] equipments = {
                new SportTrack(1000),
                new Wall(2),
                new SportTrack(4000),
                new Wall(1)
        };


        for (int i = 0; i < participants.length; i++) {
            for (int j = 0; j < equipments.length; j++) {
                if (participants[i].isAbleToDoThisSport() == true) {
                    if (equipments[j] instanceof SportTrack) {
                        participants[i].run((SportTrack) equipments[j]);
                    }
                    if (equipments[j] instanceof Wall) {
                        participants[i].jump((Wall) equipments[j]);
                    }
                }
            }
        }
    }

}
