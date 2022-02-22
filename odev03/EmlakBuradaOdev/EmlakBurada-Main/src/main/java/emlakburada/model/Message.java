package emlakburada.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

	private String baslik;
	private String icerigi;
	private Date gonderilenTarih;
	private Date okunduguTarihi;
	private boolean gorulduMu;
	private int gondericiId;
	private int aliciId;
	private int MessageId;

	public Message(String baslik) {
		super();
		this.baslik = baslik;
	}

}
