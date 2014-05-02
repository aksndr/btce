Ext.define('btce.controller.Main', {
    extend: 'Ext.app.Controller',
	
	models: [
		'Record'
	],
	
	views: [
        'RecordsGrid'
    ]
	,
	
	stores: [
        'Records'
    ],
	
	//init: function() {
    //    console.log('Initialized Users! This happens before the Application launch function is called');
    //}
});
