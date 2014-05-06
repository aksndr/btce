Ext.define('btce.view.RecordsGrid' ,{
    extend: 'Ext.grid.Panel',
    alias: 'widget.recordsGrid',
    id: 'btce',
    title: 'Records',
	store: 'Records',

    initComponent: function() {
        this.columns = [
        {xtype: 'rownumberer'},
		{header: 'high', dataIndex: 'high',  flex: 1}, 
		{header: 'low', dataIndex: 'low',  flex: 1},
		{header: 'avg', dataIndex: 'avg',  flex: 1},
		{header: 'last', dataIndex: 'last',  flex: 1},
		{header: 'buy', dataIndex: 'buy',  flex: 1},
		{header: 'sell', dataIndex: 'sell',  flex: 1},
		{header: 'time', dataIndex: 'time',  flex: 1}
        ];

        this.callParent(arguments);
    }
});