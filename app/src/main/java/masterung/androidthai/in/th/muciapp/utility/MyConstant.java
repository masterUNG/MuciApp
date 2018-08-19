package masterung.androidthai.in.th.muciapp.utility;

public class MyConstant {

    //    URL
    private String urlTestString = "http://androidthai.in.th/muz/getTestMaster.php";
    private String urlAddNewUser = "http://43.229.78.211/sigvip/androidService/addUser.php";
    private String urlReadAllUser = "http://43.229.78.211/sigvip/androidService/getUser.php";
    private String urlPackageSalse = "http://43.229.78.211/sigvip/androidService/getPacket.php";


    //    Array
    private String[] column_tm_packetpoint = new String[]{
            "pack_id",
            "pack_name",
            "pack_desc",
            "pack_point",
            "pack_price",
            "pack_period",
            "status",
            "checkCode",
            "createBy",
            "createDate",
            "updateBy",
            "updateDate"
    };


    private String[] column_tm_client = new String[]{
            "client_id",
            "client_name",
            "client_lastname",
            "client_username",
            "client_password",
            "client_email",
            "client_registerDate",
            "client_phone",
            "point_balance",
            "client_pin",
            "pic_profile",
            "pic_path",
            "status",
            "checkCode",
            "createBy",
            "createDate",
            "updateBy",
            "updateDate"
    };

    public String getUrlPackageSalse() {
        return urlPackageSalse;
    }

    public String[] getColumn_tm_packetpoint() {
        return column_tm_packetpoint;
    }

    public String[] getColumn_tm_client() {
        return column_tm_client;
    }

    public String getUrlReadAllUser() {
        return urlReadAllUser;
    }

    public String getUrlAddNewUser() {
        return urlAddNewUser;
    }

    public String getUrlTestString() {
        return urlTestString;
    }
}
