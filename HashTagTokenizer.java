

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args [0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
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

	public static boolean existInDictionary(String word, String []dictionary) {
		for (int i=0;i<dictionary.length;i++)
		{
			if (word.length()== dictionary[i].length())
			{
				boolean innerCheck = true;
				for(int j=0; j<word.length();j++)
				{
					if (word.charAt(j)!=dictionary[i].charAt(j))
					{
						innerCheck=false;
					}
				}
				if (innerCheck)
				return true;
			}
		}
		return false;
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {

		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
        }
        int N = hashtag.length();
		boolean innerCheck = false;// checks to see if a word was found within the hashtag
		int newword = 0;
		hashtag=hashtag.toLowerCase();
        for (int i = 1; i <= N; i++) 
		{
			String sub =hashtag.substring(0, i);
			if (existInDictionary(sub, dictionary))
			{
				System.out.println(sub);
				 newword= i;
				 innerCheck=true;
			}	

        }
		if(innerCheck)// if a word was found, preform the function again on the remaining hashtag
			{
				breakHashTag(hashtag.substring(newword), dictionary);
			}
		else
			return;
    }
	
 }
