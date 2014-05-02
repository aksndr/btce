Ext.define('btce.store.Records', {
    extend: 'Ext.data.Store',
    model: 'btce.model.Record',
	autoLoad: true,
    buffered: true,
    pageSize: 50,
    leadingBufferZone: 1000,
	proxy: {
		type: 'ajax',
		url: 'http://localhost:8080/services/Servlet',
		actionMethods: {
        create : 'POST',
        read   : 'GET',
        update : 'POST',
        destroy: 'POST'
    },
		reader: {
			type: 'json',
			root: 'ticker'
			//,
			//successProperty: 'success'
		}
	}	
});