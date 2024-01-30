
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
	}

	public static String tail(String str) {
		if (str.length()==1)
			return "";
		else
		return (str.substring(1));

		}

	public static int levenshtein(String word1, String word2) {
		word1=word1.toLowerCase();
		word2=word2.toLowerCase();
		if (word1.length()==0)
		{
			return (word2.length());
		}
		if (word2.length()==0)
		{
			return(word1.length());
		}
		if (word1.charAt(0)==word2.charAt(0))
		{
			return levenshtein(tail(word1), tail(word2));
		}
		int case1=levenshtein(tail(word1), word2);
		int case2=levenshtein(word1, tail(word2));
		int case3= levenshtein(tail(word1), tail(word2));
		return 1+(Math.min(Math.min(case1,case2),case3));
	}
	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];
		In in = new In(fileName);
		for (int i=0;i<dictionary.length;i++)
		{
			dictionary[i]= in.readLine();
		}
		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
		int [] arr = new int[dictionary.length];
		int minValue = 9999;
		int minIndex = 9999;
		for (int i=0; i<dictionary.length;i++)
		{
			arr[i] = levenshtein(word, dictionary[i]);
			if(arr[i]<minValue)
			{
				minValue=arr[i];
				minIndex=i;
			}			
		}
		if (arr[minIndex]>threshold)
		{
			return word;
		}
		return dictionary[minIndex];

	}

}
