Ext.define('btce.controller.Main', {
    extend: 'Ext.app.Controller',
	
	models: [
		'Record'
	],
	
	views: [
        'MainContainer',
        'RecordsGrid',
        'ButtonBar',
        'LeftMenue'
    ],
	
	stores: [
        'Records'
    ]
	
	//init: function() {
    //    console.log('Initialized Users! This happens before the Application launch function is called');
    //}
});
