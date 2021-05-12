package binaryFile_Serialization.vidu;

import com.sun.scenario.effect.impl.prism.PrMergePeer;

import java.io.IOException;

public class QLSP {
    public static void main(String[] args) throws IOException {

        ProductManager productManager = new ProductManager();
        productManager.loadFile();
        productManager.managerDisplay();


    }
}
