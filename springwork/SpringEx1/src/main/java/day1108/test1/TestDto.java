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

//�� ���� ������̼� == @Data

//���� 3���� ������̼��� �ϳ��� ������̼����� ���� �����ϴ�.
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

