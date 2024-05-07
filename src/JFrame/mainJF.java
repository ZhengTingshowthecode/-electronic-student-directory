package JFrame;

import util.pageModel;
import util.studentTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class mainJF extends JFrame {
    JPanel north_jp=null;
    JTextField jt=null;
    JButton search_jb=null;
    JButton add_jb=null;
    JButton del_jb=null;
    JButton update_jb=null;
    JPanel south_jp=null;
    JButton first_jb=null;
    JButton last_jb=null;
    JButton next_jb=null;
    JButton pre_jb=null;
    JScrollPane jsp=null;
    JLabel showPage=null;
    pageModel pageModel=new pageModel(10);
    //这样写换页的时候就可以不用整个的换table，换table model就行
    JTable table=new JTable(new studentTableModel(pageModel));
    public mainJF(){
        initJF();
        initPanel();
        setListener();
    }
    public void initJF(){
        this.setTitle("同学录");
        this.setBounds(100,100,1166,560);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void initPanel(){
        north_jp=new JPanel(new FlowLayout(FlowLayout.CENTER));
        search_jb=new JButton("模糊查询");
        jt=new JTextField(20);
        add_jb=new JButton("添加同学");
        del_jb=new JButton("删除同学");
        update_jb=new JButton("修改");
        north_jp.add(jt);
        north_jp.add(search_jb);
        north_jp.add(add_jb);
        north_jp.add(del_jb);
        north_jp.add(update_jb);
        this.add(north_jp,BorderLayout.NORTH);
        table.setFont(new Font(Font.MONOSPACED,Font.PLAIN,15));
        table.setRowHeight(50);
        jsp=new JScrollPane(table);
        this.add(jsp,BorderLayout.CENTER);
        south_jp=new JPanel(new FlowLayout(FlowLayout.CENTER));
        first_jb=new JButton("第一页");
        last_jb=new JButton("最后一页");
        next_jb=new JButton("下一页");
        pre_jb=new JButton("上一页");
        showPage=new JLabel("第"+pageModel.getPageNO()+"页/共"+pageModel.getTotalPage()+"页");
        south_jp.add(first_jb);
        south_jp.add(pre_jb);
        south_jp.add(next_jb);
        south_jp.add(last_jb);
        south_jp.add(showPage);
        this.add(south_jp,BorderLayout.SOUTH);
    }
    public void setListener(){
        search_jb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String search_text= jt.getText();
                pageModel.setSearchText(search_text);
                table.setModel(new studentTableModel(pageModel));
                showPage=new JLabel("第"+pageModel.getPageNO()+"页/共"+pageModel.getTotalPage()+"页");
            }
        });
        add_jb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addJF add_jf=new addJF();
                add_jf.setVisible(true);


            }
        });
        del_jb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        update_jb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        first_jb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pageModel.firstPage();
                table.setModel(new studentTableModel(pageModel));
                showPage=new JLabel("第"+pageModel.getPageNO()+"页/共"+pageModel.getTotalPage()+"页");
            }
        });
        last_jb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pageModel.lastPage();
                table.setModel(new studentTableModel(pageModel));
                showPage=new JLabel("第"+pageModel.getPageNO()+"页/共"+pageModel.getTotalPage()+"页");
            }
        });
        next_jb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pageModel.nextPage();
                table.setModel(new studentTableModel(pageModel));
                showPage=new JLabel("第"+pageModel.getPageNO()+"页/共"+pageModel.getTotalPage()+"页");
            }
        });
        pre_jb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pageModel.prevPage();
                table.setModel(new studentTableModel(pageModel));
                showPage=new JLabel("第"+pageModel.getPageNO()+"页/共"+pageModel.getTotalPage()+"页");
            }
        });
    }
    public static void main(String[] args) {
        new mainJF().setVisible(true);
    }
}
