/**
 * Created by Администратор on 15.09.2017.
 */
public class Controller {
    private DataModel dataModel=null;
    private Controller instant=null;

    public Controller getInstant() {
        if (instant==null){
            instant=new Controller();
        }
        return instant;
    }

    public Controller() {
        this.dataModel = new DataModel();
    }

    public DataModel getDataModel() {
        return dataModel;
    }
}
