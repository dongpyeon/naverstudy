import java.util.ArrayList;
import java.util.List;

public class Ex1_teacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Teacher tc1 = new Teacher("이병철","james","김김박");
		System.out.println("한국썜은"+tc1.kor);
		
		List<Teacher> tlist = new ArrayList<>(); 
		
		
		//리스트 추가
		tlist.add(new Teacher("한국1", "영어1", "수학1"));
		tlist.add(new Teacher("한국2", "영어2", "수학2"));
		tlist.add(new Teacher("한국3", "영어3", "수학3"));
		tlist.add(new Teacher("한국4", "영어4", "수학4"));
		
		//출력
		for(int i=0; i<tlist.size(); i++)
		{
			Teacher tc = tlist.get(i);
			System.out.println(tc.kor+ tc.eng+ tc.mat);
		}
	}

}
