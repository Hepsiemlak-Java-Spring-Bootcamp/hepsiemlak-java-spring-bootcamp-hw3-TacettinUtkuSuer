package emlakburada.bannerClient.feign;

import emlakburada.bannerClient.request.AddressRequest;
import emlakburada.bannerClient.request.BannerRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignClientController {

    private final FeignClientService feignClientService;

    public FeignClientController(FeignClientService feignClientService) {
        this.feignClientService = feignClientService;
    }

    @PostMapping("/banners")
    public String saveBannerp2(@RequestBody BannerRequest request) {
        request.setAdvertNo(1);
        request.setPhone("555 feign client");
        request.setTotal(2);
        request.setAddress(new AddressRequest("istanbul", "kadıköy", "acik adres"));
        return feignClientService.saveBannerp2(request);
    }

}