package eg;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortingUtil {
	private static  Map<Character, Integer> alphaMap=new HashMap<>();
	
	static {
		String alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 0; i < alpha.length(); i++) {
			alphaMap.put(alpha.charAt(i), i+1);
		}
	}
	
	public long sortByFirstName(String fileName) {
		long count=0;
		if(fileName==null) {
			return count;
		}else {
			try(FileReader fr=new FileReader(fileName);
				BufferedReader br=new BufferedReader(fr);
					){
				String s="";
				List<User> usersList=new ArrayList<>();
				while((s=br.readLine())!=null){
					s=s.replaceAll("[\"]", "");
					String ar[]=s.split(",");
					for(String x:ar) {
						usersList.add(new User(x));
					}
				}
				
				Collections.sort(usersList);
				
				for(int j=0;j<usersList.size();j++) {
					int sum=0;
					String firstName=usersList.get(j).getFirstName();
					for (int i = 0; i < firstName.length(); i++) {
						sum+=alphaMap.get(firstName.charAt(i));
					}
					count=count+(sum*(j+1));
				}
			} catch (FileNotFoundException e) {
				System.out.println(e);
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		return count;
	}

}
