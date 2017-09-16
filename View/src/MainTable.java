import javax.swing.*;
import java.awt.*;

/**
 * Created by Администратор on 14.09.2017.
 */
public class MainTable extends JFrame {
    private Controller controller=null;
    public Table table=null;

    public MainTable() throws HeadlessException {
        super("Журнал заправок");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        controller=new Controller(this);

        table=new Table();
        table.dataModel= (DataModel) table.getModel();
//        table.extraction();
//        controller.setColumnModel((ColumnModel)table.getColumnModel());
//        controller.setSelectionModel(table.getSelectionModel());

        getContentPane().add(new JScrollPane(table));
        table.setRowSelectionAllowed(true);

        JButton addNewEmptyRowButton =new JButton("Добавить запись");
        addNewEmptyRowButton.addActionListener(controller.new AddNewEmptyRowListener());

        JButton removeSelectedRowButton=new JButton("Удалить запись");
        removeSelectedRowButton.addActionListener(controller.new RemoveSelectedRowListener());

        JButton saveDataModelButton=new JButton("save");
        saveDataModelButton.addActionListener(controller.new SaveListener());

        JButton loadDataModelButon=new JButton("load");
        loadDataModelButon.addActionListener(controller.new LoadListener());


        table.getSelectionModel().addListSelectionListener(controller.new RowSelectionListener(table));


        JPanel buttonPanel=new JPanel();
        buttonPanel.add(addNewEmptyRowButton);
        buttonPanel.add(removeSelectedRowButton);
        buttonPanel.add(saveDataModelButton);
        buttonPanel.add(loadDataModelButon);

        getContentPane().add(buttonPanel,BorderLayout.SOUTH );


        setLocation(500,500);
        setSize(800,500);
        setVisible(true);
    }

    public void restoreView(){
        table.setModel(controller.getDataModel());
        table.setColumnModel(controller.getColumnModel());
        table.setSelectionModel(controller.getSelectionModel());
    }


}
