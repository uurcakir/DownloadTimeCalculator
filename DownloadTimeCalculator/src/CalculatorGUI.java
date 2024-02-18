import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JProgressBar;
import java.awt.Choice;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.ComponentOrientation;
import java.awt.TextField;
import javax.swing.JFormattedTextField;

public class CalculatorGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fld_size;
	private JTextField fld_speed;
	private JTextField fld_sec;
	private JTextField fld_mins;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorGUI frame = new CalculatorGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public CalculatorGUI() {

		setForeground(new Color(128, 128, 128));
		setAutoRequestFocus(false);
		setResizable(false);
		setTitle("Download Time Calculator  | Ugur Cakir 2024");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 230);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_sizeType = new JLabel("SIZE TYPE :");
		lbl_sizeType.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		lbl_sizeType.setBounds(10, 58, 108, 45);
		contentPane.add(lbl_sizeType);

		Choice choice_sizeType = new Choice();
		choice_sizeType.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		choice_sizeType.setBounds(123, 65, 78, 31);
		choice_sizeType.add("MB");
		choice_sizeType.add("GB");
		contentPane.add(choice_sizeType);

		JLabel lbl_fileSize = new JLabel("FILE SIZE :");
		lbl_fileSize.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		lbl_fileSize.setBounds(10, 11, 108, 45);
		contentPane.add(lbl_fileSize);

		fld_size = new JTextField();
		fld_size.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		fld_size.setBorder(null);
		fld_size.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		fld_size.setBounds(123, 11, 78, 45);
		contentPane.add(fld_size);
		fld_size.setColumns(10);

		JLabel lbl_speed = new JLabel("DOWNLOAD SPEED (mbps) :");
		lbl_speed.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		lbl_speed.setBounds(218, 11, 261, 45);
		contentPane.add(lbl_speed);

		fld_speed = new JTextField();
		fld_speed.setBorder(null);
		fld_speed.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		fld_speed.setColumns(10);
		fld_speed.setBounds(485, 11, 78, 45);
		contentPane.add(fld_speed);

		JButton btn_calculate = new JButton("CALCULATE");
		btn_calculate.setBorder(null);

		btn_calculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (choice_sizeType.getSelectedItem() == "MB") {
					int size = Integer.parseInt(fld_size.getText());
					int speed = Integer.parseInt(fld_speed.getText());
					if (size > 0 && speed > 0) {

						float result = size / (speed / 8);
						fld_sec.setText(String.valueOf(result));
						DecimalFormat formatter = new DecimalFormat("#0.00");
						float f = result / 60f;
						fld_mins.setText(String.valueOf(formatter.format(f)));

					}

				} else if (choice_sizeType.getSelectedItem() == "GB") {
					int size = Integer.parseInt(fld_size.getText());
					int speed = Integer.parseInt(fld_speed.getText());
					if (size > 0 && speed > 0) {

						float result = (size * 1024) / (speed / 8);
						fld_sec.setText(String.valueOf(result));
						DecimalFormat formatter = new DecimalFormat("#0.00");
						float f = result / 60f;
						fld_mins.setText(String.valueOf(formatter.format(f)));

					}

				}

			}
		});
		btn_calculate.setBackground(new Color(192, 192, 192));
		btn_calculate.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		btn_calculate.setBounds(334, 65, 229, 31);
		contentPane.add(btn_calculate);

		JLabel lbl_results = new JLabel("--- RESULTS ---");
		lbl_results.setForeground(new Color(255, 255, 255));
		lbl_results.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_results.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		lbl_results.setBounds(10, 102, 553, 45);
		contentPane.add(lbl_results);

		JLabel lbl_seconds = new JLabel("SECONDS");
		lbl_seconds.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		lbl_seconds.setBounds(123, 140, 108, 45);
		contentPane.add(lbl_seconds);

		JLabel lbl_minutes = new JLabel("MINUTES");
		lbl_minutes.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		lbl_minutes.setBounds(455, 140, 108, 45);
		contentPane.add(lbl_minutes);

		JLabel lbl_seperator = new JLabel("|");
		lbl_seperator.setForeground(new Color(255, 255, 255));
		lbl_seperator.setBackground(new Color(255, 255, 255));
		lbl_seperator.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_seperator.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		lbl_seperator.setBounds(232, 140, 100, 45);
		contentPane.add(lbl_seperator);

		fld_sec = new JTextField("0.0");
		fld_sec.setHorizontalAlignment(SwingConstants.RIGHT);
		fld_sec.setBackground(new Color(128, 128, 128));
		fld_sec.setEditable(false);
		fld_sec.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		fld_sec.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		fld_sec.setColumns(10);
		fld_sec.setBorder(null);
		fld_sec.setBounds(40, 140, 78, 45);
		contentPane.add(fld_sec);

		fld_mins = new JTextField("0.0");

		fld_mins.setHorizontalAlignment(SwingConstants.RIGHT);
		fld_mins.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		fld_mins.setEditable(false);
		fld_mins.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		fld_mins.setColumns(5);
		fld_mins.setBorder(null);
		fld_mins.setBackground(Color.GRAY);
		fld_mins.setBounds(367, 140, 78, 45);
		contentPane.add(fld_mins);
	}
}
