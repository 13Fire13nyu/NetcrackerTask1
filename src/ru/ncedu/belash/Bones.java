/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ncedu.belash;

/**
 * Класс для игрока в игру "Кости". Реализация игры в кости. Играют N игроков (компьютер в списке последний).
 * Подкидываются одновременно К кубиков. Выигрывает тот, у кого большая
 * сумма очков. Кто выиграл, тот и кидает первым в следующем кону. Игра идет
 * до 7 выигрышей. Начинаете игру Вы.
 * 
 * @params n,k Количество игроков и кубиков соответственно.
 * @param summa Накопительная сумма очков для игрока. По умолчанию равна 0.
 * @param cast Количество очков в текущем броске. До начала бросков равна 0.
 * @param count Количество выйгрышей игрока
 * @author Белаш М.
 */
public class Bones {
    private int summa;
    private int cast;
    private int countWins;
    
    public Bones() {
        this.summa=0;
        this.cast=0;
        this.countWins=0;
    }

    public Bones(int summa, int cast,int countWins) {
        this.summa = summa;
        this.cast = cast;
        this.countWins=countWins;
    }
    // Возвращает сумму очков игрока за 1 раунд.
    public int getSumma() {
        return this.summa;
    }
    // Устанавливает сумму очков игрока за 1 раунд.
    public void setSumma(int summa) {
        this.summa = summa;
    }
    // Возвращает количество выпавших после броска одного кубика очков.
    public int getCast() {
        return this.cast;
    }
    // Устанавливает значение количества выпавших очков.
    public void setCast(int cast) {
        this.cast = cast;
    }
    // Увеличивает количество побед игрока.
    public void increaseWins(){
        this.countWins+=1;
    }
    // Возвращает количество побед игрока.
    public int getCountWins() {
        return countWins;
    }
    // Подсчитывает количество очков игрока за 1 раунд.
    public void calcSumma(int cast){
        this.summa+=cast;
        //System.out.println("Текущая сумма: "+this.summa);
    }
    public static void main(String[] args) {
        System.out.println("Новый игрок!");
    }   
}


