package day1108.test1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Setter
//@Getter
//@ToString

//위 세개 어노테이션 == @Data

//위의 3개의 어노테이션을 하나의 어노테이션으로 설정 가능하다.
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class TestDto {
	@NonNull
	private String name;
	private String addr;
	private int age;
}

