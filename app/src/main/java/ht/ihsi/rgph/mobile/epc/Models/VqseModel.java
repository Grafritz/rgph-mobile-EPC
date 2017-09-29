package ht.ihsi.rgph.mobile.epc.Models;

/**
 * Created by JFDuverseau on 09/26/2017.
 */
public class VqseModel extends BaseModel {

    private String VqseId;
    private String VqseNom;
    private String ComId;

    public VqseModel() {
    }

    public VqseModel(String VqseId, String VqseNom, String ComId) {
        this.VqseId = VqseId;
        this.VqseNom = VqseNom;
        this.ComId = ComId;
    }

    //region VqseModel getters and setters

    public String getVqseId() {
        return VqseId;
    }

    public void setVqseId(String vqseId) {
        VqseId = vqseId;
    }

    public String getVqseNom() {
        return VqseNom;
    }

    public void setVqseNom(String vqseNom) {
        VqseNom = vqseNom;
    }

    public String getComId() {
        return ComId;
    }

    public void setComId(String comId) {
        ComId = comId;
    }

    @Override
    public String toString() {
        return "[" + this.VqseId.toString() +"] - "+ this.VqseNom.toString();
    }
    //endregion
}
