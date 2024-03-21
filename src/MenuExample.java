import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuExample extends JFrame {
    // 构造函数
    public MenuExample() {
        // 设置框架的标题
        setTitle("界面");

        // 创建菜单栏
        MenuBar menuBar = new MenuBar();
        Font chineseFont = new Font("宋体", Font.PLAIN, 12);

        // 创建“文件”菜单及其菜单项
        Menu fileMenu = new Menu("文件");
        fileMenu.setFont(chineseFont);
        MenuItem openItem = new MenuItem("打开");
        MenuItem saveItem = new MenuItem("保存");
        MenuItem closeItem = new MenuItem("关闭");

        // 将菜单项添加到“文件”菜单
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(closeItem);

        // 创建“编辑”菜单及其菜单项
        Menu editMenu = new Menu("编辑");
        MenuItem copyItem = new MenuItem("复制");
        MenuItem pasteItem = new MenuItem("粘贴");

        // 将菜单项添加到“编辑”菜单
        editMenu.add(copyItem);
        editMenu.add(pasteItem);

        // 将菜单添加到菜单栏
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        // 将菜单栏设置到框架
        setMenuBar(menuBar);

        // 为关闭菜单项添加事件监听器
        closeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // 关闭程序
            }
        });
        JButton j;
        // 设置窗口关闭按钮的行为
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0); // 关闭程序
            }
        });

        // 设置窗口的大小
        setSize(2000, 2000);
    }

    public static void main(String[] args) {
        // 创建并显示窗口
        MenuExample example = new MenuExample();
        example.setVisible(true);
    }
}
