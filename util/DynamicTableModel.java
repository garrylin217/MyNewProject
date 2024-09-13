package util;

import javax.swing.table.AbstractTableModel;



import java.util.List;




public class DynamicTableModel extends AbstractTableModel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final List<String[]> data;
    private final String[] columnNames;

    public DynamicTableModel(List<String[]> data, String[] columnNames) {
        this.data = data;
        this.columnNames = columnNames;
    }

    @Override
    public int getRowCount() {
        return data.size();
        
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex)[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void addRow(String[] rowData) {
        data.add(rowData);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }

    public void removeRow(int rowIndex) {
        data.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public void updateRow(int rowIndex, String[] rowData) {
        data.set(rowIndex, rowData);
        fireTableRowsUpdated(rowIndex, rowIndex);
        
    }

    public void clear() {
        int rowCount = data.size();
        if (rowCount > 0) {
            data.clear();
            fireTableRowsDeleted(0, rowCount - 1);
        }
    }
}
