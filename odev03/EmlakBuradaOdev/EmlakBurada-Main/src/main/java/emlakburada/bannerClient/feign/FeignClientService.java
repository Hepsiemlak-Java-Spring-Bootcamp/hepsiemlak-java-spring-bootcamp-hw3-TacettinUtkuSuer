package emlakburada.bannerClient.feign;

import emlakburada.bannerClient.request.BannerRequest;
import emlakburada.bannerClient.response.BannerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "feign-service", url = "http://localhost:8081", configuration = BannerResponse.class)
public interface FeignClientService {

        @PostMapping("/banners")
        String saveBannerp2(@RequestBody BannerRequest request);
}