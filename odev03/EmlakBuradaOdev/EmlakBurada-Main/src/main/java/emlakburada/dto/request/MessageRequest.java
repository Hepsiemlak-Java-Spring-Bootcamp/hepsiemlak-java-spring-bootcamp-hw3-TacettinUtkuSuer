package emlakburada.dto.request;

import lombok.Data;

@Data
public class MessageRequest {

    private String baslik;
    private String icerigi;
    private int MessageId;
    private int gondericiId;
    private int aliciId;
}
