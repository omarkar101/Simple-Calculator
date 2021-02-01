package gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Calculator extends JFrame {

	private JPanel contentPane;
	private JTextField ExpressionTextField;
	private String exp = new String("");
	private String memory = new String("0");

	

	/**
	 * Create the frame.
	 */
	public Calculator() {
		setResizable(false);
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 310, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ExpressionTextField = new JTextField();
		ExpressionTextField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		ExpressionTextField.setText("0");
		ExpressionTextField.setBounds(5, 11, 300, 26);
		ExpressionTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(ExpressionTextField);
		ExpressionTextField.setColumns(10);
		
		JButton MCButton = new JButton("MC");
		MCButton.setBounds(5, 45, 55, 30);
		contentPane.add(MCButton);
		MCButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				memory = "0";
			}
		});
		
		JButton MRButton = new JButton("MR");
		MRButton.setBounds(67, 45, 56, 30);
		contentPane.add(MRButton);
		MRButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ExpressionTextField.setText(memory);
				if(!memory.equals("0"))
					exp = memory;
			}
		});
		
		JButton MSButton = new JButton("MS");
		MSButton.setBounds(129, 45, 56, 30);
		contentPane.add(MSButton);
		MSButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				memory = ExpressionTextField.getText();
			}
		});
		
		JButton MPlusButton = new JButton("M+");
		MPlusButton.setBounds(191, 45, 56, 30);
		contentPane.add(MPlusButton);
		MPlusButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double newMem = Double.parseDouble(memory);
				double oldMem = Double.parseDouble(ExpressionTextField.getText());
				newMem += oldMem;
				memory = Double.toString(newMem);
			}
		});
		
		JButton MMinusButton = new JButton("M-");
		MMinusButton.setBounds(253, 45, 55, 30);
		contentPane.add(MMinusButton);
		MMinusButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double newMem = Double.parseDouble(ExpressionTextField.getText());
				double oldMem = Double.parseDouble(memory);
				newMem = oldMem - newMem;
				memory = Double.toString(newMem);
			}
		});
		
		JButton RightParenthesisButton = new JButton(")");
		RightParenthesisButton.setBounds(253, 83, 52, 27);
		contentPane.add(RightParenthesisButton);
		RightParenthesisButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!ExpressionTextField.getText().equals("0"))
					exp = ExpressionTextField.getText();
				exp = exp + ")";
				ExpressionTextField.setText(exp);
			}
		});
		
		JButton LeftParenthesisButton = new JButton("(");
		LeftParenthesisButton.setBounds(191, 83, 52, 27);
		contentPane.add(LeftParenthesisButton);
		LeftParenthesisButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!ExpressionTextField.getText().equals("0"))
					exp = ExpressionTextField.getText();
				exp = exp + "(";
				ExpressionTextField.setText(exp);
			}
		});
		
		JButton CButton = new JButton("C");
		CButton.setBounds(129, 83, 52, 27);
		contentPane.add(CButton);
		CButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exp = "";
				ExpressionTextField.setText("0");
			}
		});
		
		JButton DelButton = new JButton("DEL");
		DelButton.setBounds(5, 83, 114, 27);
		contentPane.add(DelButton);
		DelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!ExpressionTextField.getText().equals("0"))
					exp = ExpressionTextField.getText();
				if(exp.length()>1)
					exp = exp.substring(0, exp.length()-1);
				else if(exp.length() == 1)
					exp = "";
				if(exp.length() == 0)
					ExpressionTextField.setText("0");
				else
					ExpressionTextField.setText(exp);
			}
		});
		
		JButton EqualButton = new JButton("=");
		EqualButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exp = ExpressionTextField.getText();
				try {
					exp = Double.toString(expression.evaluation.PostFixCompute.computePostFix(expression.evaluation.InfixToPostfix.infixToPostfix(exp)));
					ExpressionTextField.setText(exp);
				}catch(Exception c)
				{
					
				}
			}
		});
		EqualButton.setBounds(253, 121, 52, 141);
		contentPane.add(EqualButton);
		
		JButton SlashButton = new JButton("/");
		SlashButton.setBounds(191, 121, 52, 27);
		contentPane.add(SlashButton);
		SlashButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!ExpressionTextField.getText().equals("0"))
					exp = ExpressionTextField.getText();
				exp = exp + "/";
				ExpressionTextField.setText(exp);
			}
		});
		
		JButton NineButton = new JButton("9");
		NineButton.setBounds(129, 121, 52, 27);
		contentPane.add(NineButton);
		NineButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!ExpressionTextField.getText().equals("0"))
					exp = ExpressionTextField.getText();
				exp = exp + "9";
				ExpressionTextField.setText(exp);
			}
		});
		
		JButton EightButton = new JButton("8");
		EightButton.setBounds(67, 121, 52, 27);
		contentPane.add(EightButton);
		EightButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!ExpressionTextField.getText().equals("0"))
					exp = ExpressionTextField.getText();
				exp = exp + "8";
				ExpressionTextField.setText(exp);
			}
		});
		
		JButton SevenButton = new JButton("7");
		SevenButton.setBounds(5, 121, 52, 27);
		contentPane.add(SevenButton);
		SevenButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!ExpressionTextField.getText().equals("0"))
					exp = ExpressionTextField.getText();
				exp = exp + "7";
				ExpressionTextField.setText(exp);
			}
		});
		
		JButton MultiplyButton = new JButton("*");
		MultiplyButton.setBounds(191, 159, 52, 27);
		contentPane.add(MultiplyButton);
		MultiplyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!ExpressionTextField.getText().equals("0"))
					exp = ExpressionTextField.getText();
				exp = exp + "*";
				ExpressionTextField.setText(exp);
			}
		});
		
		JButton SixButton = new JButton("6");
		SixButton.setBounds(129, 159, 52, 27);
		contentPane.add(SixButton);
		SixButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!ExpressionTextField.getText().equals("0"))
					exp = ExpressionTextField.getText();
				exp = exp + "6";
				ExpressionTextField.setText(exp);
			}
		});
		
		JButton FiveButton = new JButton("5");
		FiveButton.setBounds(67, 159, 52, 27);
		contentPane.add(FiveButton);
		FiveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!ExpressionTextField.getText().equals("0"))
					exp = ExpressionTextField.getText();
				exp = exp + "5";
				ExpressionTextField.setText(exp);
			}
		});
		
		JButton FourButton = new JButton("4");
		FourButton.setBounds(5, 159, 52, 27);
		contentPane.add(FourButton);
		FourButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!ExpressionTextField.getText().equals("0"))
					exp = ExpressionTextField.getText();
				exp = exp + "4";
				ExpressionTextField.setText(exp);
			}
		});
		
		JButton MinusButton = new JButton("-");
		MinusButton.setBounds(191, 197, 52, 27);
		contentPane.add(MinusButton);
		MinusButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!ExpressionTextField.getText().equals("0"))
					exp = ExpressionTextField.getText();
				exp = exp + "-";
				ExpressionTextField.setText(exp);
			}
		});
		
		JButton ThreeButton = new JButton("3");
		ThreeButton.setBounds(129, 197, 52, 27);
		contentPane.add(ThreeButton);
		ThreeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!ExpressionTextField.getText().equals("0"))
					exp = ExpressionTextField.getText();
				exp = exp + "3";
				ExpressionTextField.setText(exp);
			}
		});
		
		JButton TwoButton = new JButton("2");
		TwoButton.setBounds(67, 197, 52, 27);
		contentPane.add(TwoButton);
		TwoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!ExpressionTextField.getText().equals("0"))
					exp = ExpressionTextField.getText();
				exp = exp + "2";
				ExpressionTextField.setText(exp);
			}
		});
		
		JButton OneButton = new JButton("1");
		OneButton.setBounds(5, 197, 52, 27);
		contentPane.add(OneButton);
		OneButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!ExpressionTextField.getText().equals("0"))
					exp = ExpressionTextField.getText();
				exp = exp + "1";
				ExpressionTextField.setText(exp);
			}
		});
		
		JButton PlusButton = new JButton("+");
		PlusButton.setBounds(191, 235, 52, 27);
		contentPane.add(PlusButton);
		PlusButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!ExpressionTextField.getText().equals("0"))
					exp = ExpressionTextField.getText();
				exp = exp + "+";
				ExpressionTextField.setText(exp);
			}
		});
		
		JButton DotButton = new JButton(".");
		DotButton.setBounds(129, 235, 52, 27);
		contentPane.add(DotButton);
		DotButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!ExpressionTextField.getText().equals("0"))
					exp = ExpressionTextField.getText();
				exp = exp + ".";
				ExpressionTextField.setText(exp);
			}
		});
		
		JButton ZeroButton = new JButton("0");
		ZeroButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!ExpressionTextField.getText().equals("0"))
					exp = ExpressionTextField.getText();
				exp = exp + "0";
				ExpressionTextField.setText(exp);
			}
		});
		ZeroButton.setBounds(5, 235, 114, 27);
		contentPane.add(ZeroButton);
	}
}