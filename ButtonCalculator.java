package com.beginner;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class ButtonCalculator extends JFrame implements ActionListener{

        protected JTextField output;
        protected JButton buttons[][];

        public ButtonCalculator(){

            super("Button Calculator developed by WonJohn Choi in G.Y.G.D. Copied for personal use.");
            initGUI();
            initLogic();
        }
        public void initGUI(){
            output = new JTextField("Rounded to 9th decimal place");
            output.setEditable(false);
            add(output, "North");

            String name[][] = {
                    "7 8 9 + - * /".split(" "),
                    "4 5 6 sin cos asin acos".split(" "),
                    "1 2 3 tan atan sqrt cbrt".split(" "),
                    "0 . = CR PI E ^".split(" ")
            };
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new GridLayout(name.length, name[0].length));

            buttons = new JButton[name.length][name[0].length];
            for(int row = 0;row < buttons.length;row++) {
                for (int col = 0; col < buttons[0].length; col++) {
                    buttons[row][col] = new JButton(name[row][col]);
                    buttons[row][col].addActionListener(this);
                    buttons[row][col].setBorder(new LineBorder(Color.getHSBColor(0, 0, 0.8f)));
                    buttonPanel.add(buttons[row][col]);
                }
            }
            add(buttonPanel,"Center");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(500, 200);
            setResizable(false);
            setVisible(true);
        }
        protected double curValue = 0;
        protected final String[] values = "0 1 2 3 4 5 6 7 8 9 PI E".split(" ");
        protected final String[] functions = "sin cos tan asin acos atan sqrt cbrt log10".split(" ");


        public void initLogic(){
            Arrays.sort(values);
            Arrays.sort(functions);
     }
     protected String oper = "=";
     protected boolean isStart = true;

     public void actionPerformed(ActionEvent e){
         String input = (String) e.getActionCommand();

         if(input.equals(".")) {
             if (!output.getText().contains(".")) {
                 if (isStart) {
                     output.setText("0.");
                     isStart = false;
                 } else {
                     output.setText(output.getText() + ".");
                 }
             }
         }else  if (input.equals("PI")) {
             output.setText("" + Math.PI);
             isStart = false;
         }else if (input.equals("E")){
                output.setText(""+Math.E);
         }else if(input.equals("CR")){
             curValue = 0;
             output.setText("");
             oper = "=";
             isStart = true;
         }else if (Arrays.binarySearch(values, input)>=0){
             if(isStart){
                 output.setText(input);
             }else {
                 output.setText(output.getText() + input);
             }
         isStart =false;
         }else if(Arrays.binarySearch(functions, input)>=0){
             computeFunc(input);
             isStart = true;

         }else {
             if(isStart){
                 if (input.equals("-") && output.equals("")){
                     output.setText(input);
                     isStart = false;
                 }else oper = input;
             }else {
                 computeOper(Double.parseDouble(output.getText()));
                 oper = input;
                 isStart = true;
             }
         }
     }
private void computeOper(double d){
         if (oper.equals("+"))
             curValue += d;
         else if (oper.equals("-"))
             curValue -= d;
         else if (oper.equals("*"))
             curValue *= d;
         else if(oper.equals("/"))
             curValue /= d;
         else if (oper.equals("="))
             curValue = d;
         else if (oper.equals("^"))
             curValue = Math.pow(curValue, d);
         else
             System.err.print("Non-existence Operator Error");
         output.setText(String.format("%.9f", curValue));
}

private void computeFunc(String input){
         curValue = Double.parseDouble(output.getText());
         if (input.equals("sin")){
            curValue = Math.sin(Math.toRadians(curValue));
         }else if (input.equals("cos")){
             curValue = Math.cos(Math.toRadians(curValue));
         }else if (input.equals("tan")){
             curValue = Math.tan(Math.toRadians(curValue));
         }else if (input.equals("asin")){
             curValue = Math.toDegrees(Math.asin(curValue));
         }else if (input.equals("acos")){
             curValue = Math.toDegrees(Math.acos(curValue));
         }else if(input.equals("atan")){
             curValue = Math.toDegrees(Math.atan(curValue));
         }else if (input.equals("sqrt")){
             curValue = Math.sqrt(curValue);
         }else if (input.equals("cbrt")){
             curValue = Math.cbrt(curValue);
         }else if (input.equals("log10")){
             curValue = Math.log10(curValue);
         }else {
             System.err.println("Non-existence function Error");
         }
         output.setText(String.format("%.9f", curValue));
}
    public static void main(String args[]){
        new ButtonCalculator();
    }
    }
