package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import main.Automat;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class App_GUI implements ActionListener {
	Automat aut = new Automat(1,1,2);


	private JFrame frame;
	private JLabel lblNewLabel;
	private JSpinner letters_number;
	private JSpinner states_number;
	private JSpinner finals_number;
	private JSpinner reduced_states;
	private JLabel lblFinalsNumber;
	private JLabel lblLettersNumber;
	private JLabel lblReducedStates;
	private JLabel lblFilename;
	private JTextField txtFilename;
	private JScrollPane scrollPane;
	private JTextArea txtrGeneratedAutomaton;
	private JScrollPane scrollPane_1;
	private JTextArea txtrGeneratedWords;
	private JButton btnGenerateAutomaton;
	private JButton btnGenerateWords;
	private JLabel lblNumberOfWords;
	private JSpinner words_number;
	private JTextField txtWordToCheck;
	private JButton btnCheckWord;
	private JButton btnGenerateXml;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App_GUI window = new App_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{200, 200, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 135, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		lblNewLabel = new JLabel("States number");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		states_number = new JSpinner();
		states_number.getModel().setValue(4);
		GridBagConstraints gbc_spinner_1 = new GridBagConstraints();
		gbc_spinner_1.anchor = GridBagConstraints.WEST;
		gbc_spinner_1.ipadx = 20;
		gbc_spinner_1.insets = new Insets(0, 0, 5, 0);
		gbc_spinner_1.gridx = 1;
		gbc_spinner_1.gridy = 0;
		frame.getContentPane().add(states_number, gbc_spinner_1);
		
		lblLettersNumber = new JLabel("Letters Number");
		GridBagConstraints gbc_lblLettersNumber = new GridBagConstraints();
		gbc_lblLettersNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblLettersNumber.gridx = 0;
		gbc_lblLettersNumber.gridy = 1;
		frame.getContentPane().add(lblLettersNumber, gbc_lblLettersNumber);
		
		letters_number = new JSpinner();
		letters_number.getModel().setValue(4);
		//int x = (int) spinner.getModel().getValue();
		GridBagConstraints gbc_letters_number = new GridBagConstraints();
		gbc_letters_number.insets = new Insets(0, 0, 5, 0);
		gbc_letters_number.ipadx = 20;
		gbc_letters_number.weightx = 2;
		gbc_letters_number.anchor = GridBagConstraints.WEST;
		gbc_letters_number.gridx = 1;
		gbc_letters_number.gridy = 1;
		frame.getContentPane().add(letters_number, gbc_letters_number);
		
		lblFinalsNumber = new JLabel("Finals number");
		GridBagConstraints gbc_lblFinalsNumber = new GridBagConstraints();
		gbc_lblFinalsNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblFinalsNumber.gridx = 0;
		gbc_lblFinalsNumber.gridy = 2;
		frame.getContentPane().add(lblFinalsNumber, gbc_lblFinalsNumber);
		
		finals_number = new JSpinner();
		finals_number.getModel().setValue(1);
		GridBagConstraints gbc_finals_number = new GridBagConstraints();
		gbc_finals_number.ipadx = 20;
		gbc_finals_number.anchor = GridBagConstraints.WEST;
		gbc_finals_number.insets = new Insets(0, 0, 5, 0);
		gbc_finals_number.gridx = 1;
		gbc_finals_number.gridy = 2;
		frame.getContentPane().add(finals_number, gbc_finals_number);
		
		lblReducedStates = new JLabel("Reduced states");
		GridBagConstraints gbc_lblReducedStates = new GridBagConstraints();
		gbc_lblReducedStates.insets = new Insets(0, 0, 5, 5);
		gbc_lblReducedStates.gridx = 0;
		gbc_lblReducedStates.gridy = 3;
		frame.getContentPane().add(lblReducedStates, gbc_lblReducedStates);
		
		reduced_states = new JSpinner();
		reduced_states.getModel().setValue(1);
		GridBagConstraints gbc_reduced_states = new GridBagConstraints();
		gbc_reduced_states.ipadx = 20;
		gbc_reduced_states.anchor = GridBagConstraints.WEST;
		gbc_reduced_states.insets = new Insets(0, 0, 5, 0);
		gbc_reduced_states.gridx = 1;
		gbc_reduced_states.gridy = 3;
		frame.getContentPane().add(reduced_states, gbc_reduced_states);
		
		lblNumberOfWords = new JLabel("Words to generate number");
		GridBagConstraints gbc_lblNumberOfWords = new GridBagConstraints();
		gbc_lblNumberOfWords.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumberOfWords.gridx = 0;
		gbc_lblNumberOfWords.gridy = 5;
		frame.getContentPane().add(lblNumberOfWords, gbc_lblNumberOfWords);
		
		words_number = new JSpinner();
		GridBagConstraints gbc_words_number = new GridBagConstraints();
		gbc_words_number.anchor = GridBagConstraints.WEST;
		gbc_words_number.ipadx = 20;
		gbc_words_number.insets = new Insets(0, 0, 5, 0);
		gbc_words_number.gridx = 1;
		gbc_words_number.gridy = 5;
		frame.getContentPane().add(words_number, gbc_words_number);
		words_number.setValue(3);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 6;
		frame.getContentPane().add(scrollPane, gbc_scrollPane);
		
		txtrGeneratedAutomaton = new JTextArea();
		txtrGeneratedAutomaton.setEditable(false);
		txtrGeneratedAutomaton.setText("Generated Automaton\n");
		scrollPane.setViewportView(txtrGeneratedAutomaton);
		
		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 6;
		frame.getContentPane().add(scrollPane_1, gbc_scrollPane_1);
		
		txtrGeneratedWords = new JTextArea();
		txtrGeneratedWords.setEditable(false);
		txtrGeneratedWords.setText("Generated Words");
		scrollPane_1.setViewportView(txtrGeneratedWords);
		
		btnGenerateAutomaton = new JButton("Generate Automaton");
		GridBagConstraints gbc_btnGenerateAutomaton = new GridBagConstraints();
		gbc_btnGenerateAutomaton.insets = new Insets(0, 0, 5, 5);
		gbc_btnGenerateAutomaton.gridx = 0;
		gbc_btnGenerateAutomaton.gridy = 7;
		frame.getContentPane().add(btnGenerateAutomaton, gbc_btnGenerateAutomaton);
		btnGenerateAutomaton.addActionListener(this);
		
		btnGenerateWords = new JButton("Generate Words");
		GridBagConstraints gbc_btnGenerateWords = new GridBagConstraints();
		gbc_btnGenerateWords.insets = new Insets(0, 0, 5, 0);
		gbc_btnGenerateWords.gridx = 1;
		gbc_btnGenerateWords.gridy = 7;
		frame.getContentPane().add(btnGenerateWords, gbc_btnGenerateWords);
		btnGenerateWords.addActionListener(this);
		
		txtWordToCheck = new JTextField();
		txtWordToCheck.setText("Word_to_check");
		GridBagConstraints gbc_txtWordToCheck = new GridBagConstraints();
		gbc_txtWordToCheck.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtWordToCheck.insets = new Insets(0, 0, 5, 5);
		gbc_txtWordToCheck.gridx = 0;
		gbc_txtWordToCheck.gridy = 8;
		frame.getContentPane().add(txtWordToCheck, gbc_txtWordToCheck);
		txtWordToCheck.setColumns(10);
		
		btnCheckWord = new JButton("Check word");
		GridBagConstraints gbc_btnCheckWord = new GridBagConstraints();
		gbc_btnCheckWord.insets = new Insets(0, 0, 5, 0);
		gbc_btnCheckWord.gridx = 1;
		gbc_btnCheckWord.gridy = 8;
		frame.getContentPane().add(btnCheckWord, gbc_btnCheckWord);
		btnCheckWord.addActionListener(this);

		
		lblFilename = new JLabel("Filename");
		GridBagConstraints gbc_lblFilename = new GridBagConstraints();
		gbc_lblFilename.insets = new Insets(0, 0, 5, 5);
		gbc_lblFilename.gridx = 0;
		gbc_lblFilename.gridy = 10;
		frame.getContentPane().add(lblFilename, gbc_lblFilename);
		
		txtFilename = new JTextField();
		txtFilename.setText("automat");
		GridBagConstraints gbc_txtFilename = new GridBagConstraints();
		gbc_txtFilename.insets = new Insets(0, 0, 5, 0);
		gbc_txtFilename.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFilename.gridx = 1;
		gbc_txtFilename.gridy = 10;
		frame.getContentPane().add(txtFilename, gbc_txtFilename);
		txtFilename.setColumns(10);
		
		btnGenerateXml = new JButton("Generate XML");
		GridBagConstraints gbc_btnGenerateXml = new GridBagConstraints();
		gbc_btnGenerateXml.gridx = 1;
		gbc_btnGenerateXml.gridy = 11;
		frame.getContentPane().add(btnGenerateXml, gbc_btnGenerateXml);
		btnGenerateXml.addActionListener(this);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		int states_nbr = (int) states_number.getValue();
		int fin_nbr = (int) finals_number.getValue();
		int lett_nbr = (int) letters_number.getValue();
		int red_stat = (int) reduced_states.getValue();
		int words_nbr = (int) words_number.getValue();
		String word_to_chck = (String) txtWordToCheck.getText();
		String filename = (String) txtFilename.getText();
	
		
		if(source == btnGenerateAutomaton) {
			aut = new Automat(states_nbr, fin_nbr, lett_nbr, red_stat); //tworzy automat
			txtrGeneratedAutomaton.setText(aut.getAutomat()); //drukuje automat w oknie
			txtrGeneratedWords.setText("");
		}
		
		else if(source == btnGenerateWords) {
			String tmp = "";
			
			for(int i = 0; i < words_nbr; i++) {
				tmp += aut.getRandomWord() + "\n";
			}
			
			txtrGeneratedWords.setText(tmp);
		}
		
		else if(source == btnCheckWord) {
			if(aut.isWordInAutomat(word_to_chck)) {
				btnCheckWord.setForeground(Color.green);
			}
			else
				btnCheckWord.setForeground(Color.red);		
		}
		
		else if(source == btnGenerateXml) {
			aut.printToXML(filename);
		}
		
		
	}


}
