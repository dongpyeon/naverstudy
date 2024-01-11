package mycar.data;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
 * 부모테이블 과 서브테이블이 있다
 * 서브테이블 입장에선 ManyToOne  (내 서브키여러개는 하나의 참조된키를 위한 것?)
 * 부모테이블 입장에선 OneToMany 
 * */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "mycar_comment")
public class MyCarCommentDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idx;
	
	@ManyToOne //섭 테이블에는 ManyToOne : 하나의 등록글에 여러개의 댓글을 달 수 있다
	@JoinColumn(name = "num") //어떤 컬럼을 참조(외래키)할 지 
	@OnDelete(action = OnDeleteAction.CASCADE) //부모 테이블 지우면 댓글도 삭제한다. 혹시 변경사항이 있다면 yml 야멜 파일에서 create로 바꾸고 실행해야 된다 ~~ 
	private MyCarDto mycar;
	
	@Column // name 생략하면 변수이름으로 컬럼 만들어짐 length 생략하면 255
	private String comment;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "Asia/Seoul") //댓글 출력은 ajax로 처리하기 위해 포멧한다네요
	@Column(updatable = false) //수정 시 수정컬럼에서 제외
	@CreationTimestamp //now() 같이 현재 시간이 자동등록
	private Timestamp writeday;
	
}
