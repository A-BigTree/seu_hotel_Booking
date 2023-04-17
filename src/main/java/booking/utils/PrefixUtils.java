/**
 * ==================================================
 * Project: seu_hotel_Booking
 * Package: booking.utils
 * =====================================================
 * Title: PrefixUtils.java
 * Created: [2023/4/17 20:52] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/4/17, created by Shuxin-Wang.
 * 2.
 */

package booking.utils;

import booking.entity.HotelInfo;
import booking.entity.ImagePath;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

@Slf4j
public class PrefixUtils {
    private static String PREFIX_PATH;
    //静态资源前缀
    private static String PREFIX_PAGE_IMAGE;
    //搜索页面前缀
    private static String PREFIX_HOTELS_IMAGE;
    // 详细页面前缀
    private static String SUFFIX_IMAGE;
    // 图片后缀

    //初始化静态资源配置
    static {
        Properties properties = new Properties();
        InputStream inputStream = PrefixUtils.class.getClassLoader().getResourceAsStream("static.properties");

        try{
            properties.load(inputStream);
            PREFIX_PATH = properties.getProperty("static.prefix");
            PREFIX_PAGE_IMAGE = properties.getProperty("static.page.image.prefix");
            PREFIX_HOTELS_IMAGE = properties.getProperty("static.hotels.image.prefix");
            SUFFIX_IMAGE  = properties.getProperty("static.image.suffix");
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    /**
     * 获取索引文件夹
     *
     * @author Shuxin-Wang
     * @param index 原始索引
     * @param times 变换倍数
     * @return 放缩后的文件路径
     *
     */
    private static String getIndexPath(int index, int times){
        return (int)(index/times)*times + "/";
    }

    /**
     * 初始化酒店首页展示图片路径
     *
     * @author Shuxin-Wang
     * @param hotelInfo 待初始化酒店对象
     *
     */
    public static void initPageImage(@NonNull HotelInfo hotelInfo){
        int hotelId = hotelInfo.getHotelId();
        String path = PREFIX_PATH + PREFIX_PAGE_IMAGE +
                getIndexPath(hotelId, 1000) +
                hotelId + SUFFIX_IMAGE;
        hotelInfo.setPageImage(new ImagePath(0, path));
    }

    /**
     * 初始化酒店详细页面图片列表
     *
     * @author Shuxin-Wang
     * @param hotelInfo 待初始化酒店对象
     */
    public static void initHotelsImages(@NonNull HotelInfo hotelInfo){
        int hotelId = hotelInfo.getHotelId();
        String prefixPath = PREFIX_PATH + PREFIX_HOTELS_IMAGE +
                getIndexPath(hotelId, 1000) +
                getIndexPath(hotelId, 100);
        ArrayList<ImagePath> imagePaths = new ArrayList<>();
        for(int i = 0; i < hotelInfo.getImageNum(); i++){
            imagePaths.add(new ImagePath(i,
                    prefixPath + hotelId + "_" + i + SUFFIX_IMAGE));
        }
        hotelInfo.setHotelImages(imagePaths);
    }

}
