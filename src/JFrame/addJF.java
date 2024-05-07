package JFrame;

import DAO.studentDAO;
import entity.student;
import util.studentTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class addJF extends JFrame {
    mainJF mainJF=new mainJF();
    studentDAO studentDAO=new studentDAO();
    JPanel center_jp=null;
    JLabel sno_jl=null;
    JLabel name_jl=null;
    JLabel Birth_jl=null;
    JLabel gender_jl=null;
    JLabel phone_jl=null;
    JLabel info_jl=null;
    JTextField sno_jt=null;
    JTextField name_jt=null;
    JTextField Birth_jt=null;
    JTextField gender_jt=null;
    JTextField phone_jt=null;
    JTextArea info_jt=null;
    JPanel south_jp=null;
    JButton submit_jb=null;
    JButton cancel_jb=null;
    public addJF(){
        initJF();
        initPanel();
        setListener();
    }
    public void initJF(){
        this.setTitle("添加同学");
        this.setBounds(100,100,380,600);
        this.setVisible(true);
        this.setResizable(false);
    }
    public void initPanel(){
        center_jp=new JPanel(new FlowLayout(FlowLayout.CENTER));
        sno_jl=new JLabel("学号");
        name_jl=new JLabel("姓名");
        Birth_jl=new JLabel("生日");
        gender_jl=new JLabel("性别");
        phone_jl=new JLabel("电话");
        info_jl=new JLabel("info");
        sno_jt=new JTextField(30);
        name_jt=new JTextField(30);
        Birth_jt=new JTextField(30);
        gender_jt=new JTextField(30);
        phone_jt=new JTextField(31);
        info_jt=new JTextArea(5,28);
        sno_jt.setFont(new Font(Font.DIALOG_INPUT,Font.PLAIN,18));
        name_jt.setFont(new Font(Font.DIALOG_INPUT,Font.PLAIN,18));
        Birth_jt.setFont(new Font(Font.DIALOG_INPUT,Font.PLAIN,18));
        gender_jt.setFont(new Font(Font.DIALOG_INPUT,Font.PLAIN,18));
        phone_jt.setFont(new Font(Font.DIALOG_INPUT,Font.PLAIN,18));
        info_jt.setFont(new Font(Font.DIALOG_INPUT,Font.PLAIN,20));
        center_jp.add(sno_jl);
        center_jp.add(sno_jt);
        center_jp.add(name_jl);
        center_jp.add(name_jt);
        center_jp.add(Birth_jl);
        center_jp.add(Birth_jt);
        center_jp.add(gender_jl);
        center_jp.add(gender_jt);
        center_jp.add(phone_jl);
        center_jp.add(phone_jt);
        center_jp.add(info_jl);
        center_jp.add(info_jt);
        this.add(center_jp,BorderLayout.CENTER);
        south_jp=new JPanel(new FlowLayout(FlowLayout.CENTER));
        submit_jb=new JButton("提交");
        cancel_jb=new JButton("重置");
        south_jp.add(submit_jb);
        south_jp.add(cancel_jb);
        this.add(south_jp,BorderLayout.SOUTH);
    }
    public void setListener(){
        submit_jb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                student student=new student();
                student.setSno(sno_jt.getText());
                student.setName(name_jt.getText());
                student.setBirth(Birth_jt.getText());
                student.setGender(gender_jt.getText());
                student.setPhone(phone_jt.getText());
                studentDAO.add(student);
                addJF.this.dispose();
                mainJF.table.setModel(new studentTableModel(mainJF.pageModel));
                mainJF.showPage=new JLabel("第"+mainJF.pageModel.getPageNO()+"页/共"+
                        mainJF.pageModel.getTotalPage()+"页");
            }
        });
        cancel_jb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
    }
    public static void main(String[] args) {
        new addJF().setVisible(true);
    }
}
