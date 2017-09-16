import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import java.io.*;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by Администратор on 16.09.2017.
 */
public class ColumnModel extends DefaultTableColumnModel {
    String[] names=new String[]{"Пробег","Дата", "Объем", "Сумма", "Цена", "АЗС"};
//    private final Vector NAMES= new Vector(Arrays.asList(new String[]{"Пробег","Дата", "Объем", "Сумма", "Цена", "АЗС"}));
    public ColumnModel(Enumeration<TableColumn> columns) {
        while (columns.hasMoreElements()){
            TableColumn tableColumn=columns.nextElement();
            addColumn(tableColumn);
        }
    }

    public void saveColumnModel(){
        try {
            FileOutputStream fos=new FileOutputStream("e:/columnModel.obj");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.flush();
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ColumnModel loadColumnModel(){
        ColumnModel columnModel=null;
        try {
            FileInputStream fis=new FileInputStream("e:/columnModel.obj");
            ObjectInputStream ois=new ObjectInputStream(fis);
            columnModel= (ColumnModel) ois.readObject();
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
            return columnModel;
        }
    }


}
