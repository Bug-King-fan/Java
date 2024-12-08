package 案例;

import java.util.*;

/**
 * @author Frank
 * @date 2024/10/20/12:06
 */
public class 斗地主 {
    public static void main(String[] args) {
        Room room = new Room();
        shu(room);
        room.Print();
        System.out.println("_____________________");
        //发牌
        TreeSet<Card> play1 = new TreeSet<>();
        TreeSet<Card> play2 = new TreeSet<>();
        TreeSet<Card> play3 = new TreeSet<>();
        TreeSet<Card> diPai = new TreeSet<>();
        for (int i = 0; i < 54; i++) {
            if (i < 51) { // 0-50为玩家牌
                if (i % 3 == 0) {
                    play1.add(room.getCard(i));
                } else if (i % 3 == 1) {
                    play2.add(room.getCard(i));
                } else if (i % 3 == 2) {
                    play3.add(room.getCard(i));
                }
            } else { // 51和52为底牌
                diPai.add(room.getCard(i));
            }
        }

        System.out.println("玩家1:" + play1.size() + " " + play1);
        System.out.println("玩家2:" + play2.size() + " " + play2);
        System.out.println("玩家3:" + play3.size() + " " + play3);
        System.out.println("底牌:" + diPai.size() + " " + diPai);
        System.out.println("总共：" + (play1.size() + play2.size() + play3.size() + diPai.size()));
    }

    public static void shu(Room room) {
        Collections.shuffle(room.getCards(),new Random(Calendar.getInstance().getTimeInMillis()));
    }
}

class Card implements Comparable<Card> {
    private String num;
    private String color;
    private int sort;

    public Card(String num, String color, int sort) {
        this.num = num;
        this.color = color;
        this.sort = sort;
    }

    public Card() {
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return color + num;
    }

    @Override
    public int compareTo(Card o2) {
        return compareCards(this, o2);
    }

    private int compareCards(Card o1, Card o2) {
        // 定义牌的大小顺序
        int value1 = getCardValue(o1);
        int value2 = getCardValue(o2);

        // 比较牌的值，越大越靠前
        return value2 == value1 ? 1 : Integer.compare(value2, value1);
//        return Integer.compare(value2,value1);
    }

    // 根据牌的数字返回对应的大小
    private int getCardValue(Card card) {
        switch (card.getNum()) {
            case "2":
                return 15;
            case "A":
                return 14;
            case "K":
                return 13;
            case "Q":
                return 12;
            case "J":
                return 11;
            case "10":
                return 10;
            case "9":
                return 9;
            case "8":
                return 8;
            case "7":
                return 7;
            case "6":
                return 6;
            case "5":
                return 5;
            case "4":
                return 4;
            case "3":
                return 3;
            case "大王":
                return 17; // 最高
            case "小王":
                return 16; // 最低
            default:
                return 0; // 不合法牌
        }
    }
}

class Room {
    private ArrayList<Card> cards = new ArrayList<>();

    public Room() {
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        String[] colors = {"♠", "♥", "♣", "♦"};
        int size = 1;
        for (var num : numbers) {
            for (var color : colors) {
                Card ca = new Card(num, color, size++);
                cards.add(ca);
            }
        }
        cards.add(new Card("小王", "", size++));
        cards.add(new Card("大王", "", size++));
    }

    public void Print() {
        System.out.println(this.cards.size());
        System.out.println(this.cards.toString());
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Card getCard(int i) {
        return cards.get(i);
    }
}