package mycar.data;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mycar")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyCarDto {
	
	@Id //각 엔터티를 구별할 수 있도록 식별 아이디를 갖도록 설계
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment를 주기 위한거래여
	private Long num;
	
	@Column(name = "car_name",length = 30)
	private String carname;
	
	private int carprice;
	
	@Column(length = 20)
	private String carcolor;
	
	@Column(length = 30) //length 생략시 255
	private String carguip;
	
	@Column(length = 100)
	private String carphoto;
	
	@Column(updatable = false) //수정 시 컬럼을 제외하겠다. (안하면 날짜가 수정할대마다 계속 업뎃됨)
	@CreationTimestamp()
	private Timestamp writeday;
	
	@Transient // @Transient : 테이블의 컬럼으로는 생성되지 않고 객체에서만 사용가능한 멤버변수
	private int commentcount;
	
	@Transient
	private String message;
}
