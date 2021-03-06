package oseam.panels;

import static org.openstreetmap.josm.tools.I18n.tr;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import oseam.Messages;
import oseam.dialogs.OSeaMAction;

public class PanelMain extends JPanel {

	private OSeaMAction dlg;
	public JLabel shapeIcon = null;
	public JLabel lightIcon = null;
	public JLabel topIcon = null;
	public JLabel radarIcon = null;
	public JLabel fogIcon = null;
	public JLabel nameLabel = null;
	public JTextField nameBox = null;
	private JButton saveButton = null;
	public ButtonGroup typeButtons = null;
	public JRadioButton chanButton = new JRadioButton(new ImageIcon(getClass().getResource("/images/ChanButton.png")));
	public JRadioButton hazButton = new JRadioButton(new ImageIcon(getClass().getResource("/images/HazButton.png")));
	public JRadioButton specButton = new JRadioButton(new ImageIcon(getClass().getResource("/images/SpecButton.png")));
	public JRadioButton lightsButton = new JRadioButton(new ImageIcon(getClass().getResource("/images/LightsButton.png")));
	private ActionListener alType = null;
	private ButtonGroup miscButtons = null;
	public JRadioButton topButton = new JRadioButton(new ImageIcon(getClass().getResource("/images/TopButton.png")));
	public JRadioButton fogButton = new JRadioButton(new ImageIcon(getClass().getResource("/images/FogButton.png")));
	public JRadioButton radButton = new JRadioButton(new ImageIcon(getClass().getResource("/images/RadarButton.png")));
	public JRadioButton litButton = new JRadioButton(new ImageIcon(getClass().getResource("/images/LitButton.png")));
	private ActionListener alMisc = null;
	private ActionListener alName = null;
	public PanelChan panelChan = null;
	public PanelHaz panelHaz = null;
	public PanelSpec panelSpec = null;
	public PanelLights panelLights = null;
	public PanelTop panelTop = null;
	public PanelFog panelFog = null;
	public PanelRadar panelRadar = null;
	public PanelLit panelLit = null;

	public PanelMain(OSeaMAction dia) {

		dlg = dia;
		panelChan = new PanelChan(dlg);
		panelChan.setBounds(new Rectangle(65, 0, 205, 160));
		panelChan.setVisible(false);
		panelHaz = new PanelHaz(dlg);
		panelHaz.setBounds(new Rectangle(65, 0, 205, 160));
		panelHaz.setVisible(false);
		panelSpec = new PanelSpec(dlg);
		panelSpec.setBounds(new Rectangle(65, 0, 205, 160));
		panelSpec.setVisible(false);
		panelLights = new PanelLights(dlg);
		panelLights.setBounds(new Rectangle(65, 0, 205, 160));
		panelLights.setVisible(false);
		panelTop = new PanelTop(dlg);
		panelTop.setBounds(new Rectangle(40, 165, 360, 160));
		panelTop.setVisible(false);
		panelFog = new PanelFog(dlg);
		panelFog.setBounds(new Rectangle(40, 165, 360, 160));
		panelFog.setVisible(false);
		panelRadar = new PanelRadar(dlg);
		panelRadar.setBounds(new Rectangle(40, 165, 360, 160));
		panelRadar.setVisible(false);
		panelLit = new PanelLit(dlg);
		panelLit.setBounds(new Rectangle(40, 165, 360, 160));
		panelLit.setVisible(false);

		shapeIcon = new JLabel();
		shapeIcon.setBounds(new Rectangle(265, 0, 130, 185));
		this.add(shapeIcon, null);
		lightIcon = new JLabel();
		lightIcon.setBounds(new Rectangle(265, 0, 125, 185));
		this.add(lightIcon, null);
		topIcon = new JLabel();
		topIcon.setBounds(new Rectangle(265, 0, 125, 185));
		this.add(topIcon, null);
		radarIcon = new JLabel();
		radarIcon.setBounds(new Rectangle(265, 0, 130, 185));
		this.add(radarIcon, null);
		fogIcon = new JLabel();
		fogIcon.setBounds(new Rectangle(265, 0, 125, 185));
		this.add(fogIcon, null);

		this.add(getButton(chanButton, 0, 0, 62, 40, "ChanTip"), null);
		this.add(getButton(hazButton, 0, 40, 62, 40, "HazTip"), null);
		this.add(getButton(specButton, 0, 80, 62, 40, "SpecTip"), null);
		this.add(getButton(lightsButton, 0, 120, 62, 40, "LightsTip"), null);
		this.add(panelChan, null);
		this.add(panelHaz, null);
		this.add(panelSpec, null);
		this.add(panelLights, null);
		this.add(panelTop, null);
		this.add(panelFog, null);
		this.add(panelRadar, null);
		this.add(panelLit, null);
		typeButtons = new ButtonGroup();
		typeButtons.add(chanButton);
		typeButtons.add(hazButton);
		typeButtons.add(specButton);
		typeButtons.add(lightsButton);
		alType = new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				if (dlg.node == null) {
					typeButtons.clearSelection();
				}
				if (chanButton.isSelected()) {
					chanButton.setBorderPainted(true);
					panelChan.setVisible(true);
				} else {
					chanButton.setBorderPainted(false);
					panelChan.setVisible(false);
					panelChan.clearSelections();
				}
				if (hazButton.isSelected()) {
					hazButton.setBorderPainted(true);
					panelHaz.setVisible(true);
				} else {
					hazButton.setBorderPainted(false);
					panelHaz.setVisible(false);
					panelHaz.clearSelections();
				}
				if (specButton.isSelected()) {
					dlg.panelMain.panelSpec.panelCol.yellowButton.doClick();
					dlg.panelMain.panelTop.enableAll(true);
					dlg.panelMain.panelTop.noTopButton.doClick();
					dlg.panelMain.panelTop.panelCol.enableAll(true);
					dlg.panelMain.panelTop.panelCol.yellowButton.doClick();
					topButton.setEnabled(true);
					fogButton.setEnabled(true);
					radButton.setEnabled(true);
					litButton.setEnabled(true);
					specButton.setBorderPainted(true);
					panelSpec.setVisible(true);
				} else {
					specButton.setBorderPainted(false);
					panelSpec.setVisible(false);
					panelSpec.clearSelections();
				}
				if (lightsButton.isSelected()) {
					fogButton.setEnabled(true);
					radButton.setEnabled(true);
					litButton.setEnabled(true);
					litButton.doClick();
					lightsButton.setBorderPainted(true);
					panelLights.setVisible(true);
				} else {
					lightsButton.setBorderPainted(false);
					panelLights.setVisible(false);
					panelLights.clearSelections();
				}
			}
		};
		chanButton.addActionListener(alType);
		hazButton.addActionListener(alType);
		specButton.addActionListener(alType);
		lightsButton.addActionListener(alType);

		this.add(getButton(topButton, 0, 165, 34, 32, "TopmarksTip"), null);
		this.add(getButton(fogButton, 0, 205, 34, 32, "FogSignalsTip"), null);
		this.add(getButton(radButton, 0, 245, 34, 32, "RadarTip"), null);
		this.add(getButton(litButton, 0, 285, 34, 32, "LitTip"), null);
		miscButtons = new ButtonGroup();
		miscButtons.add(topButton);
		miscButtons.add(fogButton);
		miscButtons.add(radButton);
		miscButtons.add(litButton);
		alMisc = new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				if (dlg.mark == null) {
					miscButtons.clearSelection();
				}
				if (topButton.isSelected()) {
					topButton.setBorderPainted(true);
					panelTop.setVisible(true);
				} else {
					topButton.setBorderPainted(false);
					panelTop.setVisible(false);
				}
				if (fogButton.isSelected()) {
					fogButton.setBorderPainted(true);
					panelFog.setVisible(true);
				} else {
					fogButton.setBorderPainted(false);
					panelFog.setVisible(false);
				}
				if (radButton.isSelected()) {
					radButton.setBorderPainted(true);
					panelRadar.setVisible(true);
				} else {
					radButton.setBorderPainted(false);
					panelRadar.setVisible(false);
				}
				if (litButton.isSelected()) {
					litButton.setBorderPainted(true);
					panelLit.setVisible(true);
				} else {
					litButton.setBorderPainted(false);
					panelLit.setVisible(false);
				}
			}
		};
		topButton.addActionListener(alMisc);
		fogButton.addActionListener(alMisc);
		radButton.addActionListener(alMisc);
		litButton.addActionListener(alMisc);

		nameLabel = new JLabel();
		nameLabel.setBounds(new Rectangle(5, 329, 60, 20));
		nameLabel.setText(tr("Name:"));
		this.add(nameLabel, null);
		nameBox = new JTextField();
		nameBox.setBounds(new Rectangle(60, 330, 200, 20));
		this.add(nameBox, null);
		alName = new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				if (dlg.mark == null)
					return;
				else
					dlg.mark.setName(nameBox.getText());
			}
		};
		nameBox.addActionListener(alName);

		saveButton = new JButton();
		saveButton.setBounds(new Rectangle(285, 330, 100, 20));
		saveButton.setText(tr("Save"));
		this.add(saveButton, null);
	}

	public void clearSelections() {
		typeButtons.clearSelection();
		alType.actionPerformed(null);
		nameBox.setText("");
		clearType();
	}

	public void clearType() {
		topButton.setEnabled(false);
		fogButton.setEnabled(false);
		radButton.setEnabled(false);
		litButton.setEnabled(false);
		miscButtons.clearSelection();
		alMisc.actionPerformed(null);
		panelChan.clearSelections();
		panelHaz.clearSelections();
		panelSpec.clearSelections();
		panelLights.clearSelections();
		panelTop.clearSelections();
		panelFog.clearSelections();
		panelRadar.clearSelections();
		panelLit.clearSelections();
		shapeIcon.setIcon(null);
		lightIcon.setIcon(null);
		topIcon.setIcon(null);
		radarIcon.setIcon(null);
		fogIcon.setIcon(null);
	}

	private JRadioButton getButton(JRadioButton button, int x, int y, int w, int h, String tip) {
		button.setBounds(new Rectangle(x, y, w, h));
		button.setBorder(BorderFactory.createLineBorder(Color.magenta, 2));
		button.setToolTipText(Messages.getString(tip));
		return button;
	}

}
