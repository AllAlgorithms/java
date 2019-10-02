public class MinMaxSearch {
	
	public MinMaxSearch(){
		
	}
	

	public int[] searchMinMax(int[] in) {
		int n = in.length;
		int j = 0;
		int min;
		int max;
		int count = 0;
		if (n % 2 == 1) {
			j = j - 1;
			min = in[0];
			max = in[0];
			count = count + 1;
		} else if (in[0] < in[1]) {
			min = in[0];
			max = in[1];
			count = count + 2;
		} else {
			min = in[1];
			max = in[0];
			count = count + 2;
		}
		for (int i = 1; i <= ((n - 1) / 2); i++) {
			if (in[j + 2 * i] <= in[j + 2 * i + 1]) {
				if (in[j + 2 * i] < min) {
					min = in[j + 2 * i];
				}
				if (in[j + 2 * i + 1] > max) {
					max = in[j + 2 * i + 1];
				}
				count = count + 3;
			} else {
				if (in[j + 2 * i + 1] < min) {
					min = in[j + 2 * i + 1];
				}
				if (in[j + 2 * i] > max) {
					max = in[j + 2 * i];
				}
				count = count + 3;
			}
		}

		int[] MinMaxC = { min, max, count };
		return MinMaxC;

	}

}
