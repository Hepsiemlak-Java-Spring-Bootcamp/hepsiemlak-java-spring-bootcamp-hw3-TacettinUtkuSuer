package emlakburada.bannerClient.response;

import emlakburada.bannerClient.request.AddressRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BannerResponse {

	private int advertNo;
	private String phone;
	private int total;
	private AddressRequest address;

}
