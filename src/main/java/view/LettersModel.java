package view;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eugene on 03.10.14.
 */
public class LettersModel extends AbstractTableModel {

    private List<Letter> letters = new ArrayList<Letter>();

    public LettersModel(){

    }

    //public void setLetters(List<Letter> letters) {
//        this.letters = letters;
//    }

    @Override
    public int getRowCount() {
        return letters.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return " ";//letters.get()
        }
        return null;

    }
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "Frome";
            case 1:
                return "Topic";
            default:
            return " ";
        }
    }

}
