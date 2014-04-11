import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagram {
	
	public static boolean isAnagram(String word1, String word2){
		// rat:art || rat:trap
		if(word1.length() != word2.length()){
			return false;
		}
		char [] w1 = word1.toCharArray();
		char [] w2 = word2.toCharArray();
		
		boolean flag = false;
		
		for(char c1 : w1){
			for(char c2 : w2){
				System.out.println(c1 + " - " + c2);
				if(c2 == c1){
					flag = true;
					break;
				}
			}
			if(!flag) return false;
		}
		return true;
	}
	
	public static Map<String,List<String>> findAnagram(String [] testString){

		Map<String,List<String>> anagramMap = new HashMap<String,List<String>>();
		for(String s : testString){
			char [] c = s.toCharArray();
			Arrays.sort(c);
			String key = new String(c);
			if(anagramMap.get(key) == null){
				List<String> values = new ArrayList<String>();
				values.add(s);
				anagramMap.put(key,values);
			}else{
				List<String> values = anagramMap.get(key);
				values.add(s);
			}
		}
		
		return anagramMap;
			
	}
	
	public static void createAnagram(String s){
		int sizeOfString = s.length();
		StringBuffer sb = new StringBuffer(s);
		int i,j;
		for(i=0;i<sizeOfString;i++){
			for(j=0;j<sizeOfString;j++){
				if(j==sizeOfString-1){
					break;
				}
				StringBuffer sb1 = swap(sb,j,j+1);
				System.out.println("anagram :- " + sb1.toString());
			}
		}
		
	}
	
	public static StringBuffer swap(StringBuffer s,int i, int j){
		char a = s.charAt(j);
		s.setCharAt(j,s.charAt(i));
		s.setCharAt(i, a);
		return s;
	}
	
	public static void main(String[] args) {

		boolean result = isAnagram("cat","act");
		System.out.println("Are the words anagram : -" + result);
		
		String [] testString = {"pat","tap","hat"};
		Map<String,List<String>> resultSet = findAnagram(testString);
		for(Map.Entry<String,List<String>> s : resultSet.entrySet()){
			if(s.getValue().size()==1){
				continue;
			}
			for(String s1 : s.getValue()){
				System.out.println("result set :- " + s.getKey() + " " + s1);
			}
			
		}
		
		createAnagram("house");
		
	}

}
