package naver.storage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@Data
public class NaverConfig {
	
	@Value("https://kr.object.ncloudstorage.com")
	private String endPoint;
	
	@Value("kr-standard")
	private String regionName;
	
	@Value("KBWbeoPeKDJhL2RLATtd") //������ Ű KBWbeoPeKDJhL2RLATtd
	private String accessKey;
	
	@Value("407hL347PDkJvmhw5olS0zH481ClFmArm2gKChPd") //������ Ű  407hL347PDkJvmhw5olS0zH481ClFmArm2gKChPd
	private String secretKey;
}