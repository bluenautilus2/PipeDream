package twofishes.pipedream.gui.view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class GridView extends AbsView implements IGridView {
	public GridView() {
		JLabel msgLabel = new JLabel("Test Label Component");
		
		super.add(msgLabel, BorderLayout.CENTER);
		super.setBorder(new EmptyBorder(8, 8, 8, 8));
	}
}
