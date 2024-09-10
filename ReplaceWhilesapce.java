
/**
 * Write a mtthod to replace all spaces in a string with "%20". You may assume
 * that the string has sufficient space at the end to hold the additional
 * characters, and that you are given the "true" length of the string.
 * Note: if implementing in Java, please use a character array so that you can
 * perform this in place
 */
public class ReplaceWhilesapce {
	public static void main(String[] args) {

	}

	public void test(char[] str, int trueLength, Character replace) {
		// need to count the number of occurance of target char
		int count = count(str, 0, trueLength, ' ');
		int newIndex = trueLength - 1 + count * 2;

		// if there are excess spaces, add a null character. thois indicates that the
		// spaces after the point have not been replaced with &20
		if (newIndex + 1 > str.length)
			str[newIndex + 1] = '\0';

		for (int oldIndex = trueLength; oldIndex >= 0; oldIndex -= 1) {
			if (str[oldIndex] == ' ') { // replace with '%20'
				str[newIndex] = '0';
				str[newIndex - 1] = '2';
				str[newIndex - 2] = '%';
				newIndex -= 3;
			} else {
				str[newIndex] = str[oldIndex];
			}
		}
	}

	public int count(char[] str, int start, int end, int target) {
		int count = 0;
		for (int i = start; i < end; i++) {
			if (str[i] == target) {
				count++;
			}
		}

		return count;
	}
}
