package util;

import entity.student;
import DAO.studentDAO;

import javax.swing.table.AbstractTableModel;
import java.util.List;


public class studentTableModel extends AbstractTableModel {
    studentDAO studentDAO=new studentDAO();
    String[]table_cols={"学号","姓名","生日","性别","电话","info"};
    List<student> list=null;
    String[][]data=null;
    public studentTableModel(pageModel pageModel){
        list=studentDAO.getStudent(pageModel);
        data=new String[list.size()][6];
        for(int i=0;i<list.size();i++){
            data[i][0]=list.get(i).getSno();
            data[i][1]=list.get(i).getName();
            data[i][2]=list.get(i).getBirth();
            data[i][3]=list.get(i).getGender();
            data[i][4]=list.get(i).getPhone();
            data[i][5]=list.get(i).getInfo();
        }
    }

    @Override
    public int getColumnCount() {
        return table_cols.length;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int index){
        return table_cols[index];
    }
}