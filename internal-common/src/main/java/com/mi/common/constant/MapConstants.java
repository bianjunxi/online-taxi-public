package com.mi.common.constant;

/**
 * ClassName:  MapConstants
 * Description: 调用高德地图常量类
 *
 * @author Jay
 * @version v1.0
 */
public class MapConstants {
    /**
     * 路径规划请求地址
     */
    public static final String DIRECTION_URL = "https://restapi.amap.com/v3/direction/driving";
    /**
     * 行政区划查询请求地址
     */
    public static final String DISTRICT_URL = "https://restapi.amap.com/v3/config/district";
    /**
     * 轨迹服务创建地址
     */
    public static final String SERVICE_ADD_URL = "https://tsapi.amap.com/v1/track/service/add";

    /**
     * 终端服务创建地址
     */
    public static final String TERMINAL_ADD_URL = "https://tsapi.amap.com/v1/track/terminal/add";

    public static final String TRACK_ADD_URL = "https://tsapi.amap.com/v1/track/trace/add";

    /**
     * 路径规划响应 json key值
     */
    public static final String STATUS = "status";
    public static final String ROUTE = "route";
    public static final String PATHS = "paths";
    public static final String DISTANCE = "distance";
    public static final String DURATION = "duration";
    public static final String DISTRICTS = "districts";
    public static final String ADCODE = "adcode";
    public static final String NAME = "name";
    public static final String LEVEL = "level";
    public static final String STREET = "street";


}
