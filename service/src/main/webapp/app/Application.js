Ext.define('btce.Application', {
	requires: ['Ext.container.Viewport','Ext.grid.column.RowNumberer',
        'Ext.chart.series.Area','Ext.chart.axis.Numeric','Ext.chart.axis.Category',
        'Ext.chart.series.Line'],
    name: 'btce',
    extend: 'Ext.app.Application',
    appFolder: 'app',	
	
	controllers: [
        'Main',
        'LeftMenuController'
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