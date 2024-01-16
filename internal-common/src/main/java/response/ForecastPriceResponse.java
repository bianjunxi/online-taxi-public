package response;

import lombok.Data;

/**
 * ClassName:  ForecastPriceResponse
 * Description: 预估价格响应返回对象
 *
 * @author Jay
 * @version v1.0
 */
@Data
public class ForecastPriceResponse {

    /**
     * 计算最终的价格
     */
    private double price;

}
