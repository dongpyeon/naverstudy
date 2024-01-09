package data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //세터 게터 투 스트ㅡ링 등등
@NoArgsConstructor //디폴트생성자
@AllArgsConstructor //파라미터 있는 생성자
@Builder 
public class ShopDto {
	String sangpum;
	String color;
	int su;
	int dan;
}
