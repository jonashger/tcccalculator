/**
 * 
 */
package br.edu.unoesc.edi.tccalculator.util;

/**
 * @author jonas
 *
 */
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.JApplet;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

public class Signature extends JApplet {

	public BufferedImage image = null;
	private JPanel canvas = new JPanel();
	private JPanel colorPanel = new JPanel();
	private Point lastPos = null;
	private Button captureButton = new Button("Capturar");
	private Graphics gc;
	Graphics2D imageG = null;
	private static String avaliador;

	/*
	 * (non-Javadoc)
	 * 
	 */
	public void signature(String avalr) {
		 avaliador = avalr;
		setSize(600, 200);

		image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);

		// get the image Graphics object
		imageG = image.createGraphics();
		colorPanel.setLayout(new GridLayout());
		canvas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		canvas.setSize(getWidth(), getHeight());

		captureButton.setSize(100, 50);
		getContentPane().add(captureButton);
		getContentPane().add(canvas, BorderLayout.CENTER);
		setVisible(true);

		// get the Graphics Context
		gc = canvas.getGraphics();
		canvas.setBackground(Color.LIGHT_GRAY);
		gc.setColor(Color.GRAY);
		gc.fillRect(0, 0, image.getWidth(), image.getHeight());
		gc.setColor(Color.BLACK);

		imageG.setBackground(Color.GRAY);
		imageG.setColor(Color.GRAY);
		imageG.fillRect(0, 0, image.getWidth(), image.getHeight());
		imageG.setColor(Color.BLACK);

		captureButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent a) {
				try {
					Container cp = getContentPane();
					final Component comp = cp.add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
							new JScrollPane(new JTextArea()), new JScrollPane(new JTextArea())));
					// cp.add(canvas);
					

					File filetoSave = new File("avalidorSignature/"+ avaliador + ".jpeg");

					//salva assinatura com nome especifico em C:
				
					// If the file does not exist or the user gives permission,
					// save image to file.

					ImageWriter writer = null;
					ImageOutputStream ios = null;

					try {
						// Obtain a writer based on the jpeg format.

						Iterator iter;
						iter = ImageIO.getImageWritersByFormatName("jpeg");

						// Validate existence of writer.

						if (!iter.hasNext()) {
							return;
						}

						// Extract writer.

						writer = (ImageWriter) iter.next();

						// Configure writer output destination.

						ios = ImageIO.createImageOutputStream(filetoSave);
						writer.setOutput(ios);

						// Set JPEG compression quality to 95%.

						ImageWriteParam iwp = writer.getDefaultWriteParam();
						iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
						iwp.setCompressionQuality(0.95f);

						// Write the image.

						writer.write(null, new IIOImage((BufferedImage) image, null, null), iwp);
					} catch (IOException e2) {
						e2.getMessage();
					} finally {
						try {
							// Cleanup.

							if (ios != null) {
								ios.flush();
								ios.close();
							}

							if (writer != null)
								writer.dispose();
						} catch (IOException e2) {
						}
					}

				} catch (Exception e) {
					System.err.println(e);
				}
				//mostra mensagem onde a assinatura em jpeg foi salva
				JOptionPane.showMessageDialog(null, "Assinatura Salva em C: ");
			}
		});

		canvas.addMouseMotionListener(new MouseMotionListener() {
			public void mouseDragged(MouseEvent m) {
				// the mouse(pen) was dragged, so the pixels at coords found in
				// MouseEvent m must be updated with current color
				Point p = m.getPoint();
				gc.drawLine(lastPos.x, lastPos.y, p.x, p.y);
				imageG.drawLine(lastPos.x, lastPos.y, p.x, p.y);
				lastPos = p;
				
				}

			public void mouseMoved(MouseEvent m) {
			}
		});
		canvas.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
				lastPos = e.getPoint();
			}

			public void mouseReleased(MouseEvent e) {
				lastPos = null;
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}
		});
	}

	/**
	 * 
	 */


}
