Ext.define('btce.controller.Main', {
    extend: 'Ext.app.Controller',
	
	models: [
		'Record'
	],
	
	views: [
        'MainContainer',
        'RecordsGrid',
        'RecordsChart',
        'ButtonBar'
    ],
	
	stores: [
        'Records'
    ]
});
