package notwist.base;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Share {

	private JTable tableDiscussion;
	private DefaultTableModel modelDiscussion;
	
	public Share(JTable tableDiscussion, DefaultTableModel modelDiscussion) {
		this.tableDiscussion = tableDiscussion;
		this.modelDiscussion = modelDiscussion;
	}

	public JTable getTableDiscussion() {
		return tableDiscussion;
	}

	public void setTableDiscussion(JTable tableDiscussion) {
		this.tableDiscussion = tableDiscussion;
	}

	public DefaultTableModel getModelDiscussion() {
		return modelDiscussion;
	}

	public void setModelDiscussion(DefaultTableModel modelDiscussion) {
		this.modelDiscussion = modelDiscussion;
	}
	
	
}
