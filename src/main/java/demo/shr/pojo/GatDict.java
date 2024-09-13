package demo.shr.pojo;

/**
 * @author shr
 * @create 2024--09--05 17:34
 */
public class GatDict {
    private String gatcode;
    private String gatvalue;
    private String sqcode;
    private String sqvalue;

    public String getSqcode() {
        return sqcode;
    }

    public void setSqcode(String sqcode) {
        this.sqcode = sqcode;
    }

    public String getSqvalue() {
        return sqvalue;
    }

    public void setSqvalue(String sqvalue) {
        this.sqvalue = sqvalue;
    }

    public String getGatcode() {
        return gatcode;
    }

    public void setGatcode(String gatcode) {
        this.gatcode = gatcode;
    }

    public String getGatvalue() {
        return gatvalue;
    }

    public void setGatvalue(String gatvalue) {
        this.gatvalue = gatvalue;
    }

    @Override
    public String toString() {
        return "GatDict{" +
                "gatcode='" + gatcode + '\'' +
                ", gatvalue='" + gatvalue + '\'' +
                ", sqcode='" + sqcode + '\'' +
                ", sqvalue='" + sqvalue + '\'' +
                '}';
    }
}
