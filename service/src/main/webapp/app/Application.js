Ext.define('btce.Application', {
	requires: ['Ext.container.Viewport','Ext.grid.column.RowNumberer'],
    name: 'btce',
    extend: 'Ext.app.Application',
    appFolder: 'app',	
	
	controllers: [
        'Main'
    ],	
	
    launch: function() {
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: {
                xtype: 'mainContainer'
            }
        });
    }
});