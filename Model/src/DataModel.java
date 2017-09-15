import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.Vector;

/**
 * Created by Администратор on 14.09.2017.
 */
public class DataModel extends DefaultTableModel{
    private final Vector NAMES= new Vector(Arrays.asList(new String[]{"Дата", "Объем", "Сумма", "Цена", "АЗС"}));
    private Vector<Vector> datum =new Vector();
/*
    private Vector<Date> date =new Vector<>();
    private Vector<BigDecimal> volumes=new Vector<>();
    private Vector<BigDecimal> sums=new Vector<>();
    private Vector<BigDecimal> prices=new Vector<>();
    private Vector<String> stations=new Vector<>();
*/

    public DataModel() {
/*
        datum.add(date);
        datum.add(volumes);
        datum.add(sums);
        datum.add(prices);
        datum.add(stations);
*/
        setDataVector(datum,NAMES);
        addNewEmptyRow();
    }

    public void addNewEmptyRow(){
        Object[] newEmptyRow={new Date(),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),""};
        this.addRow(newEmptyRow);
    }

}
