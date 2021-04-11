package ru.ncedu.belash;
import java.util.HashMap;

/**
 * Класс для хранения всех очков игроков игры "Кости". 
 * Класс необходим для определения победителя игры. Принимаются только 
 * целочисленные массивы!
 * @param score Количество очков игрока.
 * @author Белаш М.
 */
public class Scores {
    private int[] score;

    public Scores() {}

    public Scores(int[] score) {
        this.score = score;
    }
    // Возвращает массив очков игроков.
    public int[] getScore() {
        return score;
    }
    // Устанавливает массив очков игроков.
    public void setScore(int[] _score) {
        this.score = _score.clone();
    }
    /*
    * Метод для определения победителя игры "Кости". Результат печатается
    * на экране.
    */
    public int Winner() {
        int max_num=0;
        try{
            
            int max_score=this.score[0];
            for (int i=1; i<this.score.length; i++){
                if (this.score[i]>max_score){
                    max_num=i;
                    max_score=this.score[i];
                }
            }
            
            if (max_num==this.score.length-1){
                System.out.println("Победил Компьютер! Количество очков: "+max_score);
            } else{
                System.out.println("Победил игрок под номером " + (max_num+1)+"! Количество очков: "+max_score);
            }
        }
        catch(NullPointerException ex){
            System.out.println("Нет игроков!");
        }
        
        return max_num;
    }
    
    public static void main(String[] args) {
        System.out.println("Подсчет очков и определение победителя!");
    }   
    
}
