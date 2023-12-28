package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {
    private boolean swapChoice = true;
    Map<Integer, String> doors = new HashMap<>();



    /**
     * сыграть раунд
     * @return - true -> выиграли машину / false -> козу;
     */
    public boolean startGame(){
        createDoors();
        int firstChoice = new Random().nextInt(1,4);
        removeGoat(firstChoice);
        if (swapChoice){
            for (Integer integer : doors.keySet()) {
                if(integer!=firstChoice){
                    return itCar(integer);
                }
            }
        }
        return itCar(firstChoice);
    }
    private boolean itCar(int choice){
        return doors.get(choice).equals("Машина");
    }

    /**
     * открывает дверь с козой
     */
    private void removeGoat(int choice){
        int num;
        do {
            num = new Random().nextInt(1,4);
        }while (doors.get(num).equals("Машина")||num==choice);
        doors.remove(num);
    }

    private void createDoors(){
        doors =  new HashMap<>();
        doors.put(new Random().nextInt(1,4),"Машина");
        for (int i = 1; i < 4; i++) {
            if (doors.get(i)==null){
                doors.put(i, "Коза");
            }
        }
    }
}
