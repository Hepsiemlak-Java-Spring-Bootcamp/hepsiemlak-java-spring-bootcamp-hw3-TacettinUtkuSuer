package emlakburada.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class MessageResponse {

    private String baslik;
    private String icerigi;
    private Date gonderilenTarih;
    private Date okunduguTarihi;
    private boolean gorulduMu;
    private int gondericiId;
    private int aliciId;
    private int MessageId;

}
