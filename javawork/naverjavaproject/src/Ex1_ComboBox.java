import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Ex1_ComboBox extends JFrame{
	
	JPanel p = new JPanel();
	JComboBox<String> combo;
	JRadioButton rbYellow,rbMagenta,rbGray,rbBlue;
	JLabel lblMessage;
	
	public Ex1_ComboBox(String title) {
		// TODO Auto-generated method stub
		super(title);
		this.setBounds(400, 100, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임종료해주는 메서드
		this.setDesign();
		
		this.setVisible(true);
	}

	private void setDesign() {
		// TODO Auto-generated method stub
		Vector<String> list = new Vector<String>();
		list.add("빨강");
		list.add("초록");
		list.add("분홍");
		list.add("오렌지");
		
		//콤보박스 생성
		combo=new JComboBox<String>(list);
		//상산에추가
		//this.add("North",combo); //상단 전체에 추가된다
		JPanel pTop=new JPanel();
		pTop.add(combo);
		this.add("North",pTop);
		
		//Center 에는 JPanel p 를 추가
		p.setBackground(Color.red);
		this.add("Center",p);
		
		//콤보박스 이벤트
		combo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				//선택한 문자열을 얻어보자
				
				String selectColor = (String)combo.getSelectedItem();
				//System.out.println(selectColor);
				//jdk8부터 switch 에서 String도 가능
				switch(selectColor)
				{
				case "빨강":
					p.setBackground(Color.red);
					break;
				case "분홍":
					p.setBackground(Color.pink);
					break;
				case "오렌지":
					p.setBackground(Color.orange);
					break;
				case "초록":
					p.setBackground(Color.green);
					break;
				}
			}
		});
		
		//하단에4개의 라디오버튼 추가하기
		ButtonGroup bg = new ButtonGroup();
		rbYellow= new JRadioButton("노랑");
		rbBlue= new JRadioButton("파랑");
		rbMagenta= new JRadioButton("핫핑크");
		rbGray= new JRadioButton("회색");
		
		bg.add(rbBlue);
		bg.add(rbYellow);
		bg.add(rbMagenta);
		bg.add(rbGray);
		
		//4개의 라디오 버튼을 일단 패널에 묶어서 넣은 후 프레임에 추가하기
		JPanel pBottom=new JPanel();
		pBottom.add(rbYellow);
		pBottom.add(rbBlue);
		pBottom.add(rbGray);
		pBottom.add(rbMagenta);
		
		this.add("South",pBottom);

		

		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1_ComboBox ex = new Ex1_ComboBox("ComboBox");
	}

}
