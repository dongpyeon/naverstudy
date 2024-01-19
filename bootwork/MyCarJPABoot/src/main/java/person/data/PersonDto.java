package person.data;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="person")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PersonDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pnum;
	
	@Column(length = 20)
	private String name;
	
	@Column(length = 20)
	private String photo;
	
	@Column(length = 20)
	private String blood;
	
	private int age;
	
	@CreationTimestamp
	@Column(updatable = false) //수정 시 컬럼 제외
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone="Asia/Seoul") //이거 안하면 날짜 시간번호?로 나옴 200545454머 이딴식 
	private Timestamp writeday;
	

}
