package ht.ihsi.rgph.mobile.epc.Models;

/**
 * Created by JFDuverseau on 09/26/2017.
 */
public class KeyValueModel extends BaseModel{

    private String key;

    private String value;

    public KeyValueModel(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        //return "[" + this.key.toString() +"] - "+ this.value.toString();
        return  this.value.toString();
    }
}
