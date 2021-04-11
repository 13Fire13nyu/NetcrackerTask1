package ru.ncedu.belash;

/** Класс для реализации заданий. 
 * <p>Для решения задания 1 используется класс SquareEquation.</p>
 * <p>Для решения задания 2 используются 2 класса:</p>
 * <ul>
 * <li> Класс Bones для создания игрока;
 * <li> Класс Scores для определения победителя раунда.
 * </ul>
 * @author Белаш М.
 */
public class MainClass {
    // Метод для реализации задания 1 (решение квадратного уравнения).
    public void task1(){
        SquareEquation sq = new SquareEquation(3,-15,1);
        sq.getResults();
    }
    // Метод для реализации задания 2 (игра "Кости").
    public void task2(){
        int n = 5; //количество игроков
        int k = 4; //количество бросков
        Bones[] player = new Bones[n-1];
        for(int i=0;i<n-1;i++){
            player[i]=new Bones();
        }
        Bones computer = new Bones();
        boolean exitGame = false;
        int winNum=0;
        
        
        // Начало игры
        while (exitGame==false){
            int[] scores = new int[n];
            
            if (winNum==n-1){
                // Сначала ходит компьютер
                System.out.println("Ход компьютера");
                for (int j=0; j<k; j++){
                    computer.setCast(1 + (int)(Math.random() * ((6 - 1) + 1)));
                    System.out.println("Количество очков при "+(j+1)+"-ом броске: "+computer.getCast());
                    computer.calcSumma(computer.getCast());
                }
                System.out.println("Итоговая сумма очков компьютера: "+computer.getSumma());
                scores[n-1]=computer.getSumma();
                
                // Потом ходят остальные игроки
                for (int i=0; i<n-1; i++){
                    System.out.println("Ход игрока под номером "+(i+1));

                    for (int j=0; j<k; j++){
                        player[i].setCast(1 + (int)(Math.random() * ((6 - 1) + 1)));
                        System.out.println("Количество очков при "+(j+1)+"-ом броске: "+player[i].getCast());
                        player[i].calcSumma(player[i].getCast());
                    }
                    System.out.println("Итоговая сумма очков игрока "+ (i+1)+ ": "+player[i].getSumma());
                    scores[i]=player[i].getSumma();
                }
            } else{
                // Сначала ходит победитель
                System.out.println("Ход игрока под номером "+(winNum+1));

                for (int j=0; j<k; j++){
                    player[winNum].setCast(1 + (int)(Math.random() * ((6 - 1) + 1)));
                    System.out.println("Количество очков при "+(j+1)+"-ом броске: "+player[winNum].getCast());
                    player[winNum].calcSumma(player[winNum].getCast());
                }
                System.out.println("Итоговая сумма очков игрока "+ (winNum+1)+ ": "+player[winNum].getSumma());
                scores[winNum]=player[winNum].getSumma();
                
                // Потом ходят остальные игроки и компьютер
                for (int i=0; i<n-1; i++){
                    if (i==winNum){
                        continue;
                    } else{
                        System.out.println("Ход игрока под номером "+(i+1));

                        for (int j=0; j<k; j++){
                            player[i].setCast(1 + (int)(Math.random() * ((6 - 1) + 1)));
                            System.out.println("Количество очков при "+(j+1)+"-ом броске: "+player[i].getCast());
                            player[i].calcSumma(player[i].getCast());
                        }
                        System.out.println("Итоговая сумма очков игрока "+ (i+1)+ ": "+player[i].getSumma());
                        scores[i]=player[i].getSumma();
                    }  
                }
                
                // Ход компьютера
                System.out.println("Ход компьютера");
            
                for (int j=0; j<k; j++){
                    computer.setCast(1 + (int)(Math.random() * ((6 - 1) + 1)));
                    System.out.println("Количество очков при "+(j+1)+"-ом броске: "+computer.getCast());
                    computer.calcSumma(computer.getCast());
                }
                System.out.println("Итоговая сумма очков компьютера: "+computer.getSumma());
                scores[n-1]=computer.getSumma();
            }
            // Подсчет результатов раунда
            Scores scr=new Scores();
            scr.setScore(scores);

            winNum=scr.Winner();
            
            // Подсчет результатов всей игры
            if (winNum==n-1){
                computer.increaseWins();
                System.out.println("КОЛИЧЕСТВО ПОБЕД КОМПЬЮТЕРА: "+computer.getCountWins());
                if (computer.getCountWins()==7){
                    System.out.println("ИТОГ ИГРЫ: ПОБЕДИЛ КОМПЬЮТЕР! КОНЕЦ ИГРЫ!");
                    exitGame = true;
                }
            } else{
                player[winNum].increaseWins();
                System.out.println("КОЛИЧЕСТВО ПОБЕД ИГРОКА "+(winNum+1)+": "+player[winNum].getCountWins());
                if (player[winNum].getCountWins()==7){
                    System.out.println("ИТОГ ИГРЫ: ПОБЕДИЛ ИГРОК ПОД НОМЕРОМ "+(winNum+1)+"! КОНЕЦ ИГРЫ!");
                    exitGame = true;
                }

            }
            // Обнуление суммы очков раунда для продолжения игры
            for (int i=0; i<n-1;i++){
                player[i].setSumma(0);
            }
            computer.setSumma(0);
        }
    }
    
    
    public static void main(String[] args) {
        MainClass realization = new MainClass();
        
        realization.task1();
        
        realization.task2();
    }  
    
}
