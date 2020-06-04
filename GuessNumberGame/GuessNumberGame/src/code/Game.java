package code;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int number = getNumberByRandom();
		System.out.println("猜数字游戏：");
		System.out.println("请输入一个0-100的整数：");
		int number_input = input.nextInt();
		int min = 0;
		int max = 100;
		int count = 1;
		while(number != number_input) {
			count ++;
			ArrayList<Integer> al = getRange(number_input, number,min,max);
			min = al.get(0);
			max = al.get(al.size() - 1);
			System.out.println("请继续在" + min + "到" + max +"之间输入");
			number_input = input.nextInt();
			while(number_input < min || number_input > max) {
				System.out.println("不在范围内！重新输入");
				number_input = input.nextInt();
			}
		}
		System.out.println("恭喜你猜对了！！"+"一共用了"+count+"次机会！输入的数字不在范围内不计入次数！");
		System.out.println("答案是："+ number);
		input.close();
}
		
	public static int getNumberByRandom() {
		Random random = new Random();
		int n = random.nextInt(101);
		return n;
	}
	
	public static ArrayList<Integer> getRange(int number_input,int number,int min,int max){
		ArrayList<Integer> al = new ArrayList<Integer>();
		if(number_input > number) {
			al.add(min);
			al.add(number_input);
		}
		else {
			al.add(number_input);
			al.add(max);
		}
		return al;
	}
}

