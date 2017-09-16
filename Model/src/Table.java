import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Администратор on 16.09.2017.
 */
public class Table extends JTable {
    private static final String[] NAMES={"Пробег","Дата", "Объем", "Сумма", "Цена", "АЗС"};
    private static final Object[][] DATUM={{new Integer(0),new Date(),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),""}};


    public Table() {
//        super(DATUM,NAMES);
    }

/*
    public void extraction(){
        this.dataModel = this.getModel();
        this.columnModel = getColumnModel();
        this.selectionModel = getSelectionModel();
    }
*/

    public TableModel getDataModel() {
        return this.getModel();
    }

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
