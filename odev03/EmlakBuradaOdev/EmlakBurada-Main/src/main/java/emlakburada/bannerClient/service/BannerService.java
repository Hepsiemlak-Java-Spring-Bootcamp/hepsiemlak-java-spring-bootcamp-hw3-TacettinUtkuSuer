package emlakburada.bannerClient.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import emlakburada.bannerClient.request.AddressRequest;
import emlakburada.bannerClient.request.BannerRequest;
import emlakburada.bannerClient.response.BannerResponse;

@Service
public class BannerService {

	private String bannerServiceUrl = "http://localhost:8081/banners";
	
	public void saveBanner() {
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<BannerResponse> response = restTemplate.postForEntity(bannerServiceUrl, prepareSaveBannerRequest(), BannerResponse.class);
		System.out.println(response.toString());
		
		if (response.getStatusCode() == HttpStatus.OK) {
			System.out.println(response.getBody().toString());
		} else {
			System.out.println("Banner Service Status Code: "  + response.getStatusCode());
		}
	}

	private BannerRequest prepareSaveBannerRequest() {
		BannerRequest request = new BannerRequest();
		request.setAdvertNo(0);
		request.setPhone("555");
		request.setTotal(1);
		request.setAddress(new AddressRequest("istanbul", "kadıköy", "acik adres"));
		return request;
	}

}
