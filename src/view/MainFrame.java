/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import model.BattleModel;
import controller.BattleConrtoller;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author kate_
 */
public class MainFrame extends JFrame implements BattleObserver {

    private MainFrame.MyTextField nameSquard1;
    private MainFrame.MyTextField nameSquard2;
    private JComboBox<String> selectSquad;
    private JComboBox<String> selectClassWarrior;
    private MyTextField nameWarrior;
    private JButton start;
    private JButton addWarrior;
    private JButton save;
    private JTextArea resultArea;
    private JLabel error;
    private JLabel message;
  
    private BattleConrtoller controller;

    public MainFrame(BattleConrtoller controller, BattleModel model) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        super("Битва");        
        this.controller = controller;
        model.registerObserver(this);
        createView();
        createListeners();
    }

    @Override
    public void updateResult(String output) {
        start.setEnabled(false);
        resultArea.setText(output);
    }

    public void updateMessage(String msg, String errorMsg) {
        message.setText(msg);
        error.setText(errorMsg);
    }

    private void createView() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        setDefaultCloseOperation(3);
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(620, 600));
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        nameSquard1 = new MyTextField();
        nameSquard1.setText("Отряд 1");
        nameSquard2 = new MyTextField();
        nameSquard2.setText("Отряд 2");
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        selectSquad = new JComboBox(new String[]{"№1", "№2"});
        nameWarrior = new MyTextField();
        selectClassWarrior = new JComboBox(controller.getTypeWarrior());
        addWarrior = new JButton("Добавить");
        resultArea = new JTextArea(10, 10);
        resultArea.setFont(new Font(null, Font.PLAIN, 14));
        start = new JButton("Старт");
        save = new JButton("Сохранить в файл");
        save.setEnabled(false);
        message = new JLabel();
        message.setForeground(Color.green);
        error = new JLabel();
        error.setForeground(Color.red);

        GridBagConstraints gridConstraints = new GridBagConstraints();
        GridBagConstraints gridConstraintsPanel = new GridBagConstraints();
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridConstraints.gridheight = 1;
        gridConstraints.gridwidth = 1;
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        gridConstraints.weightx = 10;
        gridConstraints.insets = new Insets(10, 10, 0, 0);
        gridConstraintsPanel.fill = GridBagConstraints.BOTH;
        gridConstraintsPanel.gridheight = 1;
        gridConstraintsPanel.gridwidth = 1;
        gridConstraintsPanel.weightx = 10;
        gridConstraintsPanel.weighty = 10;
        gridConstraintsPanel.gridx = 0;
        gridConstraintsPanel.gridy = 0;
        gridConstraintsPanel.insets = new Insets(10, 10, 0, 0);
        add(new JLabel("Имя первого отряда"), gridConstraints);
        gridConstraints.gridx = 1;
        add(nameSquard1, gridConstraints);
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 1;
        add(new JLabel("Имя второго отряда"), gridConstraints);
        gridConstraints.gridx = 1;
        add(nameSquard2, gridConstraints);
        panel.add(new JLabel("Добавить бойца в отряд "), gridConstraintsPanel);
        gridConstraintsPanel.gridy = 1;
        panel.add(selectSquad, gridConstraintsPanel);
        gridConstraintsPanel.gridy = 2;
        panel.add(new JLabel("Имя: "), gridConstraintsPanel);
        gridConstraintsPanel.gridy = 3;
        panel.add(nameWarrior, gridConstraintsPanel);
        gridConstraintsPanel.gridy = 4;
        panel.add(selectClassWarrior, gridConstraintsPanel);
        gridConstraintsPanel.gridy = 5;
        panel.add(addWarrior, gridConstraintsPanel);
        gridConstraints.gridy = 2;
        gridConstraints.gridx = 0;
        add(panel, gridConstraints);
        gridConstraints.gridy = 3;
        add(new JLabel("Результаты битвы:"), gridConstraints);
        gridConstraints.gridy = 4;
        gridConstraints.gridwidth = 2;
        gridConstraints.gridheight = 10;
        gridConstraints.weighty = 1;
        gridConstraints.weightx = 1;
        add(resultArea, gridConstraints);
        JScrollPane txtAreaScroll = new JScrollPane(resultArea);
        txtAreaScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(txtAreaScroll, gridConstraints);
        gridConstraints.gridheight = 1;
        gridConstraints.gridwidth = 1;
        gridConstraints.gridy = 15;
        gridConstraints.gridx = 1;
        add(start, gridConstraints);
        gridConstraints.gridy = 16;
        add(save, gridConstraints);
        gridConstraints.gridy = 15;
        gridConstraints.gridx = 0;
        add(message, gridConstraints);
        add(error, gridConstraints);
        pack();
    }
    
    private void createListeners() {
        start.addActionListener(event -> controller.start(nameSquard1.getText(), nameSquard2.getText()));
        addWarrior.addActionListener(event -> controller.addWarrior(nameWarrior.getText(), selectSquad.getSelectedIndex(), selectClassWarrior.getSelectedItem().toString()));
    }

    private class MyTextField extends JTextField {
        public MyTextField() {
            super(10);
            setFont(new Font(null, Font.PLAIN, 14));
        }
    }
}
