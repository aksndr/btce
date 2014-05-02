Ext.define('btce.Application', {
	requires: ['Ext.container.Viewport'],
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
                xtype: 'recordsGrid'
            }
        });
    }
});