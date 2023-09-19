package bit701.day0911;

public class Account2 {
	private String AcNum;
	private String AcName;
	private int Money;

	Account2(String number, String name, int money){
		this.AcNum=number;
		this.AcName=name;
		this.Money=money;
	}

	public boolean chenckno(String number) { //맞는지 확인
		if(number.equals(this.AcNum))
				return true;
		else
			return false;

	}
	
	public void plusMoney(int money) {
		this.Money+=money;
	}
	
	public void minusMoney(int money) {
		this.Money-=money;
	}
	public void viewList() { //입금목록 출력
		System.out.println(AcNum+"\t"+AcName+"\t"+Money);
	}
	
}

