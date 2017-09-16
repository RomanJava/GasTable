import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.Vector;

/**
 * Created by Администратор on 14.09.2017.
 */
public class DataModel extends DefaultTableModel{

    private static final String[] NAMES=new String[]{"Пробег","Дата", "Объем", "Сумма", "Цена", "АЗС"};
    private static final Object[][] NEWEMPTYROWS={{new Integer(0),new Date(),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),""}};
    private static final Object[] NEWEMPTYROW={new Integer(0),new Date(),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),""};


    public DataModel() {
        super(NEWEMPTYROWS,NAMES);
    }


    public void addNewEmptyRow(){
        addRow(new Vector(Arrays.asList(NEWEMPTYROW)));
    }

    public void removSelectedRows(int[] selectedRows){
        for (int i = selectedRows.length-1; i>=0; i--) {
            System.out.println(selectedRows[i]);
            removeRow(selectedRows[i]);
        }
    }

    public Vector<Object> getNames(){
        return convertToVector(NAMES);
    }

    public void saveDataModel(){
        try {
            FileOutputStream fos=new FileOutputStream("e:/dataModel.obj");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(this.getDataVector());
            oos.flush();
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Vector<Vector>  loadDataModel(){
        Vector<Vector> datum=null;
        try {
            FileInputStream fis=new FileInputStream("e:/dataModel.obj");
            ObjectInputStream ois=new ObjectInputStream(fis);
            datum= (Vector<Vector>) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            return datum;
        }
    }
}
