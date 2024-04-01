package glab30311;

import javax.xml.crypto.Data;

public class GMultipleDataType<Dtypeone, Dtypetwo> {
    Dtypeone valueOne;
    Dtypetwo valueTwo;

    public GMultipleDataType(Dtypeone v1, Dtypetwo v2) {
        this.valueOne = v1;
        this.valueTwo = v2;
    }

    public Dtypeone getValueOne() {
        return valueOne;
    }

    public Dtypetwo getValueTwo() {
        return valueTwo;
    }

    public void setValueTwo(Dtypetwo valueTwo){
        this.valueTwo = valueTwo;
    }

    public void setValueOne(Dtypeone valueOne){
        this.valueOne = valueOne;
    }
}
