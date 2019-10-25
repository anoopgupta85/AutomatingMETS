package day3;

public class hasEqualSum {

	public static void main(String[] args) {

		boolean addition = hasEqualSum(1, -1, 0);
		System.out.println(addition);

	}

	public static boolean hasEqualSum(int num1, int num2, int num3) {

		boolean result = false;

		if (num1 + num2 == num3) {

			result = true;
		}

		else {

			result = false;
		}

		return result;

	}
}
