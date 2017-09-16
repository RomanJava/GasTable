import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.io.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.Vector;

/**
 * Created by Администратор on 14.09.2017.
 */
public class DataModel extends DefaultTableModel implements Serializable{
    private final Vector NAMES= new Vector(Arrays.asList(new String[]{"Пробег","Дата", "Объем", "Сумма", "Цена", "АЗС"}));
    static Object[] newNames=new String[]{"Пробег","Дата", "Объем", "Сумма", "Цена", "АЗС"};
    static Object[][] newEmptyRow={{new Integer(0),new Date(),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),""}};
    private Vector<Vector> datum =new Vector();
/*    private Vector<Date> date =new Vector<>();
    private Vector<BigDecimal> volumes=new Vector<>();
    private Vector<BigDecimal> sums=new Vector<>();
    private Vector<BigDecimal> prices=new Vector<>();
    private Vector<String> stations=new Vector<>();
    {datum.add(date);
    datum.add(volumes);
    datum.add(sums);
    datum.add(prices);
    datum.add(stations);
    }*/



    public DataModel() {
        super(newEmptyRow,newNames);
        setDataVector(datum);
        addNewEmptyRow();
    }

    public DataModel(Vector<Vector> datum) {
        this();
        this.datum = datum;
    }

    public void addNewEmptyRow(){
        Object[] newEmptyRow={new Integer(0),new Date(),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),""};
    }

    public static void saveDataModel(DataModel dataModel){
        try {
            FileOutputStream fos=new FileOutputStream("e:/dataModel.obj");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(dataModel.datum);
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



//    overrided and modificated methods
//    +++++++++++++++++++++++++
    public void setDataVector(Vector dataVector) {
        super.setDataVector(dataVector, NAMES);
    }

    @Override
    public void addRow(Vector rowData) {
        super.addRow(rowData);
    }

    @Override
    public void removeRow(int row) {
        super.removeRow(row);
    }
}
