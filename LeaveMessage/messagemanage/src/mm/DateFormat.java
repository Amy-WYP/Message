package mm;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateFormat {
    //转换date 至String
    public static String format(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    //转换String 到 date
    public static Date formatSTring(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date_ = null;
        try {
            date_ = sdf.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date_;
    }
    //将util的date转换成sql的date"yyyy-MM-dd HH:mm:ss"
    public static Timestamp utilToSqlHms(Date date){
        return new java.sql.Timestamp(date.getTime());
    }

    //将util的date转换成sql的date"yyyy-MM-dd"
    public static java.sql.Date utilToSql(Date date) {
        return new java.sql.Date(date.getTime());
    }


    //将sql的date装换成util的date
    public static Date sqlToUtil(Timestamp timestamp) {
        return new java.util.Date (timestamp.getTime());
    }


}


