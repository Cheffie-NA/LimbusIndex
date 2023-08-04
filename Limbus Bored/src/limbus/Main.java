package limbus;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		ArrayList<String> sinnerArr = new ArrayList<String>();
		File file = new File("SinnerInfo/listofsinners.txt");
		Scanner fileGet = new Scanner(file);
		while(fileGet.hasNext()) {
			sinnerArr.add(fileGet.nextLine());
		}
		Sinner sinner = makeSinner("SinnerInfo/" + sinnerArr.get(0));
		Sinner sinnerG = makeSinner("SinnerInfo/" + sinnerArr.get(1));
		Sinner sinnerF = makeSinner("SinnerInfo/" + sinnerArr.get(2));
		System.out.println(sinner.toString());
		fileGet.close();
	}
	
	public static Sinner makeSinner(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		Scanner fileRead = new Scanner(file);
		Skill Skill1 = new Skill(Integer.parseInt(fileRead.nextLine()), Integer.parseInt(fileRead.nextLine()), Integer.parseInt(fileRead.nextLine()), fileRead.nextLine(), fileRead.nextLine(), fileRead.nextLine(), fileRead.nextLine());
		Skill Skill2 = new Skill(Integer.parseInt(fileRead.nextLine()), Integer.parseInt(fileRead.nextLine()), Integer.parseInt(fileRead.nextLine()), fileRead.nextLine(), fileRead.nextLine(), fileRead.nextLine(), fileRead.nextLine());
		Skill Skill3 = new Skill(Integer.parseInt(fileRead.nextLine()), Integer.parseInt(fileRead.nextLine()), Integer.parseInt(fileRead.nextLine()), fileRead.nextLine(), fileRead.nextLine(), fileRead.nextLine(), fileRead.nextLine());
		Sinner sinner = new Sinner(Integer.parseInt(fileRead.nextLine()), Integer.parseInt(fileRead.nextLine()), fileRead.nextLine(), fileRead.nextLine(), Skill1, Skill2, Skill3, fileRead.nextLine());
		fileRead.close();
		return sinner;
	}

}
