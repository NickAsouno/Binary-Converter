import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.stream.Collectors;
import javax.swing.*;

public class BinaryConverter {
static JTextField tf2;
static JTextField tf;
	public static void main(String[] args) {
		JFrame f = new JFrame("Binary Converter");
		f.setSize(280,120);
		f.setVisible(true);
		f.setResizable(false);
		
		tf = new JTextField();
		tf.setText("");
		tf.setSize(100, 20);
		tf.setBounds(20, 40, 100, 20);
		f.add(tf);
		
		tf2 = new JTextField();
		tf2.setText("");
		tf2.setSize(100, 20);
		tf2.setBounds(140, 40, 100, 20);
		f.add(tf2);
		
		JButton btntobin = new JButton("to binary");
		btntobin.setBounds(20, 10, 100, 25);
		btntobin.setBackground(Color.white);
		f.add(btntobin);
		
		ActionListener tb = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				tob();
			}
		};
		btntobin.addActionListener(tb);
		
		JButton btnfrombin = new JButton("to string");
		btnfrombin.setBounds(140, 10, 100, 25);
		btnfrombin.setBackground(Color.white);
		f.add(btnfrombin);
		
		ActionListener fb = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				fob();
			}
		};
		btnfrombin.addActionListener(fb);

	}
	
	static void tob() {
		String inputstr = tf.getText();
		String tobinedtext = toBin(inputstr);
		tf2.setText(tobinedtext);
	}
    static void fob() {
    	String inputstr = tf2.getText();
    	String pbdstr = pB(inputstr, 8, " ");
    	String fintext = Arrays.stream(pbdstr.split(" ")).map(binary -> Integer.parseInt(binary, 2)).map(Character::toString).collect(Collectors.joining());
		tf.setText(fintext);
	}
    
    public static String pB(String binary, int blockSize, String separator) {
	    List<String> result = new ArrayList<>();
	    int index = 0;
	    while (index < binary.length()) {
	        result.add(binary.substring(index, Math.min(index + blockSize, binary.length())));
	        index += blockSize;
	    }
	    return result.stream().collect(Collectors.joining(separator));
	}
    
	public static String toBin(String input) {
	    StringBuilder result = new StringBuilder();
	    char[] chars = input.toCharArray();
	    for (char aChar : chars) {
	        result.append(
	                String.format("%8s", Integer.toBinaryString(aChar))
	                        .replaceAll(" ", "0")
	        );
	    }
	    return result.toString();
	}

}
