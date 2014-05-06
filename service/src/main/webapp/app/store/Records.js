Ext.define('btce.store.Records', {
    extend: 'Ext.data.Store',
    model: 'btce.model.Record',
    autoLoad: true,
    proxy: {
        type: 'ajax',
        url: 'http://localhost:8080/btce/servlet',
        actionMethods: {
            create: 'POST',
            read: 'POST',
            update: 'POST',
            destroy: 'POST'
        },
        reader: {
            type: 'json',
            root: 'ticker'
            //,
            //successProperty: 'success'
        },
        extraParams:{
            command:'getJson'
        }
    }
});