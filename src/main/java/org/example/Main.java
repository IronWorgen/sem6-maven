package org.example;

public class Main {
    public static void main(String[] args) {

        Game game = new Game();

        int firstWinner =0;
        int secondWinner =0;
        for (int j = 0; j < 1000; j++) {
            int counter1 = 0;
            int counter2 = 0;

            for (int i = 0; i < 1000; i++) {
                counter1 += game.startGame()? 1:0;
            }
            game.setSwapChoice(false);
            for (int i = 0; i < 1000; i++) {
                counter2 += game.startGame()? 1:0;
            }
//            System.out.println("при смене выбора --- "+counter1);
//            System.out.println("если оставить первый вариант --- "+counter2);
            if (counter1>counter2){
                firstWinner++;
            }else {
                secondWinner++;
            }
        }
        System.out.println("побед при смене выбора --- "+firstWinner);
        System.out.println("поражений при смене выбора --- "+secondWinner);


    }
}