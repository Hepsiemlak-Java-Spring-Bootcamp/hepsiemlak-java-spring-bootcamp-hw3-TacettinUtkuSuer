package emlakburada.controller;

import emlakburada.dto.request.AdvertRequest;
import emlakburada.dto.response.AdvertResponse;
import emlakburada.dto.response.FavoriIlanlarResponse;
import emlakburada.service.AdvertService;
import emlakburada.service.UserAdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdvertController {

	@Autowired
	private AdvertService advertService;

	@Autowired
	private UserAdvertService userAdvertService;

	@GetMapping(value = "/adverts")
	public ResponseEntity<List<AdvertResponse>> getAllAdvert() {
		return new ResponseEntity<>(advertService.getAllAdverts(), HttpStatus.OK);
	}

	@PostMapping(value = "/adverts")
	public ResponseEntity<AdvertResponse> createAdvert(@RequestBody AdvertRequest request) {
		return new ResponseEntity<>(advertService.saveAdvert(request), HttpStatus.CREATED);
	}

	@GetMapping(value = "/adverts/{advertNo}")
	public ResponseEntity<AdvertResponse> getAdvertByAdvertId(@PathVariable(required = false) int advertNo) {
		return new ResponseEntity<>(advertService.getAdvertByAdvertId(advertNo), HttpStatus.OK);
	}

	@GetMapping(value = "/advertsByUserId/{userNo}")
	public ResponseEntity<FavoriIlanlarResponse> getAdvertIdByUserId(@PathVariable(required = false) int userNo) {
		return new ResponseEntity<>(userAdvertService.getAdvertIdByUserId(userNo), HttpStatus.OK);
	}



}
