import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * Created by Администратор on 15.09.2017.
 */
public class Controller {
    private View view=null;
    private DataModel dataModel=null;
    private ColumnModel columnModel =null;
    private SelectionModel selectionModel=null;

    private Controller instant=null;
    private int[] selectedRows =null;

/*
    public Controller getInstant() {
        if (instant==null){
            instant=new Controller();
        }
        return instant;
    }
*/


    public Controller(View view) {
        this.view=view;
        this.dataModel=new DataModel();
    }

    public int[] getSelectedRows() {
        return selectedRows;
    }

    public DataModel getDataModel() {
        return dataModel;
    }

    public ColumnModel getColumnModel() {
        return columnModel;
    }

    public SelectionModel getSelectionModel() {
        return selectionModel;
    }

    public void setDataModel(DataModel dataModel) {
        this.dataModel = dataModel;
    }

    public void setColumnModel(ColumnModel columnModel) {
        this.columnModel = columnModel;
    }

    public void setSelectionModel(ListSelectionModel selectionModel) {
        this.selectionModel = (SelectionModel) selectionModel;
    }

    class AddNewEmptyRowListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dataModel.addNewEmptyRow();
        }
    }

    class RemoveSelectedRowListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            dataModel.removSelectedRows(Controller.this.getSelectedRows());
        }
    }

//    TODO вынести таблицу
    class RowSelectionListener implements ListSelectionListener{
        JTable table=null;

        public RowSelectionListener(JTable table) {
            this.table = table;
        }

        @Override
        public void valueChanged(ListSelectionEvent e) {
            selectedRows =table.getSelectedRows();
        }
    }

    class SaveListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            dataModel.saveDataModel();
//            columnModel.saveColumnModel();
        }
    }

    class LoadListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            Vector<Vector> dataVector=dataModel.loadDataModel();
            dataModel.setDataVector(dataVector,dataModel.getNames());
//            columnModel=columnModel.loadColumnModel();
            view.restoreView();


        }
    }

}
