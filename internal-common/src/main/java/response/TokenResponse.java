package response;

import lombok.Data;

/**
 * ClassName: TokenResponse
 * Description: 校验验证码成功颁发的token data中的对象
 *
 * @author Jay
 * @version v1.0
 */
@Data
public class TokenResponse {
    private String accessToken;
    private String refreshToken;
}
