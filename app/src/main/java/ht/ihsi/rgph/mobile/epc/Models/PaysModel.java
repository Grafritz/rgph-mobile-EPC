package ht.ihsi.rgph.mobile.epc.Models;

/**
 * Created by JFDuverseau on 09/26/2017.
 */
public class PaysModel extends BaseModel{

    private String CodePays;
    private String NomPays;

    public PaysModel() {
    }
    public PaysModel(String CodePays, String NomPays) {
        this.CodePays = CodePays;
        this.NomPays = NomPays;
    }

    //region PaysModel getters and setters

    public String getCodePays() {
        return CodePays;
    }

    public void setCodePays(String codePays) {
        CodePays = codePays;
    }

    public String getNomPays() {
        return NomPays;
    }

    public void setNomPays(String nomPays) {
        NomPays = nomPays;
    }

    @Override
    public String toString() {
        return this.NomPays.toString();
    }
    //endregion
}
