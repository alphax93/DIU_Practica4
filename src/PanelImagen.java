
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanelImagen extends JPanel{
    private String ruta;

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        BufferedImage I=null;
        try{
            I=ImageIO.read(new File(".\\src\\Imagenes\\diu4-1.jpg"));
        }catch(IOException e){
            System.out.println("HolaaaaaAA");
        }
        g.drawImage(I, 0, 0, null);
    }
    public void suavizar(BufferedImage i){
        float[] difuminar ={
                0.111f, 0.111f, 0.111f,
                0.111f, 0.111f, 0.111f,
                0.111f, 0.111f, 0.111f};
        Kernel sharpkernel = new Kernel(3, 3, difuminar);
        ConvolveOp sop = new ConvolveOp(sharpkernel, ConvolveOp.EDGE_NO_OP,null);
        i = sop.filter(i, null);
    }
    
    public void Realce(BufferedImage i){
        float[] resaltar ={
                    0.f, -1.f, 0.f,
                    -1.f, 5.0f, -1.f,
                    0.f, -1.f, 0.f};
        Kernel sharpkernel = new Kernel(3, 3, resaltar);
        ConvolveOp sop = new ConvolveOp(sharpkernel, ConvolveOp.EDGE_NO_OP,null);
        i = sop.filter(i, null);
        
    }
}
