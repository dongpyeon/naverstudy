package bit701.day0912;

public class Desktop {
	private String gcard;
	private String keybord;
	private String mouse;

	Desktop(){
		this.gcard = "라데온";
		this.keybord = "로지텍";
		this.mouse = "로지텍유선";
	}
	
	Desktop(String gcard, String keybord, String mouse){
		this.gcard = gcard;
		this.keybord = keybord;
		this.mouse = mouse;
	}
	
	public void spec() {
		System.out.println("스펙입니다");
		System.out.println("그래픽카드는"+gcard);
		System.out.println("키보드는"+keybord);
		System.out.println("마우스는"+mouse);
	}
}

class Laptop extends Desktop{
	//super()가 들어가 있다는거지?
	private String charge;
	private String mouse;
	
	Laptop(){
		this.charge="1시간짜리 충전기";
		this.mouse = "해커마우스";
	}
	Laptop(String gcard, String keybord, String charge, String mouse){
		super(gcard,keybord,mouse);
		this.charge=charge;
	}
	@Override
	public void spec() {
		// TODO Auto-generated method stub
		super.spec();
		System.out.println("충전기는!?"+charge);
	}
	
	
	
	
	 
}
