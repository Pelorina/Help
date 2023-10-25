package ChoseYourHelp.Help.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomResponse {
    private Integer statusCode;
    private String responseMessage;
}
