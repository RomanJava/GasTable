import javax.swing.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Администратор on 16.09.2017.
 */
public class Table extends JTable {
    public DataModel dataModel;
    public ColumnModel columnModel;
    public SelectionModel selectionModel;

/*
    static Object[] NAMES=new String[]{"Пробег","Дата", "Объем", "Сумма", "Цена", "АЗС"};
    static Object[][] EMPTYROW=new Object[][]{{new Integer(0),new Date(),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),""}};
*/


    public Table() {
        super(new Object[][]{{new Integer(0),new Date(),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),""}},
                new String[]{"Пробег","Дата", "Объем", "Сумма", "Цена", "АЗС"});
    }

/*
    public void extraction(){
        this.dataModel = this.getModel();
        this.columnModel = getColumnModel();
        this.selectionModel = getSelectionModel();
    }
*/

/*
    public DataModel getDataModel() {
        return dataModel;
    }
*/

/*
    public void setDataModel(DataModel dataModel) {
        this.dataModel = dataModel;
    }
*/


/*
    public ColumnModel getColumnModel() {
        return columnModel;
    }
*/

/*
    public void setColumnModel(ColumnModel columnModel) {
        this.columnModel = columnModel;
    }
*/


/*
    public SelectionModel getSelectionModel() {
        return selectionModel;
    }
*/

    public void setSelectionModel(SelectionModel selectionModel) {
        this.selectionModel = selectionModel;
    }
}
