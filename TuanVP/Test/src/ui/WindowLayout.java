package ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WindowLayout extends JFrame {
	private JFileChooser chooser = new JFileChooser();;
	private JButton btn = new JButton("Upload");

	public WindowLayout(String title) {
		super(title);
		adControllers();
		adEvents();
	}

	private void adEvents() {
		btn.addActionListener(uploadImages);
	}

	private void adControllers() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setCurrentDirectory(new File("C:\\Users\\Tuan\\Downloads"));
		pnMain.add(chooser);
		pnMain.add(btn);
		con.add(pnMain);

	}
	
	ActionListener viewImageName = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	};
	
	ActionListener uploadImages = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
				try {
					String image1 = upload1();
					String image2 = upload2();
					System.out.println(image1);
					System.out.println(image2);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
	};

	public String upload1() throws IOException {
		// tạo ngày tháng cho ảnh upload
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyymmdd");

		// lấy ảnh upload
		File file = chooser.getSelectedFile();

		// tạo tên ảnh ảnh upload
		String filename = "cach1_"+ df.format(date) + file.getName();

		// lấy tên loại ảnh upload
		String typeImage = filename.substring(filename.lastIndexOf(".") + 1);

		// nơi lưu ảnh upload
		String savePath = "images\\";

		// upload ảnh vào folder
		BufferedImage fileUpload = ImageIO.read(file);
		ImageIO.write(fileUpload, typeImage, new File(savePath + filename));
		
		
		// trả về tên ảnh upload
		return filename;
	}

	public String upload2() throws IOException {
		// tạo ngày tháng cho ảnh upload
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyymmdd");

		// lấy ảnh upload
		File file = chooser.getSelectedFile();

		// tạo tên ảnh ảnh upload
		String filename = "cach2_" +df.format(date) + file.getName();

		// nơi lưu ảnh upload
		String savePath = "images\\";
		
		// tạo luồng input ảnh upload
		InputStream input = new FileInputStream(file);

		// tạo luồng output ảnh upload
		OutputStream output = new FileOutputStream(savePath + filename);
		
		// xác định dung lượng ảnh cần đọc
		byte[] buffer = new byte[input.available()];
		
		// tạo biến đọc ảnh
		int bytesRead;
		
		// đọc và lưu ảnh vào folder
		while ((bytesRead = input.read(buffer)) != -1) {
			output.write(buffer, 0, bytesRead);
		}
		
		// đóng luồng input và output
		input.close();
		output.close();
		
		// trả về tên ảnh upload
		return filename;
	}

	public void showWindow() {
		this.setSize(500, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
