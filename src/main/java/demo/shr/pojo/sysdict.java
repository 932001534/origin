package demo.shr.pojo;



/**
 * @author shr
 * @create 2024--09--03 11:08
 */

public class sysdict {

    private String code;
    private String item1;



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getItem() {
        return item1;
    }

    public void setItem(String item) {
        this.item1 = item1;
    }

    @Override
    public String toString() {
        return "sysdict{" +
                ", code='" + code + '\'' +
                ", item='" + item1 + '\'' +
                '}';
    }
}
