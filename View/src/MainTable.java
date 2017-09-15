import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Администратор on 14.09.2017.
 */
public class MainTable extends JFrame {
    private Controller controller=null;

    public MainTable(Controller controller) throws HeadlessException {
        super("Журнал заправок");
        this.controller=controller;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        final JTable table=new JTable(controller.getDataModel());
        getContentPane().add(new JScrollPane(table));

        JButton addNewEmptyRowButton =new JButton("Добавить запись");
        addNewEmptyRowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((DataModel)table.getModel()).addNewEmptyRow();
            }
        });
        getContentPane().add(addNewEmptyRowButton,BorderLayout.SOUTH );



        setSize(400,500);
        setVisible(true);

    }
}
